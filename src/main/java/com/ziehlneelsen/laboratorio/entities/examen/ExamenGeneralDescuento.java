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

    @Column(name="PORCENTAJE_DESCUENTO")
    private String porcentaje;

    @Column(name = "PORCENTAJE_DESCUENTO_TEXTO")
    private String porcentajeText;

    @Column(name = "DESCUENTO")
    private Float descuentoMonto;

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

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getPorcentajeText() {
        return porcentajeText;
    }

    public void setPorcentajeText(String porcentajeText) {
        this.porcentajeText = porcentajeText;
    }

    public Float getDescuentoMonto() {
        return descuentoMonto;
    }

    public void setDescuentoMonto(Float descuentoMonto) {
        this.descuentoMonto = descuentoMonto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamenGeneralDescuento)) return false;
        ExamenGeneralDescuento that = (ExamenGeneralDescuento) o;
        return Objects.equals(getExamenDescuentoId(), that.getExamenDescuentoId()) && Objects.equals(getDescuento(), that.getDescuento()) && Objects.equals(getExamen(), that.getExamen()) && Objects.equals(getPorcentaje(), that.getPorcentaje()) && Objects.equals(getPorcentajeText(), that.getPorcentajeText()) && Objects.equals(getDescuentoMonto(), that.getDescuentoMonto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExamenDescuentoId(), getDescuento(), getExamen(), getPorcentaje(), getPorcentajeText(), getDescuentoMonto());
    }
}
