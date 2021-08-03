package com.ziehlneelsen.laboratorio.entities.seccion;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@DynamicUpdate
@Table(name = "cat_seccion")
public class SeccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SECCION_ID")
    Integer seccionId;

    @NotBlank
    @Column(name = "NOMBRE")
    String nombre;

    @Column(name = "TEXTO_CENTRO")
    String textoCent;

    @Column(name = "TEXTO_DERECHO")
    String textoDer;

    @Column(name = "TITULO")
    String titulo;

    @Column(name = "ESTADO", columnDefinition = "boolean default true")
    Boolean estado;

    @Column(name = "FECHA_CREACION")
    String fechaCreacion;

    @Column(name = "FECHA_ACTUALIZACION")
    String fechaActualizacion;

    public Integer getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(Integer seccionId) {
        this.seccionId = seccionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
