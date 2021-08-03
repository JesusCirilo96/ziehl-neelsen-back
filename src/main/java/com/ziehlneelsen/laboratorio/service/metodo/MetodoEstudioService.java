package com.ziehlneelsen.laboratorio.service.metodo;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.metodo.EstudioMetodoEntity;

public interface MetodoEstudioService {

    /**
     * Guardamos el estudio con su metodo correspondiente
     * @param estudioMetodoEntity
     * @return
     */
    ResponseDTO save(EstudioMetodoEntity estudioMetodoEntity);
}
