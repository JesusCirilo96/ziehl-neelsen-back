package com.ziehlneelsen.laboratorio.service.examen;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenEntity;

import java.util.List;
import java.util.Optional;

public interface ExamenService {

    public List<ExamenEntity> findAll();

    public Optional<ExamenEntity> findById(Integer id);

    public ResponseDTO save(ExamenEntity medico);
}
