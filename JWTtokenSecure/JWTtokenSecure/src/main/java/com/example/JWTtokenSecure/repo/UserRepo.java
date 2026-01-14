package com.example.JWTtokenSecure.repo;
import com.example.JWTtokenSecure.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);

    boolean existsByUsername(String username);

}
