package com.ziehlneelsen.laboratorio.repository.metodo;

import com.ziehlneelsen.laboratorio.entities.metodo.EstudioMetodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MetodoEstudioRepository extends JpaRepository<EstudioMetodoEntity, UUID> {
    Void save(Optional<EstudioMetodoEntity> estudioMetodoEntity);
}
