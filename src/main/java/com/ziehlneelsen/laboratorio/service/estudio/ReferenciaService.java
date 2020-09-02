package com.ziehlneelsen.laboratorio.service.estudio;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.estudio.ReferenciaEntity;

import java.util.List;

public interface ReferenciaService {
    public List<ReferenciaEntity> findAll();

    public List<ReferenciaEntity> findByEstudio(Integer idEstudio);

    public ResponseDTO save(ReferenciaEntity referencia);
}
