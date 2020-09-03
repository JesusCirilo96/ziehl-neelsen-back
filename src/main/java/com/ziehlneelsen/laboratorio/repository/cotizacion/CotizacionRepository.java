package com.ziehlneelsen.laboratorio.repository.cotizacion;

import com.ziehlneelsen.laboratorio.entities.cotizacion.CotizacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CotizacionRepository extends JpaRepository<CotizacionEntity, String> {
    Void save(Optional<CotizacionEntity> cotizacion);
}
