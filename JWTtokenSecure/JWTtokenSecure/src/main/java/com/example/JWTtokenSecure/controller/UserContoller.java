package com.example.JWTtokenSecure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserContoller {


    @GetMapping("users")
    public String Test(){
        return "hi this is user page and secret password is :hcubdhhhyvbj873";
    }
}
