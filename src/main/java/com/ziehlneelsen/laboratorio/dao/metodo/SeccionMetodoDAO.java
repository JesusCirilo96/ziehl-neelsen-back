package com.ziehlneelsen.laboratorio.dao.metodo;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.metodo.MetodoDTO;

import java.util.List;

public interface SeccionMetodoDAO {

    /**
     * Obtenemos los metodos de la seccion
     * @param idSeccion El id de la seccion
     * @return La lista con los metodos de la seccion
     */
    List<MetodoDTO> getMetodoBySeccion(Integer idSeccion);

    /**
     * Obtenemos los metodos del estudio
     * @param idEstudio El id del estudio a buscar
     * @return Lista con los metodos
     */
    List<MetodoDTO> getMetodoByEstudio(Integer idEstudio);

    /**
     * Elimina registro n:n de metodo seccion
     * @param seccionId El id de la seccion a eliminar
     * @param metodoId El id del metodo a eliminar
     * @return Respuesta del servicio
     */
    ResponseDTO deleteMetodoSeccion(Integer seccionId, Integer metodoId);

    /**
     * Eliminar registro n:n de metodo estudio
     * @param estudioId El id del estudio a aliminar
     * @param metodoId El id del metodo a eliminar
     * @return Respuesta del servicio
     */
    ResponseDTO deleteMetodoEstudio(Integer estudioId, Integer metodoId);


}
