package com.ziehlneelsen.laboratorio.repository.descuento;

import com.ziehlneelsen.laboratorio.entities.descuento.PaqueteDescuentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaqueteDescuentoRepository extends JpaRepository<PaqueteDescuentoEntity, Integer> {
    Void save(Optional<PaqueteDescuentoEntity> paquete);
}
