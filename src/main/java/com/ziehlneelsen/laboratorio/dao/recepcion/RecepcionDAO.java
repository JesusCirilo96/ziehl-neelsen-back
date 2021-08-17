package com.ziehlneelsen.laboratorio.dao.recepcion;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.recepcion.HistorialDTO;
import com.ziehlneelsen.laboratorio.beans.recepcion.RecepcionResultadoDTO;
import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionEntity;
import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionExamenGeneralEntity;

import java.util.List;

public interface RecepcionDAO {

    /**
     * Obtenemos la ficha de la recepcion del dia
     * @return El numero de ficha
     */
    Integer obtenerFicha();

    /**
     * Obtenemos el resultados de la recepcion
     * @param idRecepcion el ID de la recepcion a buscar
     * @return objeto con el resultado los datos del paciente y la recepcion
     */
    List<RecepcionExamenGeneralEntity> obtenerResultados(String idRecepcion);

    /**
     * obtenemos la recepcion
     * @param where El campo a comparar
     * @param equal El valor a buscar
     * @return Lista con las recepciones
     */
    List<RecepcionEntity> obtenerRecepcion(String where, String equal);

    ResponseDTO saveResultado(RecepcionExamenGeneralEntity resultado);

    /**
     * Obtenemos el historial del paciente
     * @param pacienteId El id del paciente
     * @return Objeto con el historial del paciente
     */
    HistorialDTO obtenerHistorial(Integer pacienteId);

    /**
     * Actualizamos las banderas de la recepcion ya se si
     * fue finalizado, impreso o entregado
     * @param recepcionId El id de la recepcion
     * @param opcion La opcion, que bandera se va a actualizar
     * @param valor El valor a colocar
     * @return Respuesta del servicio
     */
    ResponseDTO updateBanderas(String recepcionId, String opcion, Boolean valor);
}
