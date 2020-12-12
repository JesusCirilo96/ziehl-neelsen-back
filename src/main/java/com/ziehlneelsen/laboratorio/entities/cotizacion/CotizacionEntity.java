package com.ziehlneelsen.laboratorio.entities.cotizacion;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@DynamicUpdate
@Table(name = "cotizacion")
public class CotizacionEntity implements Serializable {

    @Id
    @NotBlank(message = "El id de la cotizacion es obligatorio")
    @Column(name = "COTIZACION_ID")
    String cotizacionId;

    @NotBlank(message = "La fecha de la cotizacion es obligatorio")
    @Column(name = "FECHA_COTIZACION")
    String fechaCotizacion;

    @NotBlank(message = "La hora de la cotizacion es obligatorio")
    @Column(name = "HORA_COTIZACION")
    String horaCotizacion;
/*
    @OneToMany(mappedBy = "cotizacion")
    Set<CotizacionExamenGeneral> cotizacionExamenGeneral = new HashSet<>();
*/
    public String getCotizacionId() {
        return cotizacionId;
    }

    public void setCotizacionId(String cotizacionId) {
        this.cotizacionId = cotizacionId;
    }

    public String getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(String fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }

    public String getHoraCotizacion() {
        return horaCotizacion;
    }

    public void setHoraCotizacion(String horaCotizacion) {
        this.horaCotizacion = horaCotizacion;
    }
}
