package com.ziehlneelsen.laboratorio.beans.descuento;

import java.util.UUID;

public class ExamenDescuentoAuxDTO {
    private UUID examenDescuentoId;
    private Integer examenId;
    private String nombreEstudio;
    private Integer porcentajeDescuento;
    private String porcentajeDescuentoText;
    private Float descuento;
    private String accion;//la accion a realizar al examen  editar , eliminar, agregar

    public UUID getExamenDescuentoId() {
        return examenDescuentoId;
    }

    public void setExamenDescuentoId(UUID examenDescuentoId) {
        this.examenDescuentoId = examenDescuentoId;
    }

    public Integer getExamenId() {
        return examenId;
    }

    public void setExamenId(Integer examenId) {
        this.examenId = examenId;
    }

    public String getNombreEstudio() {
        return nombreEstudio;
    }

    public void setNombreEstudio(String nombreEstudio) {
        this.nombreEstudio = nombreEstudio;
    }

    public Integer getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Integer porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getPorcentajeDescuentoText() {
        return porcentajeDescuentoText;
    }

    public void setPorcentajeDescuentoText(String porcentajeDescuentoText) {
        this.porcentajeDescuentoText = porcentajeDescuentoText;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}
