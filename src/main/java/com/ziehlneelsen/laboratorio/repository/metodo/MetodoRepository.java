package com.ziehlneelsen.laboratorio.repository.metodo;

import com.ziehlneelsen.laboratorio.entities.metodo.MetodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MetodoRepository extends JpaRepository<MetodoEntity, Integer> {

    Void save(Optional<MetodoEntity> metodo);
}
