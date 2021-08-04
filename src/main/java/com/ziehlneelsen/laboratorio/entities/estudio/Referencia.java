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
    private String masculino;

    @Column(name = "FEMENINO")
    private String femenino;

    @Column(name = "GENERAL")
    private String general;

    @Column(name = "ORDEN" )
    private Integer orden;

    @Column(name="NOTA")
    private String nota;

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

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Referencia that = (Referencia) o;
        return Objects.equals(referenciaId, that.referenciaId) &&
                Objects.equals(estudio, that.estudio) &&
                Objects.equals(clasificacionPaciente, that.clasificacionPaciente) &&
                Objects.equals(masculino, that.masculino) &&
                Objects.equals(femenino, that.femenino) &&
                Objects.equals(general, that.general) &&
                Objects.equals(orden, that.orden) &&
                Objects.equals(nota, that.nota) &&
                Objects.equals(fechaCreacion, that.fechaCreacion) &&
                Objects.equals(fechaActualizacion, that.fechaActualizacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(referenciaId, estudio, clasificacionPaciente, masculino, femenino, general, orden, nota, fechaCreacion, fechaActualizacion);
    }
}
