package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService service) {
        this.userService = service;
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestParam String username, @RequestParam String password) {
        try {
            User newUser = userService.registerUser(username, password);
            return ResponseEntity.ok("User registered: " + newUser.getUsername());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("home")
    public String home() {
        return "Welcome! You are logged in.";
    }
}
