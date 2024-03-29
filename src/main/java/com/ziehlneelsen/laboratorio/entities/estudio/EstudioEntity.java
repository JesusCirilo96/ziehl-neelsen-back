package com.ziehlneelsen.laboratorio.entities.estudio;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@DynamicUpdate
@Table(name = "cat_estudio")
public class EstudioEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ESTUDIO_ID")
    Integer estudioId;

    @NotBlank
    @Column(name = "NOMBRE")
    String nombre;

    @Column(name = "RESULTADO")
    String resultado;

    @Column(name = "RESULTADO_SELECT")
    String resultadoSelect;

    @Column(name = "MOSTRAR_INPUT")
    Boolean mostrarInput;

    @Column(name = "COMODIN")
    Boolean comodin;

    @Column(name = "ESTADO", columnDefinition = "boolean default true")
    Boolean estado;

    @Column(name = "FECHA_CREACION")
    String fechaCreacion;

    @Column(name = "FECHA_ACTUALIZACION")
    String fechaActualizacion;

    public EstudioEntity(){}

    public Integer getEstudioId() {
        return estudioId;
    }

    public void setEstudioId(Integer estudioId) {
        this.estudioId = estudioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultadoSelect() {
        return resultadoSelect;
    }

    public void setResultadoSelect(String resultadoSelect) {
        this.resultadoSelect = resultadoSelect;
    }

    public Boolean getMostrarInput() {
        return mostrarInput;
    }

    public void setMostrarInput(Boolean mostrarInput) {
        this.mostrarInput = mostrarInput;
    }

    public Boolean getComodin() {
        return comodin;
    }

    public void setComodin(Boolean comodin) {
        this.comodin = comodin;
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
