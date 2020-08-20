package com.ziehlneelsen.laboratorio.entities.persona;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "cat_medico")
@DynamicUpdate
public class MedicoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEDICO_ID")
    Integer medicoId;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Column(name = "NOMBRE")
    String nombre;

    @NotBlank(message = "El apellido paterno no puede estar vacio")
    @Column(name = "APELLIDO_PATERNO")
    String apellidoPaterno;

    @Column(name = "APELLIDO_MATERNO")
    String apellidoMaterno;

    @Column(name = "ESTADO", columnDefinition = "boolean default true")
    Boolean estado;

    public Integer getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Integer medicoId) {
        this.medicoId = medicoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
