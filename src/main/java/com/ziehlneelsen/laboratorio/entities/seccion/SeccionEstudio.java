package com.ziehlneelsen.laboratorio.entities.seccion;

import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(SeccionEstudio.class)
@Table(name = "estudio_seccion")
public class SeccionEstudio implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "ESTUDIO_ID")
    EstudioEntity estudio;

    @Id
    @ManyToOne
    @JoinColumn(name = "SECCION_ID")
    SeccionEntity seccion;

    @Column(name = "ORDEN")
    Integer orden;

    public EstudioEntity getEstudio() {
        return estudio;
    }

    public void setEstudio(EstudioEntity estudio) {
        this.estudio = estudio;
    }

    public SeccionEntity getSeccion() {
        return seccion;
    }

    public void setSeccion(SeccionEntity seccion) {
        this.seccion = seccion;
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
        if (o == null || getClass() != o.getClass()) return false;
        SeccionEstudio that = (SeccionEstudio) o;
        return Objects.equals(estudio, that.estudio) &&
                Objects.equals(seccion, that.seccion) &&
                Objects.equals(orden, that.orden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estudio, seccion, orden);
    }
}
