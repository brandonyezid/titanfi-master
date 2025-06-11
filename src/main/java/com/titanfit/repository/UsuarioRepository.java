// repository/UsuarioRepository.java
package com.titanfit.repository;

import com.titanfit.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos personalizados si es necesario
}