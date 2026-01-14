package com.example.JWTtokenSecure.service;

import com.example.JWTtokenSecure.DTO.CategoryRequestDTO;
import com.example.JWTtokenSecure.DTO.CategoryResponseDTO;
import com.example.JWTtokenSecure.model.Category;
import com.example.JWTtokenSecure.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    public CategoryResponseDTO createCategory(CategoryRequestDTO dto) {

        if (categoryRepo.existsByName(dto.getName())) {
            throw new RuntimeException("Category already exists");
        }

        Category category = new Category();
        category.setName(dto.getName());

        Category saved = categoryRepo.save(category);

        return mapToResponse(saved);
    }

    public List<CategoryResponseDTO> getAll() {
        return categoryRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private CategoryResponseDTO mapToResponse(Category category) {
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }
}
