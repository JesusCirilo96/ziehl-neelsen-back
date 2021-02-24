package com.ziehlneelsen.laboratorio.service.seccion;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.AuxSeccionEstudioDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.SeccionEstudioDTO;
import com.ziehlneelsen.laboratorio.entities.persona.UsuarioEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEstudioEntity;

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

    /**
     * Guardamos el estudio con su correspondiente seccion
     * @param seccionEstudio El objeto con la seccion y el estudio a guardar
     * @return Respuesta del repositorio
     */
    ResponseDTO saveSeccionEstudio(AuxSeccionEstudioDTO seccionEstudio);

    /**
     * Eliminar un estudio relacionado con la seccion
     * @param seccionId El ID  de la seccion
     * @param estudioId El ID del estudio
     * @return Respuesta del servicio
     */
    ResponseDTO deleteSeccionEstudio(Integer seccionId, Integer estudioId);

}
