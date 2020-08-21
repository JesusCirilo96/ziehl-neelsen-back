package com.ziehlneelsen.laboratorio.repository.examen;

import com.ziehlneelsen.laboratorio.entities.examen.ExamenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExamenRepository extends JpaRepository<ExamenEntity, Integer> {

    Void save (Optional<ExamenEntity> examen);
}
