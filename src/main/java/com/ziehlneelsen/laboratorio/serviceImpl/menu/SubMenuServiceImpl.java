package com.ziehlneelsen.laboratorio.serviceImpl.menu;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.entities.menu.SubMenuEntity;
import com.ziehlneelsen.laboratorio.repository.menu.SubMenuRepository;
import com.ziehlneelsen.laboratorio.service.menu.SubMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubMenuServiceImpl implements SubMenuService {

    @Autowired
    SubMenuRepository subMenuRepository;

    @Override
    public List<SubMenuEntity> findAll() {
        return subMenuRepository.findAll();
    }

    @Override
    public Optional<SubMenuEntity> findById(Integer id) {
        return subMenuRepository.findById(id);
    }

    @Override
    public ResponseDTO save(SubMenuEntity subMenu) {
        ResponseDTO response = new ResponseDTO();

        if(null != subMenu.getSubMenuId() && subMenuRepository.findById(subMenu.getSubMenuId()).isPresent()){
            subMenuRepository.save(subMenu);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != subMenu){
            try{
                subMenuRepository.save(subMenu);
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
