package com.reclamos.reclamos.controllers;

import com.reclamos.reclamos.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> request) {
        Long id = Long.parseLong(request.get("id"));
        String password = request.get("password");

        String role = authService.login(id, password);

        if ("INVALID".equals(role)) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        return ResponseEntity.ok(role);
    }
}
