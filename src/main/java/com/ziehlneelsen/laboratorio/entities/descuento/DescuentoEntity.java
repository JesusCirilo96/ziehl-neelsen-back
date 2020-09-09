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
    Integer descuentoId;

    @NotBlank(message = "El nombre del descuento es obligatorio")
    @Column(name = "nombre")
    String nombre;

    @NotBlank(message = "La cantidad de descuento es obligatorio")
    @Column(name = "DESCUENTO")
    Float descuento;

    @Column(name = "ESTADO", columnDefinition = "boolean default true")
    Boolean estado;

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
}
