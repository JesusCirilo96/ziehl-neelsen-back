package com.ziehlneelsen.laboratorio.entities.estudio;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DynamicUpdate
@Table(name = "referencia")
public class ReferenciaEntity implements Serializable {

    @Id
    @Column(name = "CLASIFICACION_ID")
    String clasificacionId;

    @Column(name = "ESTUDIO_ID")
    String estudioId;

    @Column(name = "MASCULINO")
    String masculino;

    @Column(name = "FEMENINO")
    String femenino;

    @Column(name = "GENERAL")
    String general;

    @Column(name = "FECHA_CREACION")
    String fechaCreacion;

    @Column(name = "FECHA_ACTUALIZACION")
    String fechaActualizacion;

    public String getClasificacionId() {
        return clasificacionId;
    }

    public void setClasificacionId(String clasificacionId) {
        this.clasificacionId = clasificacionId;
    }

    public String getEstudioId() {
        return estudioId;
    }

    public void setEstudioId(String estudioId) {
        this.estudioId = estudioId;
    }

    public String getMasculino() {
        return masculino;
    }

    public void setMasculino(String masculino) {
        this.masculino = masculino;
    }

    public String getFemenino() {
        return femenino;
    }

    public void setFemenino(String femenino) {
        this.femenino = femenino;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
