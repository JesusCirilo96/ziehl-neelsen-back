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
     * Obtener los metodos del estudio
     * @param estudioId El id del estudio
     * @return Lista con los metodos
     */
    List<MetodoDTO> getMetodoByEstudio(Integer estudioId);

    /**
     * Guardar o actualizar en BD un metodo
     * @param metodo El metodo a guardar
     * @return Respuesta
     */
    ResponseDTO save(MetodoEntity metodo);

    /**
     * Eliminamos el metodoseccion
     * @param seccionId El id de la seccion a eliminar
     * @param metodoId El id del metodo a eliminar
     * @return Respuesta del servicio
     */
    ResponseDTO deleteMetodoSeccion(Integer seccionId, Integer metodoId);

    /**
     * Eliminamos metodoestudio
     * @param estudioId El id del estudio a eliminar
     * @param metodoId El id del metodo a eliminar
     * @return Respuesta del servicio
     */
    ResponseDTO deleteMetodoEstudio(Integer estudioId, Integer metodoId);

}
