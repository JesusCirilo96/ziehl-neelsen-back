package com.ziehlneelsen.laboratorio.entities.examen;

import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ExamenGeneralSeccion.class)
@Table(name = "seccion_examen_general")
public class ExamenGeneralSeccion implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "SECCION_ID")
    SeccionEntity seccion;

    @Id
    @ManyToOne
    @JoinColumn(name = "EXAMEN_ID")
    ExamenGeneralEntity examen;

    @Column(name = "ORDEN")
    Integer orden;

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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ExamenGeneralSeccion that = (ExamenGeneralSeccion) object;
        return java.util.Objects.equals(seccion, that.seccion) &&
                java.util.Objects.equals(examen, that.examen) &&
                java.util.Objects.equals(orden, that.orden);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), seccion, examen, orden);
    }
}
