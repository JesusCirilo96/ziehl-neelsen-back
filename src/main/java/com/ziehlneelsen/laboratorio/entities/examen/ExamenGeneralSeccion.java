package com.ziehlneelsen.laboratorio.entities.examen;

import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@IdClass(ExamenGeneralSeccion.class)
@Table(name = "seccion_examen_general")
public class ExamenGeneralSeccion implements Serializable {

    @Id
    @Column(name = "SECCION_EXAMEN_ID", unique = true, nullable = false)
    private UUID seccionExamenId = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "SECCION_ID")
    SeccionEntity seccion;

    @ManyToOne
    @JoinColumn(name = "EXAMEN_ID")
    ExamenGeneralEntity examen;

    @Column(name = "ORDEN")
    Integer orden;

    public UUID getSeccionExamenId() {
        return seccionExamenId;
    }

    public void setSeccionExamenId(UUID seccionExamenId) {
        this.seccionExamenId = seccionExamenId;
    }

    public SeccionEntity getSeccion() {
        return seccion;
    }

    public void setSeccion(SeccionEntity seccion) {
        this.seccion = seccion;
    }

    public ExamenGeneralEntity getExamen() {
        return examen;
    }

    public void setExamen(ExamenGeneralEntity examen) {
        this.examen = examen;
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
        if (!(o instanceof ExamenGeneralSeccion)) return false;
        ExamenGeneralSeccion that = (ExamenGeneralSeccion) o;
        return Objects.equals(getSeccionExamenId(), that.getSeccionExamenId()) && Objects.equals(getSeccion(), that.getSeccion()) && Objects.equals(getExamen(), that.getExamen()) && Objects.equals(getOrden(), that.getOrden());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSeccionExamenId(), getSeccion(), getExamen(), getOrden());
    }
}
