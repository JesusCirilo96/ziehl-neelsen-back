package com.ziehlneelsen.laboratorio.entities.cotizacion;

import com.ziehlneelsen.laboratorio.entities.examen.ExamenSencilloEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(CotizacionExamenSencillo.class)
@Table(name = "examen_sencillo_cotizacion")
public class CotizacionExamenSencillo implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "EXAMEN_SENCILLO_ID")
    ExamenSencilloEntity examenSencillo;

    @Id
    @ManyToOne
    @JoinColumn(name = "COTIZACION_ID")
    CotizacionEntity cotizacion;

    public ExamenSencilloEntity getExamenSencillo() {
        return examenSencillo;
    }

    public void setExamenSencillo(ExamenSencilloEntity examenSencillo) {
        this.examenSencillo = examenSencillo;
    }

    public CotizacionEntity getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(CotizacionEntity cotizacion) {
        this.cotizacion = cotizacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CotizacionExamenSencillo)) return false;
        CotizacionExamenSencillo that = (CotizacionExamenSencillo) o;
        return Objects.equals(getExamenSencillo(), that.getExamenSencillo()) &&
                Objects.equals(getCotizacion(), that.getCotizacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExamenSencillo(), getCotizacion());
    }
}
