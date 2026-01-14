package com.example.JWTtokenSecure.DTO;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class OrderRequestDTO {

    @NotEmpty
    private List<OrderItemRequestDTO> items;

    public OrderRequestDTO(List<OrderItemRequestDTO> items) {
        this.items = items;
    }


    public OrderRequestDTO() {
    }

    public @NotEmpty List<OrderItemRequestDTO> getItems() {
        return items;
    }

    public void setItems(@NotEmpty List<OrderItemRequestDTO> items) {
        this.items = items;
    }
}
