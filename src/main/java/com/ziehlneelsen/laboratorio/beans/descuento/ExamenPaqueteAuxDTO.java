package com.ziehlneelsen.laboratorio.beans.descuento;

import java.util.UUID;

public class ExamenPaqueteAuxDTO {
    private UUID examenPaqueteId;
    private Integer examenId;
    private String nombre;
    private String accion;//la accion a realizar al examen  editar , eliminar, agregar

    public UUID getExamenPaqueteId() {
        return examenPaqueteId;
    }

    public void setExamenPaqueteId(UUID examenPaqueteId) {
        this.examenPaqueteId = examenPaqueteId;
    }

    public Integer getExamenId() {
        return examenId;
    }

    public void setExamenId(Integer examenId) {
        this.examenId = examenId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}
