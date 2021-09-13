package com.ziehlneelsen.laboratorio.beans.descuento;

import java.util.List;

public class DescuentoExamenDTO {

    DescuentoDTO descuento;

    List<ExamenDescuentoAuxDTO> examen;

    public DescuentoDTO getDescuento() {
        return descuento;
    }

    public void setDescuento(DescuentoDTO descuento) {
        this.descuento = descuento;
    }

    public List<ExamenDescuentoAuxDTO> getExamen() {
        return examen;
    }

    public void setExamen(List<ExamenDescuentoAuxDTO> examen) {
        this.examen = examen;
    }
}
