package com.ziehlneelsen.laboratorio.service.estudio;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;

import java.util.List;
import java.util.Optional;

public interface EstudioService {
    public List<EstudioEntity> findAll();

    public Optional<EstudioEntity> findById(Integer id);

    public ResponseDTO save(EstudioEntity estudio);
}
