package com.ziehlneelsen.laboratorio.repository.examen;

import com.ziehlneelsen.laboratorio.entities.examen.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {
    Void save (Optional<CategoriaEntity> categoria);
}
