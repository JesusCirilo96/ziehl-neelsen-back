package com.ziehlneelsen.laboratorio.entities.menu;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@DynamicUpdate
@Table(name = "sub_menu")
public class SubMenuEntity {

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
}
