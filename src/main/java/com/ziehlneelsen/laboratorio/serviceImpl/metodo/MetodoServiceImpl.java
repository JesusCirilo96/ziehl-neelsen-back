package com.ziehlneelsen.laboratorio.serviceImpl.metodo;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.entities.metodo.MetodoEntity;
import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;
import com.ziehlneelsen.laboratorio.repository.metodo.MetodoRepository;
import com.ziehlneelsen.laboratorio.repository.rol.RolRepository;
import com.ziehlneelsen.laboratorio.service.metodo.MetodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoServiceImpl implements MetodoService {

    @Autowired
    MetodoRepository metodoRepository;

    @Override
    public List<MetodoEntity> findAll() {
        return metodoRepository.findAll();
    }

    @Override
    public Optional<MetodoEntity> findById(Integer id) {
        return metodoRepository.findById(id);
    }

    @Override
    public ResponseDTO save(MetodoEntity metodo) {
        ResponseDTO response = new ResponseDTO();

        if(null != metodo.getMetodoId() && metodoRepository.findById(metodo.getMetodoId()).isPresent()){
            metodoRepository.save(metodo);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != metodo){
            try{
                metodoRepository.save(metodo);
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
