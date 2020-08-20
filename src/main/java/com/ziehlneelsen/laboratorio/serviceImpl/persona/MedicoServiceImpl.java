package com.ziehlneelsen.laboratorio.serviceImpl.persona;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.entities.persona.MedicoEntity;
import com.ziehlneelsen.laboratorio.repository.persona.MedicoRepository;
import com.ziehlneelsen.laboratorio.service.persona.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService {
    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public List<MedicoEntity> findAll() {
        return medicoRepository.findAll();
    }

    @Override
    public Optional<MedicoEntity> findById(Integer id) {
        return medicoRepository.findById(id);
    }

    @Override
    public ResponseDTO save(MedicoEntity medico) {
        ResponseDTO response = new ResponseDTO();
        if(null != medico.getMedicoId() && medicoRepository.findById(medico.getMedicoId()).isPresent()){
            medicoRepository.save(medico);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != medico){
            try{
                medicoRepository.save(medico);
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
