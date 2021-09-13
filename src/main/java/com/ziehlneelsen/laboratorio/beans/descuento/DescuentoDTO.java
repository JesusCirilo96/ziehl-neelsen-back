package com.ziehlneelsen.laboratorio.beans.descuento;

public class DescuentoDTO {
    private Integer descuentoId;
    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private String dias;
    private Integer porcentaje;
    private String porcentajeText;
    private Float descuentoMonto;
    private Boolean estado;

    public Integer getDescuentoId() {
        return descuentoId;
    }

    public void setDescuentoId(Integer descuentoId) {
        this.descuentoId = descuentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getPorcentajeText() {
        return porcentajeText;
    }

    public void setPorcentajeText(String porcentajeText) {
        this.porcentajeText = porcentajeText;
    }

    public Float getDescuentoMonto() {
        return descuentoMonto;
    }

    public void setDescuentoMonto(Float descuentoMonto) {
        this.descuentoMonto = descuentoMonto;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
