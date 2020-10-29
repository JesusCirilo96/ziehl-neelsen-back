package com.ziehlneelsen.laboratorio.entities.descuento;

import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(PaqueteDescuentoExamen.class)
@Table(name = "cat_paquete_examen")
public class PaqueteDescuentoExamen implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "PAQUETE_ID")
    PaqueteDescuentoEntity paquete;

    @Id
    @ManyToOne
    @JoinColumn(name = "EXAMEN_ID")
    ExamenGeneralEntity examen;

    public PaqueteDescuentoEntity getPaquete() {
        return paquete;
    }

    public void setPaquete(PaqueteDescuentoEntity paquete) {
        this.paquete = paquete;
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
        if (!(o instanceof PaqueteDescuentoExamen)) return false;
        PaqueteDescuentoExamen that = (PaqueteDescuentoExamen) o;
        return Objects.equals(getPaquete(), that.getPaquete()) &&
                Objects.equals(getExamen(), that.getExamen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaquete(), getExamen());
    }
}
