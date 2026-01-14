package com.example.JWTtokenSecure.DTO;

import com.example.JWTtokenSecure.model.Category;
import com.example.JWTtokenSecure.model.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class mapToProduct {

    public Product mapToProduct(
            ProductRequestDTO dto,
            Category category,
            String adminUsername
    ) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setImageUrl(dto.getImageUrl());
        product.setCategory(category);
        product.setCreatedBy(adminUsername);
        product.setCreatedAt(LocalDateTime.now());
        return product;
    }

    public ProductResponseDTO mapToResponse(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        dto.setImageUrl(product.getImageUrl());
        dto.setCategoryName(product.getCategory().getName());
        dto.setCreatedBy(product.getCreatedBy());
        dto.setCreatedAt(product.getCreatedAt());
        return dto;
    }
}
