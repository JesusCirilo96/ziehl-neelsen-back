package com.ziehlneelsen.laboratorio.repository.examen;

import com.ziehlneelsen.laboratorio.entities.examen.ExamenSencilloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExamenSencilloRepository extends JpaRepository<ExamenSencilloEntity, Integer> {

    Void save (Optional<ExamenSencilloEntity> examen);
}
