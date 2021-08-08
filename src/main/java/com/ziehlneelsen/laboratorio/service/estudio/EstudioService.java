package com.ziehlneelsen.laboratorio.service.estudio;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioSaveDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioSelectDTO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface EstudioService {
    /**
     * obtener todos los estudios
     * @return
     */
    List<EstudioEntity> findAll();

    /**
     * Obtenemos un estudio por su ID
     * @param id El identificador del estudio
     * @return El objeto del estudio
     */
    Optional<EstudioEntity> findById(Integer id);

    /**
     * Guardarmos un estudio
     * @param estudio El objeto del estudio a guardar
     * @return Respuesta del servicio
     */
    ResponseDTO save(EstudioEntity estudio);

    /**
     * Guarmos una lista de estudios
     * @param request La peticion del front
     * @return Respuesta del servicio
     */
    ResponseDTO saveMasivo(ArrayList<EstudioSaveDTO> request);

    /**
     * Actualizamos el campo comodin del estudio
     * @param estudioId El estudio a cambiar
     * @param estado El estado a colocar
     * @return Respuesta del servicio
     */
    ResponseDTO updateComodin(Integer estudioId, Boolean estado);

    /**
     * Actualizamos los valores de seleccion de respuesta predeterminados
     * @param selectEstudio El objeto
     * @return
     */
    ResponseDTO updateSelect(EstudioSelectDTO selectEstudio);
}
