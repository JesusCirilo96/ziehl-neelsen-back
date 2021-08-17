package com.ziehlneelsen.laboratorio.dao.persona;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UserAuthDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UsuarioDTO;

public interface UsuarioLoginDAO {
    /**
     * metodo para realizar el login del usuario
     * @param user el usuario
     * @param password la contrasena del usuario
     * @return El objeto de usuario
     */
    UserAuthDTO login(String user, String password);

    ResponseDTO updateData(UsuarioDTO usuarioDTO);
}
