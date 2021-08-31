package com.ziehlneelsen.laboratorio.entities.descuento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@IdClass(ExamenDescuentoEntity.class)
@Table(name = "examen_general_descuento")
public class ExamenDescuentoEntity implements Serializable {

    @Id
    @Column(name = "EXAMEN_DESCUENTO_ID", unique = true, nullable = false)
    private UUID examenDescuentoId = UUID.randomUUID();

    @Column(name = "DESCUENTO_ID")
    private Integer descuentoId;

    @Column(name = "EXAMEN_ID")
    private Integer examenId;

    @Column(name = "PORCENTAJE_DESCUENTO")
    private Integer porcentajeDescuento;

    @Column(name = "PORCENTAJE_DESCUENTO_TEXTO")
    private String porcentajeText;

    @Column(name = "DESCUENTO")
    private Float descuento;

    public UUID getExamenDescuentoId() {
        return examenDescuentoId;
    }

    public void setExamenDescuentoId(UUID examenDescuentoId) {
        this.examenDescuentoId = examenDescuentoId;
    }

    public Integer getDescuentoId() {
        return descuentoId;
    }

    public void setDescuentoId(Integer descuentoId) {
        this.descuentoId = descuentoId;
    }

    public Integer getExamenId() {
        return examenId;
    }

    public void setExamenId(Integer examenId) {
        this.examenId = examenId;
    }

    public Integer getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Integer porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getPorcentajeText() {
        return porcentajeText;
    }

    public void setPorcentajeText(String porcentajeText) {
        this.porcentajeText = porcentajeText;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }
}
