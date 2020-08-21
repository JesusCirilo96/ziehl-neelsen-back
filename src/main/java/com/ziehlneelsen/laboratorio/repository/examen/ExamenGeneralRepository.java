package com.ziehlneelsen.laboratorio.repository.examen;

import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExamenGeneralRepository extends JpaRepository<ExamenGeneralEntity, Integer> {
    Void save (Optional<ExamenGeneralEntity> examenGeneral);
}
