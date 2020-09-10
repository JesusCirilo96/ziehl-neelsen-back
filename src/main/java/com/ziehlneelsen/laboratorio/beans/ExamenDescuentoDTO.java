package com.ziehlneelsen.laboratorio.beans;

import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.DiaDescuento;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;

import java.util.List;

public class ExamenDescuentoDTO {

    ExamenGeneralEntity examen;

    List<DescuentoEntity> descuento;

    public ExamenGeneralEntity getExamen() {
        return examen;
    }

    public void setExamen(ExamenGeneralEntity examen) {
        this.examen = examen;
    }

    public List<DescuentoEntity> getDescuento() {
        return descuento;
    }

    public void setDescuento(List<DescuentoEntity> descuento) {
        this.descuento = descuento;
    }
}
