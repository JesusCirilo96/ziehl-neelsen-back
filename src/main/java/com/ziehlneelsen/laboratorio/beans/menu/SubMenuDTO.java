package com.ziehlneelsen.laboratorio.beans.menu;

public class SubMenuDTO {

    Integer subMenuId;

    String nombre;

    String ruta;

    Boolean dropdown;

    String icono;

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
}
