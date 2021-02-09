package com.ziehlneelsen.laboratorio.entities.examen;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@IdClass(ExamenGeneralSeccionEntity.class)
@Table(name = "seccion_examen_general")
public class ExamenGeneralSeccionEntity implements Serializable {

    @Id
    @Column(name = "SECCION_EXAMEN_ID", unique = true, nullable = false)
    private UUID seccionExamenId = UUID.randomUUID();

    @Column(name = "SECCION_ID")
    Integer seccionId;

    @Column(name = "EXAMEN_ID")
    Integer examenId;

    @Column(name = "ORDEN")
    Integer orden;

    public UUID getSeccionExamenId() {
        return seccionExamenId;
    }

    public void setSeccionExamenId(UUID seccionExamenId) {
        this.seccionExamenId = seccionExamenId;
    }

    public Integer getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(Integer seccionId) {
        this.seccionId = seccionId;
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
        if (!(o instanceof ExamenGeneralSeccionEntity)) return false;
        ExamenGeneralSeccionEntity that = (ExamenGeneralSeccionEntity) o;
        return Objects.equals(getSeccionExamenId(), that.getSeccionExamenId()) && Objects.equals(getSeccionId(), that.getSeccionId()) && Objects.equals(getExamenId(), that.getExamenId()) && Objects.equals(getOrden(), that.getOrden());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSeccionExamenId(), getSeccionId(), getExamenId(), getOrden());
    }
}
