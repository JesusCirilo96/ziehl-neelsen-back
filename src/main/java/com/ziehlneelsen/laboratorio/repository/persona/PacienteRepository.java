package com.ziehlneelsen.laboratorio.repository.persona;

import com.ziehlneelsen.laboratorio.entities.persona.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Integer> {
    Void save (Optional<PacienteEntity> paciente);

}
