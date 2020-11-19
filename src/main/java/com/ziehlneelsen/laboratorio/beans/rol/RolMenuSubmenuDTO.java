package com.ziehlneelsen.laboratorio.beans.rol;

import com.ziehlneelsen.laboratorio.beans.menu.MenuDTO;
import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;

import java.util.List;

public class RolMenuSubmenuDTO {

    RolEntity rol;

    List<MenuDTO> menu;

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

    public List<MenuDTO> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuDTO> menu) {
        this.menu = menu;
    }
}
