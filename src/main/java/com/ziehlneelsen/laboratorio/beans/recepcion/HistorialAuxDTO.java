package com.ziehlneelsen.laboratorio.beans.recepcion;

public class HistorialAuxDTO {
    private Integer folio;

    private String fechaIngreso;

    private String horaIngreso;

    private String recepcionId;

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String getRecepcionId() {
        return recepcionId;
    }

    public void setRecepcionId(String recepcionId) {
        this.recepcionId = recepcionId;
    }
}
