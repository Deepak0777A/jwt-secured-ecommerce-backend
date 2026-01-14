package com.example.JWTtokenSecure.service;

import com.example.JWTtokenSecure.DTO.OrderItemRequestDTO;
import com.example.JWTtokenSecure.DTO.OrderItemResponseDTO;
import com.example.JWTtokenSecure.DTO.OrderRequestDTO;
import com.example.JWTtokenSecure.DTO.OrderResponseDTO;
import com.example.JWTtokenSecure.model.Order;
import com.example.JWTtokenSecure.model.OrderItem;
import com.example.JWTtokenSecure.model.Product;
import com.example.JWTtokenSecure.repo.OrderRepository;
import com.example.JWTtokenSecure.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ProductRepository productRepo;

    public OrderResponseDTO placeOrder(OrderRequestDTO dto) {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        Order order = new Order();
        order.setUsername(username);
        order.setOrderDate(LocalDateTime.now());

        List<OrderItem> items = new ArrayList<>();
        double total = 0;

        for (OrderItemRequestDTO itemDto : dto.getItems()) {

            Product product = productRepo.findById(itemDto.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getStock() < itemDto.getQuantity()) {
                throw new RuntimeException("Insufficient stock");
            }

            product.setStock(product.getStock() - itemDto.getQuantity());

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(product);
            item.setQuantity(itemDto.getQuantity());
            item.setPriceAtPurchase(product.getPrice());

            total += product.getPrice() * itemDto.getQuantity();
            items.add(item);
        }

        order.setItems(items);
        order.setTotalAmount(total);

        Order savedOrder = orderRepo.save(order);

        return mapToResponse(savedOrder);
    }

    public List<OrderResponseDTO> getOrdersForCurrentUser() {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return orderRepo.findByUsername(username)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private OrderResponseDTO mapToResponse(Order order) {

        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setOrderId(order.getId());
        dto.setUsername(order.getUsername());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setOrderDate(order.getOrderDate());

        List<OrderItemResponseDTO> items =
                order.getItems().stream().map(item -> {

                    OrderItemResponseDTO i = new OrderItemResponseDTO();
                    i.setProductId(item.getProduct().getId());
                    i.setProductName(item.getProduct().getName());
                    i.setQuantity(item.getQuantity());
                    i.setPriceAtPurchase(item.getPriceAtPurchase());
                    return i;

                }).toList();

        dto.setItems(items);
        return dto;
    }
}
