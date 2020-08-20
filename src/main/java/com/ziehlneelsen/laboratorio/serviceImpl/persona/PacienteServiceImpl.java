package com.ziehlneelsen.laboratorio.serviceImpl.persona;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.entities.persona.PacienteEntity;
import com.ziehlneelsen.laboratorio.repository.persona.PacienteRepository;
import com.ziehlneelsen.laboratorio.service.persona.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public List<PacienteEntity> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<PacienteEntity> findById(Integer id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public ResponseDTO save(PacienteEntity paciente) {
        ResponseDTO response = new ResponseDTO();
        if(null != paciente.getPacienteId() && pacienteRepository.findById(paciente.getPacienteId()).isPresent()){
            pacienteRepository.save(paciente);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != paciente){
            try{
                pacienteRepository.save(paciente);
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
