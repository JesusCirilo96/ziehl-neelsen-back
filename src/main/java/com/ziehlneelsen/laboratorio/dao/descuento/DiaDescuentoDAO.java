package com.ziehlneelsen.laboratorio.dao.descuento;

import com.ziehlneelsen.laboratorio.entities.descuento.DiaDescuentoEntity;

import java.util.List;

public interface DiaDescuentoDAO {
    public List<DiaDescuentoEntity> getByDescuento(Integer descuentoId);
}
