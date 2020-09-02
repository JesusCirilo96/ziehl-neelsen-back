package com.ziehlneelsen.laboratorio.entities.estudio;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@DynamicUpdate
@Table(name = "cat_estudio")
public class EstudioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ESTUDIO_ID")
    Integer estudioId;

    @NotBlank
    @Column(name = "NOMBRE")
    String nombre;

    @Column(name = "ESTADO", columnDefinition = "boolean default true")
    Boolean estado;


    @OneToMany(mappedBy = "estudio")
    Set<ReferenciaEntity> refencia = new HashSet<>();

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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
