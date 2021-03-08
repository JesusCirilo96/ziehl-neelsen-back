package com.ziehlneelsen.laboratorio.entities.examen;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@IdClass(ExamenEstudioEntity.class)
@Table(name = "estudio_examen_general")
public class ExamenEstudioEntity implements Serializable {
    @Id
    @Column(name = "ESTUDIO_EXAMEN_ID", unique = true, nullable = false)
    private UUID examenEstudioId = UUID.randomUUID();

    @Column(name = "ESTUDIO_ID")
    private Integer estudioId;

    @Column(name = "EXAMEN_ID")
    private Integer examenId;

    @Column(name="ORDEN")
    private Integer orden;

    public UUID getExamenEstudioId() {
        return examenEstudioId;
    }

    public void setExamenEstudioId(UUID examenEstudioId) {
        this.examenEstudioId = examenEstudioId;
    }

    public Integer getEstudioId() {
        return estudioId;
    }

    public void setEstudioId(Integer estudioId) {
        this.estudioId = estudioId;
    }

    public Integer getExamenId() {
        return examenId;
    }

    public void setExamenId(Integer examenId) {
        this.examenId = examenId;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ExamenEstudioEntity that = (ExamenEstudioEntity) object;
        return java.util.Objects.equals(examenEstudioId, that.examenEstudioId) && java.util.Objects.equals(estudioId, that.estudioId) && java.util.Objects.equals(examenId, that.examenId) && java.util.Objects.equals(orden, that.orden);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), examenEstudioId, estudioId, examenId, orden);
    }
}
