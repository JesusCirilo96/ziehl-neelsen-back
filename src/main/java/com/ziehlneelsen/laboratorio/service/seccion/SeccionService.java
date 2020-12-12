package com.ziehlneelsen.laboratorio.service.seccion;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.SeccionEstudioDTO;
import com.ziehlneelsen.laboratorio.entities.persona.UsuarioEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;

import java.util.List;
import java.util.Optional;

public interface SeccionService {

    List<SeccionEntity> findAll();

    Optional<SeccionEntity> findById(Integer id);

    ResponseDTO save(SeccionEntity seccion);

    /**
     * Obtenemos los estudios dado una seccion
     * @param seccionId El id de la seccion
     * @return Lista con los estudios de la seccion
     */
    SeccionEstudioDTO getEstudioSeccion(Integer seccionId);

}
