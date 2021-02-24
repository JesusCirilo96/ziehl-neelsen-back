package com.ziehlneelsen.laboratorio.dao.examen;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionDTO;

public interface ExamenGeneralSeccionDAO {

    /**
     * Obtenemos las secciones del examen General
     * @param examenId
     * @return la lista de examenes con sus respectivas secciones
     */
    ExamenSeccionDTO getExamenSeccion(Integer examenId);

    /**
     * Borramos la relacion entre la seccion y examen
     * @param examenId el ID del examen
     * @param seccionId el ID de la seccion
     * @return Respuesta del servicio
     */
    ResponseDTO deleteExamenSeccion(Integer examenId, Integer seccionId);
}
