package com.ziehlneelsen.laboratorio.beans.examen;

import com.ziehlneelsen.laboratorio.entities.estudio.ClasificacionPacienteEntity;
import com.ziehlneelsen.laboratorio.entities.metodo.MetodoEntity;

import java.util.UUID;

public class ReferenciaDTO {

    private ClasificacionPacienteEntity clasificacion;

    private Integer clasificacionId;

    private UUID referenciaId;

    private String referenciaMasculino;

    private String referenciaFemenino;

    private String referenciaGeneral;

    private Integer orden;

    private String nota;

    private MetodoEntity metodo;

    public UUID getReferenciaId() {
        return referenciaId;
    }

    public void setReferenciaId(UUID referenciaId) {
        this.referenciaId = referenciaId;
    }

    public Integer getClasificacionId() {
        return clasificacionId;
    }

    public void setClasificacionId(Integer clasificacionId) {
        this.clasificacionId = clasificacionId;
    }

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

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
