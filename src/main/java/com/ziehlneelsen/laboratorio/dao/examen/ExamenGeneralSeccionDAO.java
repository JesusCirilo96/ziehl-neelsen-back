package com.ziehlneelsen.laboratorio.dao.examen;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionSaveDTO;

public interface ExamenGeneralSeccionDAO {

    /**
     * Obtenemos las secciones del examen General
     *
     * @param examenId
     * @return la lista de examenes con sus respectivas secciones
     */
    ExamenSeccionDTO getExamenSeccion(Integer examenId);

    /**
     * Borramos la relacion entre la seccion y examen
     *
     * @param examenId  el ID del examen
     * @param seccionId el ID de la seccion
     * @return Respuesta del servicio
     */
    ResponseDTO deleteExamenSeccion(Integer examenId, Integer seccionId);

    /**
     * Actualizamos el orden de la seccion
     *
     * @param seccionId El Id de la seccion
     * @param examenId  El id del examen
     * @param orden     El orden a colocar
     * @return Respuiesta del servicio
     */
    ResponseDTO updateOrdenSeccionExamen(Integer seccionId, Integer examenId, Integer orden);

    /**
     * Actualiza los datos de la seccion
     * @param seccionSaveDTO Objeto con los datos a actualizar
     * @return Respuesta del servicio
     */
    ResponseDTO updateSeccion(ExamenSeccionSaveDTO seccionSaveDTO);
}