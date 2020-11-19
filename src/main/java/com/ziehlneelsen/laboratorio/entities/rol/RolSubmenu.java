package com.ziehlneelsen.laboratorio.entities.rol;

import com.ziehlneelsen.laboratorio.entities.menu.SubMenuEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(RolSubmenu.class)
@Table(name = "rol_sub_menu")
public class RolSubmenu implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_ROL")
    RolEntity  rol;

    @Id
    @ManyToOne
    @JoinColumn(name = "SUB_MENU_ID")
    SubMenuEntity subMenu;

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
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
        if (!(o instanceof RolSubmenu)) return false;
        RolSubmenu that = (RolSubmenu) o;
        return Objects.equals(getRol(), that.getRol()) &&
                Objects.equals(getSubMenu(), that.getSubMenu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRol(), getSubMenu());
    }
}
