package com.ziehlneelsen.laboratorio.entities.examen;

import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@IdClass(ExamenEstudio.class)
@Table(name = "estudio_examen_general")
public class ExamenEstudio implements Serializable {
    @Id
    @Column(name = "ESTUDIO_EXAMEN_ID", unique = true, nullable = false)
    private UUID examenEstudioId = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "ESTUDIO_ID")
    EstudioEntity estudio;

    @ManyToOne
    @JoinColumn(name = "EXAMEN_ID")
    ExamenGeneralEntity examen;

    Integer orden;

    public UUID getExamenEstudioId() {
        return examenEstudioId;
    }

    public void setExamenEstudioId(UUID examenEstudioId) {
        this.examenEstudioId = examenEstudioId;
    }

    public EstudioEntity getEstudio() {
        return estudio;
    }

    public void setEstudio(EstudioEntity estudio) {
        this.estudio = estudio;
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
        if (!(o instanceof ExamenEstudio)) return false;
        ExamenEstudio that = (ExamenEstudio) o;
        return Objects.equals(getExamenEstudioId(), that.getExamenEstudioId()) && Objects.equals(getEstudio(), that.getEstudio()) && Objects.equals(getExamen(), that.getExamen()) && Objects.equals(getOrden(), that.getOrden());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExamenEstudioId(), getEstudio(), getExamen(), getOrden());
    }
}
