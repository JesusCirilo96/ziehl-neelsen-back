package com.ziehlneelsen.laboratorio.service.persona;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.persona.PacienteEntity;

import java.util.List;
import java.util.Optional;

public interface PacienteService {
    public List<PacienteEntity> findAll();

    public Optional<PacienteEntity> findById(Integer id);

    public ResponseDTO save(PacienteEntity paciente);
}
