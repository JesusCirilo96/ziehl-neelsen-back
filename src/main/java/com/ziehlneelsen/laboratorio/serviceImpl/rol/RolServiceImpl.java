package com.ziehlneelsen.laboratorio.serviceImpl.rol;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.menu.MenuDTO;
import com.ziehlneelsen.laboratorio.beans.menu.MenuSubmenuDTO;
import com.ziehlneelsen.laboratorio.beans.menu.SubMenuDTO;
import com.ziehlneelsen.laboratorio.beans.rol.RolMenuDTO;
import com.ziehlneelsen.laboratorio.beans.rol.RolMenuSubmenuDTO;
import com.ziehlneelsen.laboratorio.beans.rol.RolSubMenuDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.menu.MenuDao;
import com.ziehlneelsen.laboratorio.dao.rol.RolDAO;
import com.ziehlneelsen.laboratorio.entities.menu.MenuEntity;
import com.ziehlneelsen.laboratorio.entities.menu.MenuSubmenu;
import com.ziehlneelsen.laboratorio.entities.menu.SubMenuEntity;
import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;
import com.ziehlneelsen.laboratorio.repository.rol.RolRepository;
import com.ziehlneelsen.laboratorio.service.rol.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    RolRepository rolRepository;

    @Autowired
    MenuDao menuDao;

    @Autowired
    RolDAO rolDAO;

    @Override
    public List<RolEntity> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public Optional<RolEntity> findById(Integer id) {
        return rolRepository.findById(id);
    }

    @Override
    public RolMenuSubmenuDTO findMenuByRol(Integer rolId){
        RolMenuDTO rolMenuDTO = rolDAO.findMenuByRol(rolId);
        RolSubMenuDTO rolSubMenu = findSubMenuByRol(rolId);

        List<MenuDTO> lisMenuDTO = new ArrayList<>();

        if(rolMenuDTO.getMenu() != null){
            rolMenuDTO.getMenu().forEach((menu) -> {
                MenuDTO menuDTO = new MenuDTO();

                menuDTO.setMenuId(menu.getMenuId());
                menuDTO.setNombre(menu.getNombre());
                menuDTO.setRuta(menu.getRuta());
                menuDTO.setDropdown(menu.getDropdown());
                menuDTO.setIcono(menu.getIcono());
                System.out.println("ES DROPDOWN " + menuDTO.getDropdown());
                if(menuDTO.getDropdown()){

                    System.out.println("Dentro del if DROPDOWN");
                    MenuSubmenuDTO menuSubmenu = menuDao.getSubmenuByMenu(menuDTO.getMenuId());
                    List<SubMenuEntity> submenuList = menuSubmenu.getSubMenu();

                    List<SubMenuDTO> listSubMenuDTO = new ArrayList<>();

                    rolSubMenu.getSubMenu().forEach((list) -> {
                        submenuList.forEach((submenu) -> {
                            if(list.getSubMenuId() == submenu.getSubMenuId()){
                                SubMenuDTO subMenuDTO = new SubMenuDTO();
                                subMenuDTO.setSubMenuId(submenu.getSubMenuId());
                                subMenuDTO.setNombre(submenu.getNombre());
                                subMenuDTO.setRuta(submenu.getRuta());
                                subMenuDTO.setDropdown(submenu.getDropdown());
                                subMenuDTO.setIcono(submenu.getIcono());

                                listSubMenuDTO.add(subMenuDTO);
                            }
                        });
                        menuDTO.setSubmenu(listSubMenuDTO);
                    });


                }
                lisMenuDTO.add(menuDTO);
            });
        }

        RolMenuSubmenuDTO rolMenuSubmenu = new RolMenuSubmenuDTO();

        if(rolMenuDTO.getMenu() != null){
            rolMenuSubmenu.setRol(rolMenuDTO.getRol());
            rolMenuSubmenu.setMenu(lisMenuDTO);
        }


        return rolMenuSubmenu;
    }

    private RolSubMenuDTO findSubMenuByRol(Integer rolId){
        return rolDAO.findSubMenuByRol(rolId);
    }

    @Override
    public ResponseDTO save(RolEntity rol) {
        ResponseDTO response = new ResponseDTO();

        if(null != rol.getRolId() && rolRepository.findById(rol.getRolId()).isPresent()){
            rolRepository.save(rol);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != rol){
            try{
                rolRepository.save(rol);
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
