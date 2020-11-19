package com.ziehlneelsen.laboratorio.dao.rol;

import com.ziehlneelsen.laboratorio.beans.rol.RolMenuDTO;
import com.ziehlneelsen.laboratorio.beans.rol.RolSubMenuDTO;

public interface RolDAO {

    /**
     * Buscar todos los menus relacionados con el ROL
     * @param rolId El ID del rol
     * @return El rol con sus menus relacionados
     */
    public RolMenuDTO findMenuByRol(Integer rolId);

    /**
     * Buscar los submenus relacionados con el rol
     * @param rolId El ID del rol
     * @return Objeto con los submenus
     */
    public RolSubMenuDTO findSubMenuByRol(Integer rolId);
}
