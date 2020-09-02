package com.ziehlneelsen.laboratorio.entities.estudio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(ReferenciaEntity.class)
@Table(name = "referencia")
public class ReferenciaEntity implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ESTUDIO_ID")
    EstudioEntity estudio;

    @Id
    @ManyToOne
    @JoinColumn(name = "CLASIFICACION_ID")
    ClasificacionPacienteEntity clasificacionPaciente;

    @Column(name = "MASCULINO")
    String masculino;

    @Column(name = "FEMENINO")
    String femenino;

    @Column(name = "GENERAL")
    String general;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReferenciaEntity)) return false;
        ReferenciaEntity that = (ReferenciaEntity) o;
        return Objects.equals(getEstudio(), that.getEstudio()) &&
                Objects.equals(getClasificacionPaciente(), that.getClasificacionPaciente()) &&
                Objects.equals(getMasculino(), that.getMasculino()) &&
                Objects.equals(getFemenino(), that.getFemenino()) &&
                Objects.equals(getGeneral(), that.getGeneral());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEstudio(), getClasificacionPaciente(), getMasculino(), getFemenino(), getGeneral());
    }
}
