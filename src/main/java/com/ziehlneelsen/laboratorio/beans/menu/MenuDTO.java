package com.ziehlneelsen.laboratorio.beans.menu;

import java.util.List;

public class MenuDTO {

    private Integer menuId;

    private String nombre;

    private String ruta;

    private Boolean dropdown;

    private String icono;

    private Boolean estado;

    private List<SubMenuDTO> submenu;

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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
