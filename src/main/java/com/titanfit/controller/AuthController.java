// src/main/java/com/titanfit/controller/AuthController.java
package com.titanfit.controller;

import com.titanfit.dto.LoginRequest;
import com.titanfit.dto.RegisterRequest;
import com.titanfit.model.Usuario;
import com.titanfit.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    // ELIMINAMOS la inyección de PasswordEncoder del constructor
    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        // Validación de campos requeridos
        if (registerRequest.getEmail() == null || registerRequest.getEmail().trim().isEmpty() ||
                registerRequest.getPassword() == null || registerRequest.getPassword().isEmpty()) {
            return new ResponseEntity<>(Map.of("message", "Email y contraseña son requeridos."), HttpStatus.BAD_REQUEST);
        }

        // Validación si el email ya está registrado
        if (usuarioService.buscarPorEmail(registerRequest.getEmail()).isPresent()) {
            return new ResponseEntity<>(Map.of("message", "El email ya está registrado."), HttpStatus.CONFLICT);
        }

        // Validación si el nombre de usuario ya está en uso (si se proporciona)
        if (registerRequest.getUsername() != null && !registerRequest.getUsername().trim().isEmpty() &&
                usuarioService.buscarPorUsername(registerRequest.getUsername()).isPresent()) {
            return new ResponseEntity<>(Map.of("message", "El nombre de usuario ya está en uso."), HttpStatus.CONFLICT);
        }

        // Crear nuevo usuario y asignar valores
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsername(registerRequest.getUsername());
        nuevoUsuario.setEmail(registerRequest.getEmail());
        // *** IMPORTANTE: La contraseña se guarda en texto plano (sin codificar) ***
        nuevoUsuario.setPassword(registerRequest.getPassword());
        nuevoUsuario.setRole("USER"); // Asigna un rol por defecto

        try {
            Usuario usuarioGuardado = usuarioService.guardar(nuevoUsuario);
            return new ResponseEntity<>(Map.of("message", "Usuario registrado exitosamente.", "email", usuarioGuardado.getEmail()), HttpStatus.CREATED);
        } catch (Exception e) {
            // Imprime el stack trace para depuración. En producción, usarías un logger.
            e.printStackTrace();
            return new ResponseEntity<>(Map.of("message", "Error interno del servidor al registrar usuario."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        // Validación de campos requeridos
        if (loginRequest.getEmail() == null || loginRequest.getEmail().trim().isEmpty() ||
                loginRequest.getPassword() == null || loginRequest.getPassword().isEmpty()) {
            return new ResponseEntity<>(Map.of("message", "Correo y contraseña son requeridos."), HttpStatus.BAD_REQUEST);
        }

        Optional<Usuario> usuarioOptional = usuarioService.buscarPorEmail(loginRequest.getEmail());

        // Si el usuario no existe
        if (usuarioOptional.isEmpty()) {
            return new ResponseEntity<>(Map.of("message", "Correo o contraseña incorrectos"), HttpStatus.UNAUTHORIZED);
        }

        Usuario usuario = usuarioOptional.get();

        // *** CRÍTICO PARA LA DEMO SIN PasswordEncoder: Comparación de contraseñas en texto plano ***
        boolean passwordMatches = loginRequest.getPassword().equals(usuario.getPassword());

        if (passwordMatches) {
            System.out.println("Login exitoso para usuario: " + usuario.getEmail());
            return new ResponseEntity<>(Map.of("message", "Login exitoso", "email", usuario.getEmail()), HttpStatus.OK);
        } else {
            System.out.println("Intento de login fallido: contraseña incorrecta para " + loginRequest.getEmail());
            return new ResponseEntity<>(Map.of("message", "Correo o contraseña incorrectos"), HttpStatus.UNAUTHORIZED);
        }
    }
}