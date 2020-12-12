package com.ziehlneelsen.laboratorio.dao.seccion;

import com.ziehlneelsen.laboratorio.beans.seccion.SeccionEstudioDTO;

import java.util.List;

public interface SeccionEstudioDAO {

    /**
     * Obtenemos los estudios dado una seccion
     * @param seccionId El id de la seccion
     * @return Lista con los estudios de la seccion
     */
    SeccionEstudioDTO getEstudioSeccion(Integer seccionId);
}
