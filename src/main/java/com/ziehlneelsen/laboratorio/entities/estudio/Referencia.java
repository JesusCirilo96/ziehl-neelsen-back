package com.ziehlneelsen.laboratorio.entities.estudio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@IdClass(Referencia.class)
@Table(name = "referencia")
public class Referencia implements Serializable {

    @Id
    @Column(name = "REFERENCIA_ID", unique = true, nullable = false)
    private UUID referenciaId = UUID.randomUUID();


    @ManyToOne
    @JoinColumn(name = "ESTUDIO_ID")
    EstudioEntity estudio;

    @ManyToOne
    @JoinColumn(name = "CLASIFICACION_ID")
    ClasificacionPacienteEntity clasificacionPaciente;
    @Column(name = "MASCULINO")
    String masculino;

    @Column(name = "FEMENINO")
    String femenino;

    @Column(name = "GENERAL")
    String general;

    @Column(name = "FECHA_CREACION")
    String fechaCreacion;

    @Column(name = "FECHA_ACTUALIZACION")
    String fechaActualizacion;

    public UUID getReferenciaId() {
        return referenciaId;
    }

    public void setReferenciaId(UUID referenciaId) {
        this.referenciaId = referenciaId;
    }

    public EstudioEntity getEstudio() {
        return estudio;
    }

    public void setEstudio(EstudioEntity estudio) {
        this.estudio = estudio;
    }

    public ClasificacionPacienteEntity getClasificacionPaciente() {
        return clasificacionPaciente;
    }

    public void setClasificacionPaciente(ClasificacionPacienteEntity clasificacionPaciente) {
        this.clasificacionPaciente = clasificacionPaciente;
    }

    public String getMasculino() {
        return masculino;
    }

    public void setMasculino(String masculino) {
        this.masculino = masculino;
    }

    public String getFemenino() {
        return femenino;
    }

    public void setFemenino(String femenino) {
        this.femenino = femenino;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Referencia)) return false;
        Referencia that = (Referencia) o;
        return Objects.equals(getReferenciaId(), that.getReferenciaId()) && Objects.equals(getEstudio(), that.getEstudio()) && Objects.equals(getClasificacionPaciente(), that.getClasificacionPaciente()) && Objects.equals(getMasculino(), that.getMasculino()) && Objects.equals(getFemenino(), that.getFemenino()) && Objects.equals(getGeneral(), that.getGeneral()) && Objects.equals(getFechaCreacion(), that.getFechaCreacion()) && Objects.equals(getFechaActualizacion(), that.getFechaActualizacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReferenciaId(), getEstudio(), getClasificacionPaciente(), getMasculino(), getFemenino(), getGeneral(), getFechaCreacion(), getFechaActualizacion());
    }
}
