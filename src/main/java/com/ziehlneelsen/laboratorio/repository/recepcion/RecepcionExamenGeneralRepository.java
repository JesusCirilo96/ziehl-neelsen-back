package com.ziehlneelsen.laboratorio.repository.recepcion;

import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionExamenGeneralEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RecepcionExamenGeneralRepository extends JpaRepository<RecepcionExamenGeneralEntity, UUID> {
    Void save(Optional<RecepcionExamenGeneralEntity> recepcionExamenGeneral);
}
