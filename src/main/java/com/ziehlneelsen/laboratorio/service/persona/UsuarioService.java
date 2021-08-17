package com.ziehlneelsen.laboratorio.service.persona;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UserAuthDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UsuarioDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UsuarioRolDTO;
import com.ziehlneelsen.laboratorio.entities.persona.UsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<UsuarioEntity> findAll();

    Optional<UsuarioEntity> findById(Integer id);

    UsuarioRolDTO findRolByUsuario(Integer usuarioId);

    ResponseDTO save(UsuarioEntity usuario);

    UserAuthDTO  authenticate(String user, String password);

    ResponseDTO actualizaDatos(UsuarioDTO usuarioDTO);
}
