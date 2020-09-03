package com.ziehlneelsen.laboratorio.entities.examen;

import com.ziehlneelsen.laboratorio.entities.cotizacion.CotizacionExamenSencillo;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@DynamicUpdate
@Table(name = "examen_sencillo")
public class ExamenSencilloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EXAMEN_SENCILLO_ID")
    Integer examenSencilloId;

    @NotBlank
    @Column(name = "NOMBRE")
    String nombre;

    @Column(name = "ALIAS")
    String alias;

    @Column(name = "ESTADO", columnDefinition = "boolean default true")
    Boolean estado;

    @Column(name = "PRECIO")
    Float precio;

    @OneToMany(mappedBy = "examenSencillo")
    Set<CotizacionExamenSencillo> cotizacionExamenSencillo = new HashSet<>();

    public Integer getExamenSencilloId() {
        return examenSencilloId;
    }

    public void setExamenSencilloId(Integer examenSencilloId) {
        this.examenSencilloId = examenSencilloId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
