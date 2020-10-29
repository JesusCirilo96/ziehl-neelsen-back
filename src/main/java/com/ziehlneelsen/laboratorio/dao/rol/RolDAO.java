package com.ziehlneelsen.laboratorio.dao.rol;

import com.ziehlneelsen.laboratorio.beans.rol.RolMenuDTO;

public interface RolDAO {

    /**
     * Buscar todos los menus relacionados con el ROL
     * @param rolId El ID del rol
     * @return El rol con sus menus relacionados
     */
    public RolMenuDTO findMenuByRol(Integer rolId);
}
