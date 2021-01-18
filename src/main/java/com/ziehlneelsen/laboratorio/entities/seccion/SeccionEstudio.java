package com.ziehlneelsen.laboratorio.entities.seccion;

import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@IdClass(SeccionEstudio.class)
@Table(name = "estudio_seccion")
public class SeccionEstudio implements Serializable {

    @Id
    @Column(name = "ESTUDIO_SECCION_ID", unique = true, nullable = false)
    private UUID estudioSeccionId = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "ESTUDIO_ID")
    EstudioEntity estudio;

    @ManyToOne
    @JoinColumn(name = "SECCION_ID")
    SeccionEntity seccion;

    @Column(name = "ORDEN")
    Integer orden;

    public UUID getEstudioSeccionId() {
        return estudioSeccionId;
    }

    public void setEstudioSeccionId(UUID estudioSeccionId) {
        this.estudioSeccionId = estudioSeccionId;
    }

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
        if (!(o instanceof SeccionEstudio)) return false;
        SeccionEstudio that = (SeccionEstudio) o;
        return Objects.equals(getEstudioSeccionId(), that.getEstudioSeccionId()) && Objects.equals(getEstudio(), that.getEstudio()) && Objects.equals(getSeccion(), that.getSeccion()) && Objects.equals(getOrden(), that.getOrden());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEstudioSeccionId(), getEstudio(), getSeccion(), getOrden());
    }
}
