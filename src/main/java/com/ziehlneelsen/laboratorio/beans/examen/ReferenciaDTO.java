package com.ziehlneelsen.laboratorio.beans.examen;

import com.ziehlneelsen.laboratorio.entities.estudio.ClasificacionPacienteEntity;
import com.ziehlneelsen.laboratorio.entities.metodo.MetodoEntity;

public class ReferenciaDTO {

    private ClasificacionPacienteEntity clasificacion;

    private String referenciaMasculino;

    private String referenciaFemenino;

    private String referenciaGeneral;

    private MetodoEntity metodo;

    public ClasificacionPacienteEntity getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(ClasificacionPacienteEntity clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getReferenciaMasculino() {
        return referenciaMasculino;
    }

    public void setReferenciaMasculino(String referenciaMasculino) {
        this.referenciaMasculino = referenciaMasculino;
    }

    public String getReferenciaFemenino() {
        return referenciaFemenino;
    }

    public void setReferenciaFemenino(String referenciaFemenino) {
        this.referenciaFemenino = referenciaFemenino;
    }

    public String getReferenciaGeneral() {
        return referenciaGeneral;
    }

    public void setReferenciaGeneral(String referenciaGeneral) {
        this.referenciaGeneral = referenciaGeneral;
    }

    public MetodoEntity getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoEntity metodo) {
        this.metodo = metodo;
    }
}
