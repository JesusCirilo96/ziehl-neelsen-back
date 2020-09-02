package com.ziehlneelsen.laboratorio.service.examen;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenSencilloEntity;

import java.util.List;
import java.util.Optional;

public interface ExamenSencilloService {

    public List<ExamenSencilloEntity> findAll();

    public Optional<ExamenSencilloEntity> findById(Integer id);

    public ResponseDTO save(ExamenSencilloEntity examen);
}
