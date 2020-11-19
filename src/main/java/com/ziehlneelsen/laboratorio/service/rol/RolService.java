package com.ziehlneelsen.laboratorio.service.rol;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.rol.RolMenuDTO;
import com.ziehlneelsen.laboratorio.beans.rol.RolMenuSubmenuDTO;
import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;

import java.util.List;
import java.util.Optional;

public interface RolService {

    public List<RolEntity> findAll();

    public Optional<RolEntity> findById(Integer id);

    public RolMenuSubmenuDTO findMenuByRol(Integer rolId);

    public ResponseDTO save(RolEntity rol);

}
