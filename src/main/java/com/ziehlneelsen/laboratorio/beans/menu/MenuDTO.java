package com.ziehlneelsen.laboratorio.beans.menu;

import java.util.List;

public class MenuDTO {

    Integer menuId;

    String nombre;

    String ruta;

    Boolean dropdown;

    String icono;

    List<SubMenuDTO> submenu;

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

    public List<SubMenuDTO> getSubmenu() {
        return submenu;
    }

    public void setSubmenu(List<SubMenuDTO> submenu) {
        this.submenu = submenu;
    }
}
