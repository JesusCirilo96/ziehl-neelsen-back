package com.ziehlneelsen.laboratorio.entities.metodo;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@DynamicUpdate
@Table(name = "cat_metodo")
public class MetodoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "METODO_ID")
    Integer metodoId;

    @NotBlank
    @Column(name = "NOMBRE")
    String nombre;

    @Column(name = "ESTADO", columnDefinition = "boolean default true")
    Boolean estado;

    public Integer getMetodoId() {
        return metodoId;
    }

    public void setMetodoId(Integer metodoId) {
        this.metodoId = metodoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
