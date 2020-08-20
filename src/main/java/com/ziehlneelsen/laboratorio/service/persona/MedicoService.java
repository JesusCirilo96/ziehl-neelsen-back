package com.ziehlneelsen.laboratorio.service.persona;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.persona.MedicoEntity;

import java.util.List;
import java.util.Optional;

public interface MedicoService {
    public List<MedicoEntity> findAll();

    public Optional<MedicoEntity> findById(Integer id);

    public ResponseDTO save(MedicoEntity medico);
}
