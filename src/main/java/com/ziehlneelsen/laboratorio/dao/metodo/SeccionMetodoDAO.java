package com.ziehlneelsen.laboratorio.dao.metodo;

import com.ziehlneelsen.laboratorio.beans.metodo.MetodoDTO;

import java.util.List;

public interface SeccionMetodoDAO {

    /**
     * Obtenemos los metodos de la seccion
     * @param idSeccion El id de la seccion
     * @return La lista con los metodos de la seccion
     */
    List<MetodoDTO> getMetodoBySeccion(Integer idSeccion);
}
