package com.ziehlneelsen.laboratorio.dao.menu;

import com.ziehlneelsen.laboratorio.beans.menu.MenuSubmenuDTO;

public interface MenuDao {

    /**
     * Obtenemos los submenus del menu
     * @param menuId El ID del menu a obtener
     * @return El objeto con los submenus
     */
    public MenuSubmenuDTO getSubmenuByMenu(Integer menuId);
}
