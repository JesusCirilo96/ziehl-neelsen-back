package com.ziehlneelsen.laboratorio.entities.rol;

import com.ziehlneelsen.laboratorio.entities.menu.MenuEntity;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.*;

@Entity
@IdClass(RolMenu.class)
@Table(name = "rol_menu")
public class RolMenu implements Serializable {

    @Id
    @Column(name = "ROL_MENU_ID", unique = true, nullable = false)
    private UUID rolMenuId = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "ID_ROL")
    RolEntity  rol;

    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    MenuEntity menu;

    public UUID getRolMenuId() {
        return rolMenuId;
    }

    public void setRolMenuId(UUID rolMenuId) {
        this.rolMenuId = rolMenuId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolMenu)) return false;
        RolMenu rolMenu = (RolMenu) o;
        return Objects.equals(getRolMenuId(), rolMenu.getRolMenuId()) && Objects.equals(getRol(), rolMenu.getRol()) && Objects.equals(getMenu(), rolMenu.getMenu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRolMenuId(), getRol(), getMenu());
    }
}
