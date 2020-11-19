package com.ziehlneelsen.laboratorio.beans.rol;

import com.ziehlneelsen.laboratorio.entities.menu.SubMenuEntity;
import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;

import java.util.List;

public class RolSubMenuDTO {

    RolEntity rol;

    List<SubMenuEntity> subMenu;

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

    public List<SubMenuEntity> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<SubMenuEntity> subMenu) {
        this.subMenu = subMenu;
    }
}
