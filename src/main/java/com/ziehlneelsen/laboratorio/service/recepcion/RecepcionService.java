package com.ziehlneelsen.laboratorio.service.recepcion;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.recepcion.HistorialDTO;
import com.ziehlneelsen.laboratorio.beans.recepcion.RecepcionDTO;
import com.ziehlneelsen.laboratorio.beans.recepcion.RecepcionResultadoDTO;
import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionEntity;
import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionExamenGeneralEntity;

import java.util.List;

public interface RecepcionService {

    /**
     * Obtenemos la ficha de recepcion
     * @return
     */
    Integer obtenerFicha();

    /**
     * Guardamos la recepcion
     * @param recepcion Objeto de la recepcion a guardar
     * @return Respuesta del servicio
     */
    ResponseDTO saveRecepcion(RecepcionEntity recepcion);

    /**
     * Guardamos en la tabla relacionada de recepcion y examen
     * @param recepcionExamen El objeto de recepcion y examen
     * @return La respuesta del servicio
     */
    ResponseDTO saveRecepcionExamen(RecepcionExamenGeneralEntity recepcionExamen);

    /**
     * Obtenemos las recepciones de una fecha dada
     * @param fecha La fecha a buscar
     * @return Respuesta del servicio
     */
    List<RecepcionDTO> obtenerRecepcionPorFecha(String fecha);

    /**
     * Obtenemos los datos de la recepcion, paciente asi como el resultado de los estudios
     * @param idRecepcion El ID de la recepcion a buscar
     * @return Objeto con los datos de la recepcion del paciente y los resultados
     */
    RecepcionResultadoDTO obtenerResultados(String idRecepcion);

    /**
     * Guardamos los resultados del examen
     * @param resultado La entidad con el examen y el resultado
     * @return Respuesta del service
     */
    ResponseDTO guardarResultados(RecepcionExamenGeneralEntity resultado);

    /**
     * Obtenemos el historial de recepciones del paciente
     * @param pacienteId el id del paciente a obtener
     * @return objeto con los datos del historial
     */
    HistorialDTO obtenerHistorial(Integer pacienteId);
}
