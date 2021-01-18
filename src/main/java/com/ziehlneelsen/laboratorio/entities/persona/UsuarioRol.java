package com.ziehlneelsen.laboratorio.entities.persona;

import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@IdClass(UsuarioRol.class)
@Table(name = "usuario_rol")
public class UsuarioRol implements Serializable {

    @Id
    @Column(name = "USUARIO_ROL_ID", unique = true, nullable = false)
    private UUID usuarioRolId = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "ID_ROL")
    RolEntity rol;

    public UUID getUsuarioRolId() {
        return usuarioRolId;
    }

    public void setUsuarioRolId(UUID usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

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
        return Objects.equals(getUsuarioRolId(), that.getUsuarioRolId()) && Objects.equals(getUsuario(), that.getUsuario()) && Objects.equals(getRol(), that.getRol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsuarioRolId(), getUsuario(), getRol());
    }
}