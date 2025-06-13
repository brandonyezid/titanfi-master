// src/main/java/com/titanfit/repository/UsuarioRepository.java
package com.titanfit.repository;

import com.titanfit.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional; // Importar Optional

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // --- Nuevos métodos para buscar por email y username ---
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByUsername(String username);
    // --- Fin de nuevos métodos ---
}