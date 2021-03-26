package com.ziehlneelsen.laboratorio.repository.recepcion;

import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RecepcionRepository extends JpaRepository<RecepcionEntity, String> {
    Void save(Optional<RecepcionEntity> recepcion);

}
