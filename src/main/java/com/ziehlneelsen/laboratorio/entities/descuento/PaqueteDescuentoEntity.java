package com.ziehlneelsen.laboratorio.entities.descuento;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@DynamicUpdate
@Table(name = "cat_paquete")
public class PaqueteDescuentoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAQUETE_ID")
    Integer paqueteId;

    @NotBlank(message = "El nombre del descuento es obligatorio")
    @Column(name = "NOMBRE")
    String nombre;

    @Column(name = "DESCRIPCION")
    String descripcion;

    @NotBlank(message = "La fecha de inicio es obligatorio")
    @Column(name = "FECHA_INICIO")
    String fechaInicio;

    @NotBlank(message = "La fecha final es obligatoria")
    @Column(name = "FECHA_FIN")
    String fechaFin;

    @NotBlank(message = "Los dias son obligatorios")
    @Column(name = "DIAS")
    String dias;

    @Column(name = "PRECIO")
    Float precio;

    @Column(name = "PORCENTAJE_DESCUENTO")
    Integer porcentaje;

    @Column(name = "PORCENTAJE_DESCUENTO_TEXTO")
    String porcentajeDescuentoTexto;

    @Column(name = "DESCUENTO")
    Float descuento;

    @Column(name = "ESTADO", columnDefinition = "boolean default true")
    Boolean estado;

    @Column(name = "FECHA_CREACION")
    String fechaCreacion;

    @Column(name = "FECHA_ACTUALIZACION")
    String fechaActualizacion;

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

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
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

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getPorcentajeDescuentoTexto() {
        return porcentajeDescuentoTexto;
    }

    public void setPorcentajeDescuentoTexto(String porcentajeDescuentoTexto) {
        this.porcentajeDescuentoTexto = porcentajeDescuentoTexto;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
