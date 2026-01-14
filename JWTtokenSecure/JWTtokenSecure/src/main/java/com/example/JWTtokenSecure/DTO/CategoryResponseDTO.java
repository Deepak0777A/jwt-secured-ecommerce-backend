package com.example.JWTtokenSecure.DTO;

public class CategoryResponseDTO {

    private Long id;
    private String name;


    public CategoryResponseDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryResponseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryResponseDTO() {
    }
}
