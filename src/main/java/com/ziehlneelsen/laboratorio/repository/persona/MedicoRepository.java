package com.ziehlneelsen.laboratorio.repository.persona;

import com.ziehlneelsen.laboratorio.entities.persona.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Integer> {
    Void save (Optional<MedicoEntity> medico);
}
