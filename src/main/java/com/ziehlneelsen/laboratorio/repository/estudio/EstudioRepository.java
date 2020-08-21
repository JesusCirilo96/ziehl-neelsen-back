package com.ziehlneelsen.laboratorio.repository.estudio;

import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstudioRepository extends JpaRepository<EstudioEntity, Integer> {
    Void save (Optional<EstudioEntity> estudio);
}
