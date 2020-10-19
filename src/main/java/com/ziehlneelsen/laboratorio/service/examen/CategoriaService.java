package com.ziehlneelsen.laboratorio.service.examen;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.examen.CategoriaEntity;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    /**
     * Buscamos todos lo examenes
     * @return una lista con todos los examenes
     */
    public List<CategoriaEntity> findAll();

    /**
     * Buscamos el examen por su ID
     * @param id El id del examen a buscar
     * @return El objeto con el examen encontrado
     */
    public Optional<CategoriaEntity> findById(Integer id);

    /**
     * Metodo para realizar el registro de un examen en la BD
     * @param categoria El objeto deL examen a guardar
     * @return La respuesta
     */
    public ResponseDTO save(CategoriaEntity categoria);

}
