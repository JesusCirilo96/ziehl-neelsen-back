package com.ziehlneelsen.laboratorio.beans.descuento;

import java.util.List;

public class PaqueteSaveDTO {
    private Integer paqueteId;
    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private Boolean estado;
    private String operacion;
    private String fechaCreacion;
    private List<Integer> dias;
    private Float precio;
    private Integer porcentaje;
    private String porcentajeDescuentoTexto;
    private Float descuento;
    private List<ExamenPaqueteAuxDTO> examen;

    public Integer getPaqueteId() {
        return paqueteId;
    }

    public void setPaqueteId(Integer paqueteId) {
        this.paqueteId = paqueteId;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<Integer> getDias() {
        return dias;
    }

    public void setDias(List<Integer> dias) {
        this.dias = dias;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getPorcentajeDescuentoTexto() {
        return porcentajeDescuentoTexto;
    }

    public void setPorcentajeDescuentoTexto(String porcentajeDescuentoTexto) {
        this.porcentajeDescuentoTexto = porcentajeDescuentoTexto;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public List<ExamenPaqueteAuxDTO> getExamen() {
        return examen;
    }

    public void setExamen(List<ExamenPaqueteAuxDTO> examen) {
        this.examen = examen;
    }
}
