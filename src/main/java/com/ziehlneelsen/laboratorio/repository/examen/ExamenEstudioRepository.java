package com.ziehlneelsen.laboratorio.repository.examen;

import com.ziehlneelsen.laboratorio.entities.examen.ExamenEstudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ExamenEstudioRepository extends JpaRepository<ExamenEstudioEntity, UUID> {

    Void save(Optional<ExamenEstudioEntity> examenEstudio);
}
