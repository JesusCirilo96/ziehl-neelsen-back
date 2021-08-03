package com.ziehlneelsen.laboratorio.entities.metodo;

import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@IdClass(EstudioMetodo.class)
@Table(name = "estudio_metodo")
public class EstudioMetodo implements Serializable {
    @Id
    @Column(name = "ESTUDIO_METODO_ID", unique = true, nullable = false)
    private UUID metodoSeccionId = UUID.randomUUID();

    @Id
    @ManyToOne
    @JoinColumn(name = "ESTUDIO_ID")
    EstudioEntity estudio;

    @Id
    @ManyToOne
    @JoinColumn(name = "METODO_ID")
    MetodoEntity metodo;

    public UUID getMetodoSeccionId() {
        return metodoSeccionId;
    }

    public void setMetodoSeccionId(UUID metodoSeccionId) {
        this.metodoSeccionId = metodoSeccionId;
    }

    public EstudioEntity getEstudio() {
        return estudio;
    }

    public void setEstudio(EstudioEntity estudio) {
        this.estudio = estudio;
    }

    public MetodoEntity getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoEntity metodo) {
        this.metodo = metodo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstudioMetodo)) return false;
        EstudioMetodo that = (EstudioMetodo) o;
        return Objects.equals(getMetodoSeccionId(), that.getMetodoSeccionId()) && Objects.equals(getEstudio(), that.getEstudio()) && Objects.equals(getMetodo(), that.getMetodo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMetodoSeccionId(), getEstudio(), getMetodo());
    }
}
