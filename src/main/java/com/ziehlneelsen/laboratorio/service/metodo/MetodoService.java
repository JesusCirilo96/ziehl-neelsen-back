package com.ziehlneelsen.laboratorio.service.metodo;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.metodo.MetodoEntity;

import java.util.List;
import java.util.Optional;

public interface MetodoService {

    public List<MetodoEntity> findAll();

    public Optional<MetodoEntity> findById(Integer id);

    public ResponseDTO save(MetodoEntity metodo);

}
