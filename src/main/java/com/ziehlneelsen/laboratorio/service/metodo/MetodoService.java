package com.ziehlneelsen.laboratorio.service.metodo;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.metodo.MetodoDTO;
import com.ziehlneelsen.laboratorio.entities.metodo.MetodoEntity;

import java.util.List;
import java.util.Optional;

public interface MetodoService {

    /**
     * Obtener todos los metodos
     * @return La lista con todos los metodos en BD
     */
    List<MetodoEntity> findAll();

    /**
     * Obtener un metodo por ID
     * @param id El ID del metodo a obtener
     * @return El metodo
     */
    Optional<MetodoEntity> findById(Integer id);

    /**
     * Obtener los metodos de la seccion
     * @param seccionId El ID de la seccion a buscar
     * @return Los metodos correspondientes de la seccion
     */
    List<MetodoDTO> getMetodoBySeccion(Integer seccionId);

    /**
     * Guardar o actualizar en BD un metodo
     * @param metodo El metodo a guardar
     * @return Respuesta
     */
    ResponseDTO save(MetodoEntity metodo);

}
