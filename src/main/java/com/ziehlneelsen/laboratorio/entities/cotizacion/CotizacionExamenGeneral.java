package com.ziehlneelsen.laboratorio.entities.cotizacion;

import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(CotizacionExamenGeneral.class)
@Table(name = "examen_general_cotizacion")
public class CotizacionExamenGeneral implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "EXAMEN_ID")
    ExamenGeneralEntity examenGeneral;

    @Id
    @ManyToOne
    @JoinColumn(name = "COTIZACION_ID")
    CotizacionEntity cotizacion;

    public ExamenGeneralEntity getExamenGeneral() {
        return examenGeneral;
    }

    public void setExamenGeneral(ExamenGeneralEntity examenGeneral) {
        this.examenGeneral = examenGeneral;
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
        if (!(o instanceof CotizacionExamenGeneral)) return false;
        CotizacionExamenGeneral that = (CotizacionExamenGeneral) o;
        return Objects.equals(getExamenGeneral(), that.getExamenGeneral()) &&
                Objects.equals(getCotizacion(), that.getCotizacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExamenGeneral(), getCotizacion());
    }
}
