package com.example.JWTtokenSecure.controller;

import com.example.JWTtokenSecure.DTO.CategoryRequestDTO;
import com.example.JWTtokenSecure.DTO.CategoryResponseDTO;
import com.example.JWTtokenSecure.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/categories")
@PreAuthorize("hasRole('ADMIN')")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoryResponseDTO createCategory(
            @Valid @RequestBody CategoryRequestDTO dto) {

        return categoryService.createCategory(dto);
    }

    @GetMapping
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryService.getAll();
    }
}

