package com.example.JWTtokenSecure.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDTO {

    private Long orderId;
    private String username;
    private double totalAmount;
    private LocalDateTime orderDate;

    private List<OrderItemResponseDTO> items;

    public OrderResponseDTO(Long orderId, String username, double totalAmount, LocalDateTime orderDate, List<OrderItemResponseDTO> items) {
        this.orderId = orderId;
        this.username = username;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.items = items;
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItemResponseDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemResponseDTO> items) {
        this.items = items;
    }

    public OrderResponseDTO() {

    }



}
