package com.ziehlneelsen.laboratorio.beans.examen;

import com.ziehlneelsen.laboratorio.beans.seccion.SeccionEstudioDTO;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;

import java.util.List;

public class ExamenSeccionDTO {

    private ExamenGeneralEntity examen;

    private List<SeccionEstudioDTO> seccion;

    private Integer orden;

    public ExamenGeneralEntity getExamen() {
        return examen;
    }

    public void setExamen(ExamenGeneralEntity examen) {
        this.examen = examen;
    }

    public List<SeccionEstudioDTO> getSeccion() {
        return seccion;
    }

    public void setSeccion(List<SeccionEstudioDTO> seccion) {
        this.seccion = seccion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
}
