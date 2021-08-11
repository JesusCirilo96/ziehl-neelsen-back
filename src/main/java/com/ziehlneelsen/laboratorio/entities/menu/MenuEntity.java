package com.ziehlneelsen.laboratorio.entities.menu;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@DynamicUpdate
@Table(name = "menu")
public class MenuEntity implements Serializable {

    /**
     * Id del menu
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ID")
    Integer menuId;

    /**
     * Nombre del menu
     */
    @NotBlank
    @Column(name = "NOMBRE")
    String nombre;

    /**
     * Ruta del menu
     */
    @NotBlank
    @Column(name = "RUTA")
    String ruta;

    /**
     * Identificamos si va a ser un menu desplegable
     */
    @Column(name = "DROPDOWN")
    Boolean dropdown;

    /**
     * Icono a mostrar en el menu
     */
    @Column(name = "ICONO")
    String icono;

    @Column(name = "ESTADO", columnDefinition = "boolean default true")
    Boolean estado;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
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
