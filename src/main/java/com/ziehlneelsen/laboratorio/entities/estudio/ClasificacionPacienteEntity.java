package com.ziehlneelsen.laboratorio.entities.estudio;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@DynamicUpdate
@Table(name = "cat_clasificacion_paciente")
public class ClasificacionPacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLASIFICACION_ID")
    Integer clasificacionPacienteId;

    @NotBlank
    @Column(name = "NOMBRE")
    String nombre;

    @NotBlank
    @Column(name = "EDAD_MINIMA")
    String edadMinima;

    @NotBlank
    @Column(name = "EDAD_MAXIMA")
    String edadMaxima;

    @Column(name = "ESTADO", columnDefinition = "boolean default true")
    Boolean estado;

    @Column(name = "FECHA_CREACION")
    String fechaCreacion;

    @Column(name = "FECHA_ACTUALIZACION")
    String fechaActualizacion;

    /*@OneToMany(mappedBy = "clasificacionPaciente")
    Set<ReferenciaEntity> refencia = new HashSet<>();*/

    public Integer getClasificacionPacienteId() {
        return clasificacionPacienteId;
    }

    public void setClasificacionPacienteId(Integer clasificacionPacienteId) {
        this.clasificacionPacienteId = clasificacionPacienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(String edadMinima) {
        this.edadMinima = edadMinima;
    }

    public String getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(String edadMaxima) {
        this.edadMaxima = edadMaxima;
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
