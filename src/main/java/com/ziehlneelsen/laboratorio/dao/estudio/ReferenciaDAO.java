package com.ziehlneelsen.laboratorio.dao.estudio;

import com.ziehlneelsen.laboratorio.entities.estudio.ReferenciaEntity;

import java.util.List;

public interface ReferenciaDAO {
    /**
     * obtenemos las referencias segun el estudio
     * @param estudio id del estudio a buscar
     * @return una lista de referencias dependiendo del estudio
     */
    List<ReferenciaEntity> getByEstudio(Integer estudio);
}
