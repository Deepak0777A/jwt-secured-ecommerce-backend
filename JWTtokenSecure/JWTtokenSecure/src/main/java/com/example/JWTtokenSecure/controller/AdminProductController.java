package com.example.JWTtokenSecure.controller;

import com.example.JWTtokenSecure.DTO.ProductRequestDTO;
import com.example.JWTtokenSecure.DTO.ProductResponseDTO;
import com.example.JWTtokenSecure.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/products")
@PreAuthorize("hasRole('ADMIN')")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductResponseDTO addProduct(
            @Valid @RequestBody ProductRequestDTO dto) {

        return productService.addProduct(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
