package com.ziehlneelsen.laboratorio.beans;

import com.ziehlneelsen.laboratorio.beans.descuento.DescuentoDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.PaqueteDescuentoDTO;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;

import java.util.List;

public class ExamenDescuentoDTO {

    private ExamenGeneralEntity examen;

    private List<DescuentoDTO> descuento;

    private PaqueteDescuentoDTO paquete;

    public ExamenGeneralEntity getExamen() {
        return examen;
    }

    public void setExamen(ExamenGeneralEntity examen) {
        this.examen = examen;
    }

    public List<DescuentoDTO> getDescuento() {
        return descuento;
    }

    public void setDescuento(List<DescuentoDTO> descuento) {
        this.descuento = descuento;
    }

    public PaqueteDescuentoDTO getPaquete() {
        return paquete;
    }

    public void setPaquete(PaqueteDescuentoDTO paquete) {
        this.paquete = paquete;
    }
}
