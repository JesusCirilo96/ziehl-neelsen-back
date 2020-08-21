package com.ziehlneelsen.laboratorio.service.estudio;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.estudio.ClasificacionPacienteEntity;

import java.util.List;
import java.util.Optional;

public interface ClasificacionPacienteService {
    public List<ClasificacionPacienteEntity> findAll();

    public Optional<ClasificacionPacienteEntity> findById(Integer id);

    public ResponseDTO save(ClasificacionPacienteEntity clasificacionPaciente);
}
