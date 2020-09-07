package com.ziehlneelsen.laboratorio.dao.examen;

import com.ziehlneelsen.laboratorio.entities.examen.ExamenSencilloEntity;

public interface ExamenSencilloDAO {
    public ExamenSencilloEntity findByName(String nombre);
}
