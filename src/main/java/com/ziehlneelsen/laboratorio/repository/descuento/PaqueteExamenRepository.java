package com.ziehlneelsen.laboratorio.repository.descuento;

import com.ziehlneelsen.laboratorio.entities.descuento.PaqueteExamenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PaqueteExamenRepository extends JpaRepository<PaqueteExamenEntity, UUID> {
    Void save(Optional<PaqueteExamenEntity> paqueteExamen);
}
