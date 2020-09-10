package com.ziehlneelsen.laboratorio.entities.examen;

import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(ExamenGeneralDescuento.class)
@Table(name = "examen_general_descuento")
public class ExamenGeneralDescuento implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "DESCUENTO_ID")
    DescuentoEntity descuento;

    @Id
    @ManyToOne
    @JoinColumn(name = "EXAMEN_ID")
    ExamenGeneralEntity examen;

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
        return Objects.equals(getDescuento(), that.getDescuento()) &&
                Objects.equals(getExamen(), that.getExamen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescuento(), getExamen());
    }
}
