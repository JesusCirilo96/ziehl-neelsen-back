package com.ziehlneelsen.laboratorio.dao.persona;

import com.ziehlneelsen.laboratorio.beans.persona.UsuarioRolDTO;

import java.util.List;

public interface UsuarioRolDAO {

    /**
     * Metodo para buscar los roles del usuario
     * @param usuarioId El ID del usuario
     * @return Los roles del usuario
     */
    public UsuarioRolDTO findRolByUsuario(Integer usuarioId);

}
