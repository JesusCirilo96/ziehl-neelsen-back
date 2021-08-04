package com.ziehlneelsen.laboratorio.dao.examen;

import com.ziehlneelsen.laboratorio.beans.ExamenDescuentoDTO;
import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenMetodoAux;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;

import java.text.ParseException;
import java.util.List;

public interface ExamenGeneralDAO {

    /**
     * Buscar el examen general por el nombre
     * @param nombre el nombre del examen general a buscar
     * @return El objeto del examen general encontrado
     */
    ExamenGeneralEntity findByName(String nombre);

    /**
     * Buscamos los estudios del examen
     * @param examenId El id del examen a buscar
     * @return la lista de estudios correspondientes al examen
     */
    List<EstudioEntity> findEstudioByExamen(Integer examenId);

    /**
     * Buscamos los estudios relacionados con el examen y sus referencias
     * @param examenId El ID del examen a buscar
     * @return Respuesta del servicio
     */
    List<EstudioDTO> findEstudioByExamenReferencia(Integer examenId);

    /**
     * Metodo para buscar los descuentos de un examen en especifico
     * @param examenId El id del examen general a buscar
     * @return Objeto con la lista de descuentos y el examen
     */
    ExamenDescuentoDTO findDescuentoByExamen(Integer examenId);

    /**
     * Eliminar de la BD el examen estudio
     * @param examenId El id del examen relacionado a eliminar
     * @param estudioId El id del estudio a eliminar
     * @return Respuesta del servicio
     */
    ResponseDTO deleteExamenEstudio(Integer examenId, Integer estudioId);

    /**
     * Actualiza los metodos del examen
     * @param examen Los datos a actualizar
     * @return Respuesta del servicio
     */
    ResponseDTO updateMetodo(ExamenMetodoAux examen);
}
