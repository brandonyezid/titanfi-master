// src/main/java/com/titanfit/dto/LoginRequest.java
package com.titanfit.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter // Genera automáticamente el método getEmail() y getPassword()
@Setter // Genera automáticamente el método setEmail() y setPassword()
@NoArgsConstructor // Genera un constructor sin argumentos (LoginRequest())
@AllArgsConstructor // Genera un constructor con todos los argumentos (LoginRequest(String email, String password))
public class LoginRequest {
    private String email;
    private String password;
}