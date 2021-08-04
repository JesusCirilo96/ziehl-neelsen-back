package com.ziehlneelsen.laboratorio.dao.seccion;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.SeccionEstudioDTO;

import java.util.List;

public interface SeccionEstudioDAO {

    /**
     * Obtenemos los estudios dado una seccion
     * @param seccionId El id de la seccion
     * @return Lista con los estudios de la seccion
     */
    SeccionEstudioDTO getEstudioSeccion(Integer seccionId);

    /**
     * Eliminar Un estudio de una seccion
     * @param seccionId El ID de la seccion
     * @param estudioId El ID del estudio
     * @return Respuesta del servicio
     */
    ResponseDTO deleteSeccionEstudio(Integer seccionId, Integer estudioId);

    /**
     * Actualiza el orden del seccionEstudio
     * @param seccionId El id de la seccion
     * @param estudioId El id del estudio
     * @param orden El orden a colocar
     * @return
     */
    ResponseDTO updateOrdenSeccionEstudio(Integer seccionId, Integer estudioId,Integer orden);

    /**
     * Actualiza el orden el estudio del examen
     * @param idExamen El id del examen
     * @param idEstudio El id del estudio
     * @param orden El orden a colocar
     * @return
     */
    ResponseDTO updateOrdenExamenEstudio(Integer idExamen, Integer idEstudio, Integer orden);
}
