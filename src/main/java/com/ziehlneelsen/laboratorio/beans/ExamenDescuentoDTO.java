package com.ziehlneelsen.laboratorio.beans;

import com.ziehlneelsen.laboratorio.beans.descuento.DescuentoDTO;
import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;

import javax.persistence.Column;
import java.util.List;

public class ExamenDescuentoDTO {

    private ExamenGeneralEntity examen;

    private List<DescuentoDTO> descuento;

    private String porcentaje;

    private String porcentajeText;

    private Float descuentoMonto;

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

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getPorcentajeText() {
        return porcentajeText;
    }

    public void setPorcentajeText(String porcentajeText) {
        this.porcentajeText = porcentajeText;
    }

    public Float getDescuentoMonto() {
        return descuentoMonto;
    }

    public void setDescuentoMonto(Float descuentoMonto) {
        this.descuentoMonto = descuentoMonto;
    }
}
