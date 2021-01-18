package com.ziehlneelsen.laboratorio.entities.examen;

import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@IdClass(ExamenGeneralDescuento.class)
@Table(name = "examen_general_descuento")
public class ExamenGeneralDescuento implements Serializable {

    @Id
    @Column(name = "EXAMEN_DESCUENTO_ID", unique = true, nullable = false)
    private UUID examenDescuentoId = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "DESCUENTO_ID")
    DescuentoEntity descuento;

    @ManyToOne
    @JoinColumn(name = "EXAMEN_ID")
    ExamenGeneralEntity examen;

    public UUID getExamenDescuentoId() {
        return examenDescuentoId;
    }

    public void setExamenDescuentoId(UUID examenDescuentoId) {
        this.examenDescuentoId = examenDescuentoId;
    }

    public DescuentoEntity getDescuento() {
        return descuento;
    }

    public void setDescuento(DescuentoEntity descuento) {
        this.descuento = descuento;
    }

    public ExamenGeneralEntity getExamen() {
        return examen;
    }

    public void setExamen(ExamenGeneralEntity examen) {
        this.examen = examen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamenGeneralDescuento)) return false;
        ExamenGeneralDescuento that = (ExamenGeneralDescuento) o;
        return Objects.equals(getExamenDescuentoId(), that.getExamenDescuentoId()) && Objects.equals(getDescuento(), that.getDescuento()) && Objects.equals(getExamen(), that.getExamen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExamenDescuentoId(), getDescuento(), getExamen());
    }
}
