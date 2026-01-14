package com.example.JWTtokenSecure.controller;

import com.example.JWTtokenSecure.DTO.OrderRequestDTO;
import com.example.JWTtokenSecure.DTO.OrderResponseDTO;
import com.example.JWTtokenSecure.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/orders")
@PreAuthorize("hasRole('USER')")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderResponseDTO placeOrder(
            @Valid @RequestBody OrderRequestDTO dto) {

        return orderService.placeOrder(dto);
    }

    @GetMapping
    public List<OrderResponseDTO> getMyOrders() {
        return orderService.getOrdersForCurrentUser();
    }
}
