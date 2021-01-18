package com.ziehlneelsen.laboratorio.serviceImpl.metodo;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.entities.metodo.SeccionMetodoEntity;
import com.ziehlneelsen.laboratorio.repository.metodo.MetodoSeccionRepository;
import com.ziehlneelsen.laboratorio.service.metodo.MetodoSeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class MetodoSeccionServiceImpl implements MetodoSeccionService {

    @Autowired
    MetodoSeccionRepository metodoSeccionRepository;

    @Override
    public ResponseDTO save(SeccionMetodoEntity metodoSeccion) {
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            metodoSeccionRepository.save(metodoSeccion);
            responseDTO.setErrorCode(Messages.OK);
            responseDTO.setErrorInfo(Messages.REGISTER_OK);
        }catch (DataAccessException e){
            responseDTO.setErrorCode(Messages.ERROR);
            responseDTO.setErrorInfo(e.getMostSpecificCause().toString());
        }

        return responseDTO;
    }
}
