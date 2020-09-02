package com.ziehlneelsen.laboratorio.dao.estudio;

import com.ziehlneelsen.laboratorio.entities.estudio.ReferenciaEntity;

import java.util.List;

public interface ReferenciaDAO {
    public List<ReferenciaEntity> getByEstudio(Integer estudio);
}
