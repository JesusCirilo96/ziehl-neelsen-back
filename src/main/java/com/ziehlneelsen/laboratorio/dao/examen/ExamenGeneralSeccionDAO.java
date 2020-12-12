package com.ziehlneelsen.laboratorio.dao.examen;

import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionDTO;

public interface ExamenGeneralSeccionDAO {

    /**
     * Obtenemos las secciones del examen General
     * @param examenId
     * @return la lista de examenes con sus respectivas secciones
     */
    ExamenSeccionDTO getExamenSeccion(Integer examenId);

}
