package com.ziehlneelsen.laboratorio.entities.recepcion;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "recepcion")
@DynamicUpdate
public class RecepcionEntity implements Serializable {

    @Id
    @Column(name = "RECEPCION_ID")
    private String recepcionId;

    @NotBlank(message = "La fecha de ingreso no puede estar vacia")
    @Column(name = "FECHA_INGRESO")
    private String fechaIngreso;

    @NotBlank(message = "La hora de ingreso no puede estar vacia")
    @Column(name = "HORA_INGRESO")
    private String horaIngreso;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Column(name = "FICHA")
    private Integer ficha;

    @Column(name = "SUB_TOTAL")
    private Float subTotal;

    @Column(name = "DESCUENTO")
    private Float descuento;

    @Column(name = "ANTICIPO")
    private Float anticipo;

    @Column(name = "RESTANTE")
    private Float restante;

    @NotBlank(message = "El ID del usuario no puede ser vacio")
    @Column(name = "USUARIO_ID")
    private Integer usuarioId;

    @NotBlank(message = "El ID del medico no puede ser vacio")
    @Column(name = "MEDICO_ID")
    private Integer medicoId;

    @NotBlank(message = "El ID del paciente no puede ser vacio")
    @Column(name = "PACIENTE_ID")
    private Integer pacienteId;

    public String getRecepcionId() {
        return recepcionId;
    }

    public void setRecepcionId(String recepcionId) {
        this.recepcionId = recepcionId;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public Integer getFicha() {
        return ficha;
    }

    public void setFicha(Integer ficha) {
        this.ficha = ficha;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Float getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(Float anticipo) {
        this.anticipo = anticipo;
    }

    public Float getRestante() {
        return restante;
    }

    public void setRestante(Float restante) {
        this.restante = restante;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Integer medicoId) {
        this.medicoId = medicoId;
    }

    public Integer getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Integer pacienteId) {
        this.pacienteId = pacienteId;
    }
}
