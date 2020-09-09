package com.ziehlneelsen.laboratorio.repository.descuento;

import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DescuentoRepository extends JpaRepository<DescuentoEntity, Integer> {
    Void save (Optional<DescuentoEntity> descuento);
}
