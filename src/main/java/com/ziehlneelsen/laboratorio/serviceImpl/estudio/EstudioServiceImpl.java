package com.ziehlneelsen.laboratorio.serviceImpl.estudio;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.repository.estudio.EstudioRepository;
import com.ziehlneelsen.laboratorio.service.estudio.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudioServiceImpl implements EstudioService {
    @Autowired
    EstudioRepository estudioRepository;

    @Override
    public List<EstudioEntity> findAll() {
        return estudioRepository.findAll();
    }

    @Override
    public Optional<EstudioEntity> findById(Integer id) {
        return estudioRepository.findById(id);
    }

    @Override
    public ResponseDTO save(EstudioEntity estudio) {
        ResponseDTO response = new ResponseDTO();
        if(null != estudio.getEstudioId() && estudioRepository.findById(estudio.getEstudioId()).isPresent()){
            estudioRepository.save(estudio);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != estudio){
            try{
                estudioRepository.save(estudio);
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
