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

    @Column(name = "ORDEN")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamenEstudioEntity)) return false;
        ExamenEstudioEntity that = (ExamenEstudioEntity) o;
        return Objects.equals(getExamenEstudioId(), that.getExamenEstudioId()) && Objects.equals(getEstudioId(), that.getEstudioId()) && Objects.equals(getExamenId(), that.getExamenId()) && Objects.equals(getOrden(), that.getOrden());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExamenEstudioId(), getEstudioId(), getExamenId(), getOrden());
    }
}
