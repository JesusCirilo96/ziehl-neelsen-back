package com.ziehlneelsen.laboratorio.service.examen;

import com.ziehlneelsen.laboratorio.beans.ExamenDescuentoDTO;
import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface ExamenGeneralService {

    /**
     * Buscamos todos lo examenes
     * @return una lista con todos los examenes
     */
    public List<ExamenGeneralEntity> findAll();

    /**
     * Buscamos el examen por su ID
     * @param id El id del examen a buscar
     * @return El objeto con el examen encontrado
     */
    public Optional<ExamenGeneralEntity> findById(Integer id);

    /**
     * Bucamos el examen por el nombre de la misma
     * @param nombre El nombre del examen a buscar
     * @return El objeto con los datos del examen encontrado
     */
    public ExamenGeneralEntity findByName(String nombre);

    /**
     * Metodo para realizar el registro de un examen en la BD
     * @param examenGeneral El objeto deL examen a guardar
     * @return La respuesta
     */
    public ResponseDTO save(ExamenGeneralEntity examenGeneral);

    /**
     * Metodo que buscar los descuentos aplicables para el exmane
     * @param examenId El id del examen a buscar
     * @return El objeto con la lista de descuentos y el examen
     */
    public ExamenDescuentoDTO findDescuentoByExamen(Integer examenId);
}
