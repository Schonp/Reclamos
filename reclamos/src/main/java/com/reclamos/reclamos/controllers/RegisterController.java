package com.reclamos.reclamos.controllers;

import com.reclamos.reclamos.services.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/vecino")
    public ResponseEntity<String> registerVecino(@RequestBody Map<String, String> request) {
        Long documento = Long.parseLong(request.get("documento"));
        String nombre = request.get("nombre");
        String apellido = request.get("apellido");
        String direccion = request.get("direccion");
        String email = request.get("email");

        registerService.registerVecino(documento, nombre, apellido, direccion, email);

        return ResponseEntity.ok("Registro exitoso. Por favor, revise su correo electrónico para obtener la contraseña.");
    }
}
