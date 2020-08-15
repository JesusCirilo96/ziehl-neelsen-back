package com.ziehlneelsen.laboratorio.service.menu;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.menu.SubMenuEntity;

import java.util.List;
import java.util.Optional;

public interface SubMenuService {
    public List<SubMenuEntity> findAll();

    public Optional<SubMenuEntity> findById(Integer id);

    public ResponseDTO save(SubMenuEntity subMenu);
}
