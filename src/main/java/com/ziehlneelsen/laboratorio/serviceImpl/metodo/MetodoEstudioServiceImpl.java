package com.ziehlneelsen.laboratorio.serviceImpl.metodo;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.entities.metodo.EstudioMetodoEntity;
import com.ziehlneelsen.laboratorio.repository.metodo.MetodoEstudioRepository;
import com.ziehlneelsen.laboratorio.service.metodo.MetodoEstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class MetodoEstudioServiceImpl implements MetodoEstudioService {

    @Autowired
    MetodoEstudioRepository metodoEstudioRepository;

    @Override
    public ResponseDTO save(EstudioMetodoEntity estudioMetodoEntity) {
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            metodoEstudioRepository.save(estudioMetodoEntity);
            responseDTO.setErrorCode(Messages.OK);
            responseDTO.setErrorInfo(Messages.REGISTER_OK);
        }catch (DataAccessException e){
            responseDTO.setErrorCode(Messages.ERROR);
            responseDTO.setErrorInfo(e.getMostSpecificCause().toString());
        }

        return responseDTO;
    }
}
