package com.ziehlneelsen.laboratorio.entities.recepcion;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

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

    @Column(name = "FICHA")
    private Integer ficha;

    @Column(name = "TOTAL")
    private Float total;

    @Column(name = "SUB_TOTAL")
    private Float subTotal;

    @Column(name = "DESCUENTO")
    private Float descuento;

    @Column(name = "ANTICIPO")
    private Float anticipo;

    @Column(name = "RESTANTE")
    private Float restante;

    @Column(name = "MUESTRAS")
    private String muestras;

    @Column(name = "NOTAS")
    private String notas;

    @Column(name = "USUARIO_ID")
    private Integer usuarioId;

    @Column(name = "MEDICO_ID")
    private Integer medicoId;

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

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getMuestras() {
        return muestras;
    }

    public void setMuestras(String muestras) {
        this.muestras = muestras;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecepcionEntity)) return false;
        RecepcionEntity that = (RecepcionEntity) o;
        return Objects.equals(getRecepcionId(), that.getRecepcionId()) && Objects.equals(getFechaIngreso(), that.getFechaIngreso()) && Objects.equals(getHoraIngreso(), that.getHoraIngreso()) && Objects.equals(getFicha(), that.getFicha()) && Objects.equals(getTotal(), that.getTotal()) && Objects.equals(getSubTotal(), that.getSubTotal()) && Objects.equals(getDescuento(), that.getDescuento()) && Objects.equals(getAnticipo(), that.getAnticipo()) && Objects.equals(getRestante(), that.getRestante()) && Objects.equals(getMuestras(), that.getMuestras()) && Objects.equals(getNotas(), that.getNotas()) && Objects.equals(getUsuarioId(), that.getUsuarioId()) && Objects.equals(getMedicoId(), that.getMedicoId()) && Objects.equals(getPacienteId(), that.getPacienteId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecepcionId(), getFechaIngreso(), getHoraIngreso(), getFicha(), getTotal(), getSubTotal(), getDescuento(), getAnticipo(), getRestante(), getMuestras(), getNotas(), getUsuarioId(), getMedicoId(), getPacienteId());
    }
}
