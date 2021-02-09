package com.ziehlneelsen.laboratorio.repository.seccion;

import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEstudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SeccionEstudioRepository extends JpaRepository<SeccionEstudioEntity, UUID> {
    Void save (Optional<SeccionEstudioEntity> seccionEstudio);
}
