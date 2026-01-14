package com.example.JWTtokenSecure.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryRequestDTO {

    @NotBlank(message = "Category name is required")
    @Size(min = 3, max = 50)
    private String name;

    public @NotBlank(message = "Category name is required") @Size(min = 3, max = 50) String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Category name is required") @Size(min = 3, max = 50) String name) {
        this.name = name;
    }

    public CategoryRequestDTO(String name) {
        this.name = name;
    }
}
