// src/main/java/com/titanfit/model/Usuario.java
package com.titanfit.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios") // El nombre de la tabla en tu base de datos
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Renombrado de 'nombre' a 'username' para consistencia con el frontend y DTO
    @Column(unique = true, nullable = false) // Asegura que el username sea único y no nulo
    private String username;

    // Renombrado de 'correo' a 'email' para consistencia
    @Column(unique = true, nullable = false) // Asegura que el email sea único y no nulo
    private String email;

    // Renombrado de 'contrasena' a 'password' para consistencia
    @Column(nullable = false)
    private String password; // Esta será la contraseña cifrada

    // Añadido el campo 'role'
    @Column(nullable = false)
    private String role; // Por ejemplo, "USER", "ADMIN", etc.

    // Constructor vacío (necesario para JPA)
    public Usuario() {}

    // Constructor con todos los campos (opcional, pero útil)
    public Usuario(Long id, String username, String email, String password, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // --- Getters y Setters actualizados con los nuevos nombres ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}