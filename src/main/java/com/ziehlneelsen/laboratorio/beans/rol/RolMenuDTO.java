package com.ziehlneelsen.laboratorio.beans.rol;

import com.ziehlneelsen.laboratorio.entities.menu.MenuEntity;
import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;

import java.util.List;

public class RolMenuDTO {

    RolEntity rol;

    List<MenuEntity> menu;

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

    public List<MenuEntity> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuEntity> menu) {
        this.menu = menu;
    }
}
