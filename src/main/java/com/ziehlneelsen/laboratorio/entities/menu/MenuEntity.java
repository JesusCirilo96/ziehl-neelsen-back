package com.ziehlneelsen.laboratorio.entities.menu;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@DynamicUpdate
@Table(name = "menu")
public class MenuEntity {

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
}
