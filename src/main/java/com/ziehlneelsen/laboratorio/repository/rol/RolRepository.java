package com.ziehlneelsen.laboratorio.repository.rol;

import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<RolEntity, Integer> {

    Void save(Optional<RolEntity> rol);

}
