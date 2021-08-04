package com.ziehlneelsen.laboratorio.entities.estudio;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@DynamicUpdate
@Table(name = "referencia")
public class ReferenciaEntity implements Serializable {

    @Id
    @Column(name = "REFERENCIA_ID", unique = true, nullable = false)
    private UUID referenciaId = UUID.randomUUID();

    @Column(name = "ESTUDIO_ID")
    private String estudioId;

    @Column(name = "CLASIFICACION_ID")
    private String clasificacionId;

    @Column(name = "MASCULINO")
    private String masculino;

    @Column(name = "FEMENINO")
    private String femenino;

    @Column(name = "GENERAL")
    private String general;

    @Column(name = "ORDEN")
    private Integer orden;

    @Column(name = "NOTA")
    private String nota;

    @Column(name = "FECHA_CREACION")
    private String fechaCreacion;

    @Column(name = "FECHA_ACTUALIZACION")
    private String fechaActualizacion;

    public UUID getReferenciaId() {
        return referenciaId;
    }

    public void setReferenciaId(UUID referenciaId) {
        this.referenciaId = referenciaId;
    }

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
