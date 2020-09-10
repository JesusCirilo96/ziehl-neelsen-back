package com.ziehlneelsen.laboratorio.dao.descuento;

import com.ziehlneelsen.laboratorio.entities.descuento.DiaDescuento;

import java.util.List;

public interface DiaDescuentoDAO {
    public List<DiaDescuento> getByDescuento(Integer descuentoId);
}
