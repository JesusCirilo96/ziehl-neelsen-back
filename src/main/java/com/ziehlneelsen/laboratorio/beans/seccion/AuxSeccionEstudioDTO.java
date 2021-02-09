package com.ziehlneelsen.laboratorio.beans.seccion;


public class AuxSeccionEstudioDTO {

    private String nombreEstudio;

    private boolean porId;

    private Integer estudioId;

    private Integer seccionId;

    private Integer orden;

    public String getNombreEstudio() {
        return nombreEstudio;
    }

    public void setNombreEstudio(String nombreEstudio) {
        this.nombreEstudio = nombreEstudio;
    }

    public boolean isPorId() {
        return porId;
    }

    public void setPorId(boolean porId) {
        this.porId = porId;
    }

    public Integer getEstudioId() {
        return estudioId;
    }

    public void setEstudioId(Integer estudioId) {
        this.estudioId = estudioId;
    }

    public Integer getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(Integer seccionId) {
        this.seccionId = seccionId;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
}
