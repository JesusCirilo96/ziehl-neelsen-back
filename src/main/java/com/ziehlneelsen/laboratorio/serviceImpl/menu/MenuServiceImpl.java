package com.ziehlneelsen.laboratorio.serviceImpl.menu;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.entities.menu.MenuEntity;
import com.ziehlneelsen.laboratorio.repository.menu.MenuRepository;
import com.ziehlneelsen.laboratorio.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public List<MenuEntity> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Optional<MenuEntity> findById(Integer id) {
        return menuRepository.findById(id);
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
