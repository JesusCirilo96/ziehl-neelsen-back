package com.ziehlneelsen.laboratorio.service.seccion;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.persona.UsuarioEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;

import java.util.List;
import java.util.Optional;

public interface SeccionService {

    public List<SeccionEntity> findAll();

    public Optional<SeccionEntity> findById(Integer id);

    public ResponseDTO save(SeccionEntity seccion);

}
