package com.ziehlneelsen.laboratorio.service.persona;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UserAuthDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UsuarioRolDTO;
import com.ziehlneelsen.laboratorio.entities.persona.UsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<UsuarioEntity> findAll();

    public Optional<UsuarioEntity> findById(Integer id);

    public UsuarioRolDTO findRolByUsuario(Integer usuarioId);

    public ResponseDTO save(UsuarioEntity usuario);

    public UserAuthDTO  authenticate(String user, String password);
}
