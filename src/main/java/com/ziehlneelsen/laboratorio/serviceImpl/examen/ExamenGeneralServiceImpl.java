package com.ziehlneelsen.laboratorio.serviceImpl.examen;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.repository.examen.ExamenGeneralRepository;
import com.ziehlneelsen.laboratorio.service.examen.ExamenGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenGeneralServiceImpl implements ExamenGeneralService {

    @Autowired
    ExamenGeneralRepository examenGeneralRepository;

    @Override
    public List<ExamenGeneralEntity> findAll() {
        return examenGeneralRepository.findAll();
    }

    @Override
    public Optional<ExamenGeneralEntity> findById(Integer id) {
        return examenGeneralRepository.findById(id);
    }

    @Override
    public ResponseDTO save(ExamenGeneralEntity examenGeneral) {
        ResponseDTO response = new ResponseDTO();
        if(null != examenGeneral.getExamenGeneralId() && examenGeneralRepository.findById(examenGeneral.getExamenGeneralId()).isPresent()){
            examenGeneralRepository.save(examenGeneral);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != examenGeneral){
            try{
                examenGeneralRepository.save(examenGeneral);
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