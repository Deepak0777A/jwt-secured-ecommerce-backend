package com.example.JWTtokenSecure.service;

import com.example.JWTtokenSecure.DTO.ProductRequestDTO;
import com.example.JWTtokenSecure.DTO.ProductResponseDTO;
import com.example.JWTtokenSecure.model.Category;
import com.example.JWTtokenSecure.model.Product;
import com.example.JWTtokenSecure.repo.CategoryRepository;
import com.example.JWTtokenSecure.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    public ProductResponseDTO addProduct(ProductRequestDTO dto) {

        String adminUsername = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        Category category = categoryRepo.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setImageUrl(dto.getImageUrl());
        product.setCategory(category);
        product.setCreatedBy(adminUsername);
        product.setCreatedAt(LocalDateTime.now());

        return mapToResponse(productRepo.save(product));
    }

    public void deleteProduct(Long productId) {

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        String adminUsername = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        if (!product.getCreatedBy().equals(adminUsername)) {
            throw new RuntimeException("You can delete only your own products");
        }

        productRepo.delete(product);
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private ProductResponseDTO mapToResponse(Product product) {
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
