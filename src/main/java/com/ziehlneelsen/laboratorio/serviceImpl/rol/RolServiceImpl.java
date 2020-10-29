package com.ziehlneelsen.laboratorio.serviceImpl.rol;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.rol.RolMenuDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.rol.RolDAO;
import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;
import com.ziehlneelsen.laboratorio.repository.rol.RolRepository;
import com.ziehlneelsen.laboratorio.service.rol.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    RolRepository rolRepository;

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
    public RolMenuDTO findMenuByRol(Integer rolId){
        return rolDAO.findMenuByRol(rolId);
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
