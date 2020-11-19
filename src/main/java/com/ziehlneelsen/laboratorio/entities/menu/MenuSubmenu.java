package com.ziehlneelsen.laboratorio.entities.menu;

import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;
import com.ziehlneelsen.laboratorio.entities.rol.RolMenu;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(MenuSubmenu.class)
@Table(name = "menu_sub_menu")
public class MenuSubmenu implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    MenuEntity menu;

    @Id
    @ManyToOne
    @JoinColumn(name = "SUB_MENU_ID")
    SubMenuEntity subMenu;

    public MenuEntity getMenu() {
        return menu;
    }

    public void setMenu(MenuEntity menu) {
        this.menu = menu;
    }

    public SubMenuEntity getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(SubMenuEntity subMenu) {
        this.subMenu = subMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuSubmenu)) return false;
        MenuSubmenu that = (MenuSubmenu) o;
        return Objects.equals(getMenu(), that.getMenu()) &&
                Objects.equals(getSubMenu(), that.getSubMenu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMenu(), getSubMenu());
    }
}
