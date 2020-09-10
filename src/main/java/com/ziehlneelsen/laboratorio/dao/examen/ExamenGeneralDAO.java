package com.ziehlneelsen.laboratorio.dao.examen;

import com.ziehlneelsen.laboratorio.beans.ExamenDescuentoDTO;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;

import java.text.ParseException;

public interface ExamenGeneralDAO {

    /**
     * Buscar el examen general por el nombre
     * @param nombre el nombre del examen general a buscar
     * @return El objeto del examen general encontrado
     */
    public ExamenGeneralEntity findByName(String nombre);

    /**
     * Metodo para buscar los descuentos de un examen en especifico
     * @param examenId El id del examen general a buscar
     * @return Objeto con la lista de descuentos y el examen
     */
    public ExamenDescuentoDTO findDescuentoByExamen(Integer examenId);
}
