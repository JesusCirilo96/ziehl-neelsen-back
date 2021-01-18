package com.ziehlneelsen.laboratorio.repository.metodo;

import com.ziehlneelsen.laboratorio.entities.metodo.SeccionMetodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MetodoSeccionRepository extends JpaRepository<SeccionMetodoEntity, UUID> {

    Void save(Optional<SeccionMetodoEntity> metodoSeccion);
}
