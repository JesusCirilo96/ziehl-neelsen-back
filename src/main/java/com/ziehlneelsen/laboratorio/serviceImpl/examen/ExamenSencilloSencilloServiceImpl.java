package com.ziehlneelsen.laboratorio.serviceImpl.examen;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenSencilloEntity;
import com.ziehlneelsen.laboratorio.repository.examen.ExamenSencilloRepository;
import com.ziehlneelsen.laboratorio.service.examen.ExamenSencilloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenSencilloSencilloServiceImpl implements ExamenSencilloService {

    @Autowired
    ExamenSencilloRepository examenSencilloRepository;

    @Override
    public List<ExamenSencilloEntity> findAll() {
        return examenSencilloRepository.findAll();
    }

    @Override
    public Optional<ExamenSencilloEntity> findById(Integer id) {
        return examenSencilloRepository.findById(id);
    }

    @Override
    public ResponseDTO save(ExamenSencilloEntity examen) {
        ResponseDTO response = new ResponseDTO();
        if(null != examen.getExamenSencilloId() && examenSencilloRepository.findById(examen.getExamenSencilloId()).isPresent()){
            examenSencilloRepository.save(examen);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != examen){
            try{
                examenSencilloRepository.save(examen);
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
