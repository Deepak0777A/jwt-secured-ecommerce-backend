package com.example.JWTtokenSecure.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class OrderItemRequestDTO {

    @NotNull
    private Long productId;

    @Positive
    private int quantity;

    public OrderItemRequestDTO(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public OrderItemRequestDTO() {

    }

    public @NotNull Long getProductId() {
        return productId;
    }

    public void setProductId(@NotNull Long productId) {
        this.productId = productId;
    }

    public @Positive int getQuantity() {
        return quantity;
    }

    public void setQuantity(@Positive int quantity) {
        this.quantity = quantity;
    }
}
