package com.ziehlneelsen.laboratorio.dao.estudio;

import com.ziehlneelsen.laboratorio.beans.examen.ReferenciaDTO;

import java.util.List;

public interface ReferenciaDAO {
    /**
     * obtenemos las referencias segun el estudio
     * @param estudio id del estudio a buscar
     * @return una lista de referencias dependiendo del estudio
     */
    List<ReferenciaDTO> getByEstudio(Integer estudio);
}
