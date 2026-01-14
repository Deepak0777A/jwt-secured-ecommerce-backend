package com.example.JWTtokenSecure.DTO;

import jakarta.validation.constraints.*;

public class ProductRequestDTO {

    @NotBlank
    @Size(max = 100)
    private String name;

    @Size(max = 500)
    private String description;

    @Positive
    private double price;

    @PositiveOrZero
    private int stock;

    @NotBlank
    private String imageUrl;

    @NotNull
    private Long categoryId;// relation handled in service

    public @NotBlank @Size(max = 100) String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(max = 100) String name) {
        this.name = name;
    }

    public @Size(max = 500) String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 500) String description) {
        this.description = description;
    }

    public @Positive double getPrice() {
        return price;
    }

    public void setPrice(@Positive double price) {
        this.price = price;
    }

    public @PositiveOrZero int getStock() {
        return stock;
    }

    public void setStock(@PositiveOrZero int stock) {
        this.stock = stock;
    }

    public @NotBlank String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@NotBlank String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public @NotNull Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@NotNull Long categoryId) {
        this.categoryId = categoryId;
    }

    public ProductRequestDTO(String name, String description, double price, int stock, String imageUrl, Long categoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
    }

    public ProductRequestDTO() {
    }
}
