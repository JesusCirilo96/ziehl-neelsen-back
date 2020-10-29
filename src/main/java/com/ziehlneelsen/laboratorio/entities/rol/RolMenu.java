package com.ziehlneelsen.laboratorio.entities.rol;

import com.ziehlneelsen.laboratorio.entities.menu.MenuEntity;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@IdClass(RolMenu.class)
@Table(name = "rol_menu")
public class RolMenu implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_ROL")
    RolEntity  rol;

    @Id
    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    MenuEntity menu;

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

    public MenuEntity getMenu() {
        return menu;
    }

    public void setMenu(MenuEntity menu) {
        this.menu = menu;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        RolMenu rolMenu = (RolMenu) object;
        return java.util.Objects.equals(rol, rolMenu.rol) &&
                java.util.Objects.equals(menu, rolMenu.menu);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), rol, menu);
    }
}
