package com.ziehlneelsen.laboratorio.beans.descuento;

import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.DiaEntity;

import java.util.List;

public class DiaDescuentoDTO {

    DescuentoEntity descuento;

    List<DiaEntity> dia;

    public DescuentoEntity getDescuento() {
        return descuento;
    }

    public void setDescuento(DescuentoEntity descuento) {
        this.descuento = descuento;
    }

    public List<DiaEntity> getDia() {
        return dia;
    }

    public void setDia(List<DiaEntity> dia) {
        this.dia = dia;
    }
}
