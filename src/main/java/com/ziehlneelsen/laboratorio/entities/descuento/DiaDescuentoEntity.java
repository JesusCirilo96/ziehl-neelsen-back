package com.ziehlneelsen.laboratorio.entities.descuento;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(DiaDescuentoEntity.class)
@Table(name = "dia_descuento")
public class DiaDescuentoEntity implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "DIA_ID")
    DiaEntity dia;

    @Id
    @ManyToOne
    @JoinColumn(name = "DESCUENTO_ID")
    DescuentoEntity descuento;

    @Column(name = "INICIO")
    String inicio;

    @Column(name = "FIN")
    String fin;

    public DiaEntity getDia() {
        return dia;
    }

    public void setDia(DiaEntity dia) {
        this.dia = dia;
    }

    public DescuentoEntity getDescuento() {
        return descuento;
    }

    public void setDescuento(DescuentoEntity descuento) {
        this.descuento = descuento;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiaDescuentoEntity)) return false;
        DiaDescuentoEntity that = (DiaDescuentoEntity) o;
        return Objects.equals(getDia(), that.getDia()) &&
                Objects.equals(getDescuento(), that.getDescuento()) &&
                Objects.equals(getInicio(), that.getInicio()) &&
                Objects.equals(getFin(), that.getFin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDia(), getDescuento(), getInicio(), getFin());
    }
}
