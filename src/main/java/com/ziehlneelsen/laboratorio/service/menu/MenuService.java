package com.ziehlneelsen.laboratorio.service.menu;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.menu.MenuEntity;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    public List<MenuEntity> findAll();

    public Optional<MenuEntity> findById(Integer id);

    public ResponseDTO save(MenuEntity menu);
}
