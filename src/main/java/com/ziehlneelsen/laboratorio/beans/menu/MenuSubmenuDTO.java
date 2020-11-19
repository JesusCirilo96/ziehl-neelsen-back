package com.ziehlneelsen.laboratorio.beans.menu;

import com.ziehlneelsen.laboratorio.entities.menu.MenuEntity;
import com.ziehlneelsen.laboratorio.entities.menu.SubMenuEntity;

import java.util.List;

public class MenuSubmenuDTO {

    MenuEntity menu;

    List<SubMenuEntity> subMenu;

    public MenuEntity getMenu() {
        return menu;
    }

    public void setMenu(MenuEntity menu) {
        this.menu = menu;
    }

    public List<SubMenuEntity> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<SubMenuEntity> subMenu) {
        this.subMenu = subMenu;
    }
}
