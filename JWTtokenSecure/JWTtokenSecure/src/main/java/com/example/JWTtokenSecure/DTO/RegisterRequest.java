package com.example.JWTtokenSecure.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterRequest {

    @NotBlank(message = "Username is required")
    @Size(min = 4, max = 50)
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6)
    private String password;

    @NotBlank(message = "Role is required")
    @Pattern(regexp = "USER|ADMIN", message = "Role must be USER or ADMIN")
    private String role;

    public @NotBlank(message = "Username is required") @Size(min = 4, max = 50) String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Username is required") @Size(min = 4, max = 50) String username) {
        this.username = username;
    }

    public @NotBlank(message = "Password is required") @Size(min = 6) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is required") @Size(min = 6) String password) {
        this.password = password;
    }

    public @NotBlank(message = "Role is required") @Pattern(regexp = "USER|ADMIN", message = "Role must be USER or ADMIN") String getRole() {
        return role;
    }

    public void setRole(@NotBlank(message = "Role is required") @Pattern(regexp = "USER|ADMIN", message = "Role must be USER or ADMIN") String role) {
        this.role = role;
    }

    // getters & setters

    public RegisterRequest(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

}

