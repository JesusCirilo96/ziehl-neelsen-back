package com.ziehlneelsen.laboratorio.beans.examen;

public class ExamenSeccionSaveDTO {

    private String nombreSeccion;

    private String titulo;

    private String textoCent;

    private String textoDer;

    private Integer examenId;

    private boolean porId;

    private Integer seccionId;

    private Integer orden;

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTextoCent() {
        return textoCent;
    }

    public void setTextoCent(String textoCent) {
        this.textoCent = textoCent;
    }

    public String getTextoDer() {
        return textoDer;
    }

    public void setTextoDer(String textoDer) {
        this.textoDer = textoDer;
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
