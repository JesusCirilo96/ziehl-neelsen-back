package com.ziehlneelsen.laboratorio.service.examen;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;

import java.util.List;
import java.util.Optional;

public interface ExamenGeneralService {
    public List<ExamenGeneralEntity> findAll();

    public Optional<ExamenGeneralEntity> findById(Integer id);

    public ExamenGeneralEntity findByName(String nombre);

    public ResponseDTO save(ExamenGeneralEntity examenGeneral);
}
