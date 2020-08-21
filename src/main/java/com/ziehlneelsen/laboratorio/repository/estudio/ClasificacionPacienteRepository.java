package com.ziehlneelsen.laboratorio.repository.estudio;

import com.ziehlneelsen.laboratorio.entities.estudio.ClasificacionPacienteEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClasificacionPacienteRepository extends JpaRepository<ClasificacionPacienteEntity, Integer> {
    Void save (Optional<ClasificacionPacienteEntity> clasificacionPaciente);

}
