package com.ziehlneelsen.laboratorio.entities.persona;

import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(UsuarioRol.class)
@Table(name = "usuario_rol")
public class UsuarioRol implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    UsuarioEntity usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_ROL")
    RolEntity rol;

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioRol)) return false;
        UsuarioRol that = (UsuarioRol) o;
        return Objects.equals(getUsuario(), that.getUsuario()) &&
                Objects.equals(getRol(), that.getRol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsuario(), getRol());
    }
}