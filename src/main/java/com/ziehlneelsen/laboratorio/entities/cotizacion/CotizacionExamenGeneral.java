package com.ziehlneelsen.laboratorio.entities.cotizacion;

import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@IdClass(CotizacionExamenGeneral.class)
@Table(name = "examen_general_cotizacion")
public class CotizacionExamenGeneral implements Serializable {

    @Id
    @Column(name = "EXAMEN_COTIZACION_ID", unique = true, nullable = false)
    private UUID examenCotizacionId = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "EXAMEN_ID")
    ExamenGeneralEntity examenGeneral;

    @ManyToOne
    @JoinColumn(name = "COTIZACION_ID")
    CotizacionEntity cotizacion;

    public UUID getExamenCotizacionId() {
        return examenCotizacionId;
    }

    public void setExamenCotizacionId(UUID examenCotizacionId) {
        this.examenCotizacionId = examenCotizacionId;
    }

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
        return Objects.equals(getExamenCotizacionId(), that.getExamenCotizacionId()) && Objects.equals(getExamenGeneral(), that.getExamenGeneral()) && Objects.equals(getCotizacion(), that.getCotizacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExamenCotizacionId(), getExamenGeneral(), getCotizacion());
    }
}
