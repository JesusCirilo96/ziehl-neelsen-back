package com.ziehlneelsen.laboratorio.serviceImpl.menu;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.menu.MenuDTO;
import com.ziehlneelsen.laboratorio.beans.menu.MenuSubmenuDTO;
import com.ziehlneelsen.laboratorio.beans.menu.SubMenuDTO;
import com.ziehlneelsen.laboratorio.beans.rol.RolSubMenuDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.rol.RolDAO;
import com.ziehlneelsen.laboratorio.daoImpl.menu.MenuDAOImpl;
import com.ziehlneelsen.laboratorio.entities.menu.MenuEntity;
import com.ziehlneelsen.laboratorio.entities.menu.SubMenuEntity;
import com.ziehlneelsen.laboratorio.repository.menu.MenuRepository;
import com.ziehlneelsen.laboratorio.repository.menu.SubMenuRepository;
import com.ziehlneelsen.laboratorio.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    MenuDAOImpl menuDAO;

    @Autowired
    SubMenuRepository subMenuRepository;

    @Autowired
    RolDAO rolDAO;

    @Override
    public List<MenuEntity> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Optional<MenuEntity> findById(Integer id) {
        return menuRepository.findById(id);
    }

    @Override
    public MenuSubmenuDTO findSubmenuByMenu(Integer id) {
        return menuDAO.getSubmenuByMenu(id);
    }

    @Override
    public List<MenuDTO> findAllMenuSubmenu(){
        List<MenuEntity> menuEntity = menuRepository.findAll();
        List<SubMenuEntity> subMenuEntity = subMenuRepository.findAll();


        List<MenuDTO> lisMenuDTO = new ArrayList<>();

        menuEntity.forEach((menu) -> {
            MenuDTO menuDTO = new MenuDTO();

            menuDTO.setMenuId(menu.getMenuId());
            menuDTO.setNombre(menu.getNombre());
            menuDTO.setRuta(menu.getRuta());
            menuDTO.setDropdown(menu.getDropdown());
            menuDTO.setIcono(menu.getIcono());
            menuDTO.setEstado(menu.getEstado());
            System.out.println("ES DROPDOWN " + menuDTO.getDropdown());
            if(menuDTO.getDropdown()) {

                System.out.println("Dentro del if DROPDOWN");
                MenuSubmenuDTO menuSubmenu = menuDAO.getSubmenuByMenu(menuDTO.getMenuId());
                if (menuSubmenu.getSubMenu() != null) {
                    List<SubMenuEntity> submenuList = menuSubmenu.getSubMenu();

                    List<SubMenuDTO> listSubMenuDTO = new ArrayList<>();

                    subMenuEntity.forEach((list) -> {
                        submenuList.forEach((submenu) -> {
                            if (list.getSubMenuId() == submenu.getSubMenuId()) {
                                SubMenuDTO subMenuDTO = new SubMenuDTO();
                                subMenuDTO.setSubMenuId(submenu.getSubMenuId());
                                subMenuDTO.setNombre(submenu.getNombre());
                                subMenuDTO.setRuta(submenu.getRuta());
                                subMenuDTO.setDropdown(submenu.getDropdown());
                                subMenuDTO.setIcono(submenu.getIcono());
                                subMenuDTO.setEstado(submenu.getEstado());
                                listSubMenuDTO.add(subMenuDTO);
                            }
                        });
                        menuDTO.setSubmenu(listSubMenuDTO);
                    });
                }
            }
            lisMenuDTO.add(menuDTO);
        });

        return lisMenuDTO;
    }

    private RolSubMenuDTO findSubMenuByRol(Integer rolId){
        return rolDAO.findSubMenuByRol(rolId);
    }

    @Override
    public ResponseDTO save(MenuEntity menu) {
        ResponseDTO response = new ResponseDTO();

        if(null != menu.getMenuId() && menuRepository.findById(menu.getMenuId()).isPresent()){
            menuRepository.save(menu);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != menu){
            try{
                menuRepository.save(menu);
                response.setErrorCode(Messages.OK);
                response.setErrorInfo(Messages.REGISTER_OK);
            }catch(DataAccessException ex) {
                response.setErrorCode(Messages.ERROR);
                response.setErrorInfo(ex.getMostSpecificCause().toString());
            }
        }
        return response;
    }

}
