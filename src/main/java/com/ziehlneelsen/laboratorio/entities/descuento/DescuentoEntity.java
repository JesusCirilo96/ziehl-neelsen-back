package com.ziehlneelsen.laboratorio.entities.descuento;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@DynamicUpdate
@Table(name = "cat_descuento")
public class DescuentoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DESCUENTO_ID")
    private Integer descuentoId;

    @NotBlank(message = "El nombre del descuento es obligatorio")
    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @NotBlank(message = "La fecha de inicio es obligatoria")
    @Column(name = "FECHA_INICIO")
    private String fechaInicio;

    @NotBlank(message = "La fecha de finalizacion es obligatoria")
    @Column(name = "FECHA_FIN")
    private String fechaFin;

    @Column(name = "DIAS")
    private String dias;

    @Column(name = "ESTADO", columnDefinition = "boolean default true")
    private Boolean estado;

    @Column(name = "FECHA_CREACION")
    private String fechaCreacion;

    @Column(name = "FECHA_ACTUALIZACION")
    private String fechaActualizacion;

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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
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
