package com.ziehlneelsen.laboratorio.repository.descuento;

import com.ziehlneelsen.laboratorio.entities.descuento.ExamenDescuentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ExamenDescuentoRepository extends JpaRepository<ExamenDescuentoEntity, UUID> {
    Void save(Optional<ExamenDescuentoEntity> descuentoExamen);
}
