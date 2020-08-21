package com.ziehlneelsen.laboratorio.serviceImpl.examen;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenEntity;
import com.ziehlneelsen.laboratorio.repository.examen.ExamenRepository;
import com.ziehlneelsen.laboratorio.service.examen.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenServiceImpl implements ExamenService {

    @Autowired
    ExamenRepository examenRepository;

    @Override
    public List<ExamenEntity> findAll() {
        return examenRepository.findAll();
    }

    @Override
    public Optional<ExamenEntity> findById(Integer id) {
        return examenRepository.findById(id);
    }

    @Override
    public ResponseDTO save(ExamenEntity examen) {
        ResponseDTO response = new ResponseDTO();
        if(null != examen.getExamenId() && examenRepository.findById(examen.getExamenId()).isPresent()){
            examenRepository.save(examen);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != examen){
            try{
                examenRepository.save(examen);
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
