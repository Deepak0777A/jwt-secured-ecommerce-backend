package com.example.JWTtokenSecure.service;

import com.example.JWTtokenSecure.DTO.LoginRequest;
import com.example.JWTtokenSecure.DTO.RegisterRequest;
import com.example.JWTtokenSecure.model.Users;
import com.example.JWTtokenSecure.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserRepo repo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(RegisterRequest request) {

        if (repo.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        return repo.save(user);
    }



    public String verify(LoginRequest request) {

        Authentication authentication =
                authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()
                        )
                );

        if (authentication.isAuthenticated()) {
            Users dbUser = repo.findByUsername(request.getUsername());
            return jwtService.generateToken(
                    dbUser.getUsername(),
                    dbUser.getRole()
            );
        }

        throw new RuntimeException("Invalid username or password");
    }


}