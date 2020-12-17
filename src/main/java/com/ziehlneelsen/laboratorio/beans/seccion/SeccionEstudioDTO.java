package com.ziehlneelsen.laboratorio.beans.seccion;

import com.ziehlneelsen.laboratorio.beans.estudio.EstudioDTO;
import com.ziehlneelsen.laboratorio.beans.metodo.MetodoDTO;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;

import java.util.List;

public class SeccionEstudioDTO {

    private SeccionEntity seccion;

    private List<MetodoDTO> metodo;

    private List<EstudioDTO> estudio;

    public SeccionEntity getSeccion() {
        return seccion;
    }

    public void setSeccion(SeccionEntity seccion) {
        this.seccion = seccion;
    }

    public List<MetodoDTO> getMetodo() {
        return metodo;
    }

    public void setMetodo(List<MetodoDTO> metodo) {
        this.metodo = metodo;
    }

    public List<EstudioDTO> getEstudio() {
        return estudio;
    }

    public void setEstudio(List<EstudioDTO> estudio) {
        this.estudio = estudio;
    }
}
