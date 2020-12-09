package com.ziehlneelsen.laboratorio.entities.examen;

import com.ziehlneelsen.laboratorio.entities.cotizacion.CotizacionExamenGeneral;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@DynamicUpdate
@Table(name = "examen_general")
public class ExamenGeneralEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EXAMEN_ID")
    Integer examenGeneralId;

    @NotBlank(message = "En nombre es obligatorio")
    @Column(name = "NOMBRE")
    String nombre;

    @Column(name = "ALIAS")
    String alias;

    @Column(name = "TITULO_EXAMEN")
    String titulo;

    @Column(name = "ESTADO", columnDefinition = "boolean default true")
    Boolean estado;

    @Column(name = "PRECIO")
    Float precio;

    @Column(name = "CLAVE")
    String clave;

    @Column(name = "CATEGORIA_ID")
    Integer categoriaId;

    @Column(name = "FECHA_CREACION")
    String fechaCreacion;

    @Column(name = "FECHA_ACTUALIZACION")
    String fechaActualizacion;



    @OneToMany(mappedBy = "examenGeneral")
    Set<CotizacionExamenGeneral> cotizacionExamenGeneral = new HashSet<>();

    public Integer getExamenGeneralId() {
        return examenGeneralId;
    }

    public void setExamenGeneralId(Integer examenGeneralId) {
        this.examenGeneralId = examenGeneralId;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Set<CotizacionExamenGeneral> getCotizacionExamenGeneral() {
        return cotizacionExamenGeneral;
    }

    public void setCotizacionExamenGeneral(Set<CotizacionExamenGeneral> cotizacionExamenGeneral) {
        this.cotizacionExamenGeneral = cotizacionExamenGeneral;
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
