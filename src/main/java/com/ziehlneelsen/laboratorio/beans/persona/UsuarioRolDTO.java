package com.ziehlneelsen.laboratorio.beans.persona;

import com.ziehlneelsen.laboratorio.entities.persona.UsuarioEntity;
import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;

import java.util.List;

public class UsuarioRolDTO {

    UsuarioEntity usuario;

    List<RolEntity> rol;

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public List<RolEntity> getRol() {
        return rol;
    }

    public void setRol(List<RolEntity> rol) {
        this.rol = rol;
    }
}
