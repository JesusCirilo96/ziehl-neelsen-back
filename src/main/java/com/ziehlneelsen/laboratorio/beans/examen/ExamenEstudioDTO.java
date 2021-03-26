package com.ziehlneelsen.laboratorio.beans.examen;

public class ExamenEstudioDTO {

    private String nombreEstudio;

    private Integer examenId;

    private boolean porId;

    private Integer estudioId;

    private Integer orden;

    public String getNombreEstudio() {
        return nombreEstudio;
    }

    public void setNombreEstudio(String nombreEstudio) {
        this.nombreEstudio = nombreEstudio;
    }

    public Integer getExamenId() {
        return examenId;
    }

    public void setExamenId(Integer examenId) {
        this.examenId = examenId;
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

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
}
