package com.ziehlneelsen.laboratorio.beans.examen;

import com.ziehlneelsen.laboratorio.beans.estudio.EstudioDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.SeccionEstudioDTO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;

import java.util.List;
import java.util.Optional;

public class ExamenSeccionDTO {

    private Optional<ExamenGeneralEntity> examen;

    private List<SeccionEstudioDTO> seccion;

    private List<EstudioDTO> estudio;

    private Integer orden;

    public Optional<ExamenGeneralEntity> getExamen() {
        return examen;
    }

    public void setExamen(Optional<ExamenGeneralEntity> examen) {
        this.examen = examen;
    }

    public List<SeccionEstudioDTO> getSeccion() {
        return seccion;
    }

    public void setSeccion(List<SeccionEstudioDTO> seccion) {
        this.seccion = seccion;
    }

    public List<EstudioDTO> getEstudio() {
        return estudio;
    }

    public void setEstudio(List<EstudioDTO> estudio) {
        this.estudio = estudio;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
}
