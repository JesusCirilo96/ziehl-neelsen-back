package com.ziehlneelsen.laboratorio.dao.examen;

import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;

public interface ExamenGeneralDAO {
    public ExamenGeneralEntity findByName(String nombre);
}
