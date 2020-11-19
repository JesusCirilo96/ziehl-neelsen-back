package com.ziehlneelsen.laboratorio.entities.menu;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@DynamicUpdate
@Table(name = "sub_menu")
public class SubMenuEntity implements Serializable {

    /**
     * Id del sub menu
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUB_MENU_ID")
    Integer subMenuId;

    /**
     * Nombre del sub menu
     */
    @NotBlank
    @Column(name = "NOMBRE")
    String nombre;

    /**
     * Ruta del sub menu
     */
    @NotBlank
    @Column(name = "RUTA")
    String ruta;

    /**
     * Identificamos si va a ser un menu desplegable
     */
    @NotBlank
    @Column(name = "DROPDOWN")
    Boolean dropdown;

    /**
     * Icono a mostrar en el menu
     */
    @Column(name = "ICONO")
    String icono;

    @Column(name = "ESTADO", columnDefinition = "boolean default true")
    Boolean estado;

    public Integer getSubMenuId() {
        return subMenuId;
    }

    public void setSubMenuId(Integer subMenuId) {
        this.subMenuId = subMenuId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Boolean getDropdown() {
        return dropdown;
    }

    public void setDropdown(Boolean dropdown) {
        this.dropdown = dropdown;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
