package com.ziehlneelsen.laboratorio.entities.descuento;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@IdClass(DiaDescuento.class)
@Table(name = "dia_descuento")
public class DiaDescuento implements Serializable {

    @Id
    @Column(name = "DIA_DESCUENTO_ID", unique = true, nullable = false)
    private UUID diaDescuentoId = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "DIA_ID")
    DiaEntity dia;

    @ManyToOne
    @JoinColumn(name = "DESCUENTO_ID")
    DescuentoEntity descuento;

    @Column(name = "INICIO")
    String inicio;

    @Column(name = "FIN")
    String fin;

    public UUID getDiaDescuentoId() {
        return diaDescuentoId;
    }

    public void setDiaDescuentoId(UUID diaDescuentoId) {
        this.diaDescuentoId = diaDescuentoId;
    }

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
        if (!(o instanceof DiaDescuento)) return false;
        DiaDescuento that = (DiaDescuento) o;
        return Objects.equals(getDiaDescuentoId(), that.getDiaDescuentoId()) && Objects.equals(getDia(), that.getDia()) && Objects.equals(getDescuento(), that.getDescuento()) && Objects.equals(getInicio(), that.getInicio()) && Objects.equals(getFin(), that.getFin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiaDescuentoId(), getDia(), getDescuento(), getInicio(), getFin());
    }
}
