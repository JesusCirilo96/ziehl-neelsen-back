package com.ziehlneelsen.laboratorio.repository.seccion;

import com.ziehlneelsen.laboratorio.entities.persona.UsuarioEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeccionRepository extends JpaRepository<SeccionEntity, Integer> {
    Void save (Optional<UsuarioEntity> usuario);
}
