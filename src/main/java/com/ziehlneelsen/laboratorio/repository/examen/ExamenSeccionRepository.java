package com.ziehlneelsen.laboratorio.repository.examen;

import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralSeccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ExamenSeccionRepository extends JpaRepository<ExamenGeneralSeccionEntity, UUID> {
    Void save(Optional<ExamenGeneralSeccionEntity> examenSeccion);
}
