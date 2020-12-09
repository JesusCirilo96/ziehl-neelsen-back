package com.ziehlneelsen.laboratorio.service.menu;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.menu.MenuDTO;
import com.ziehlneelsen.laboratorio.beans.menu.MenuSubmenuDTO;
import com.ziehlneelsen.laboratorio.entities.menu.MenuEntity;

import java.util.List;
import java.util.Optional;

public interface MenuService {

    /**
     * Bucamos todos lo menus
     * @return Lista de menus
     */
    public List<MenuEntity> findAll();

    /**
     * Buscar menu por el ID
     * @param id El ID del menu
     * @return El menu
     */
    public Optional<MenuEntity> findById(Integer id);

    /**
     * Buscar los submenus del menu dado
     * @param id El ID del menu
     * @return Los submenus del menu
     */
    public MenuSubmenuDTO findSubmenuByMenu(Integer id);

    /**
     * Buscar todos los menus con sus respectivos submenus
     * @return La lista con menus y submenus
     */
    public List<MenuDTO> findAllMenuSubmenu();

    /**
     * Guardar un menu nuevo
     * @param menu El objeto del menu a guardar
     * @return La respuesta
     */
    public ResponseDTO save(MenuEntity menu);
}
