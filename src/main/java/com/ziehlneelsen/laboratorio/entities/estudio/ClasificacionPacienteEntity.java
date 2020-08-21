package com.ziehlneelsen.laboratorio.entities.estudio;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
}
