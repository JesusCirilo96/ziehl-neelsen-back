package com.ziehlneelsen.laboratorio.dao.persona;

import com.ziehlneelsen.laboratorio.beans.persona.UserAuthDTO;

public interface UsuarioLoginDAO {
    public UserAuthDTO login(String user, String password);
}
