package com.ziehlneelsen.laboratorio.serviceImpl.estudio;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.entities.estudio.ClasificacionPacienteEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.repository.estudio.ClasificacionPacienteRepository;
import com.ziehlneelsen.laboratorio.repository.examen.ExamenGeneralRepository;
import com.ziehlneelsen.laboratorio.service.estudio.ClasificacionPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasificacionPacienteServiceImpl implements ClasificacionPacienteService {
    @Autowired
    ClasificacionPacienteRepository clasificacionPacienteRepository;

    @Override
    public List<ClasificacionPacienteEntity> findAll() {
        return clasificacionPacienteRepository.findAll();
    }

    @Override
    public Optional<ClasificacionPacienteEntity> findById(Integer id) {
        return clasificacionPacienteRepository.findById(id);
    }

    @Override
    public ResponseDTO save(ClasificacionPacienteEntity clasificacionPaciente) {
        ResponseDTO response = new ResponseDTO();
        if(null != clasificacionPaciente.getClasificacionPacienteId() && clasificacionPacienteRepository.findById(clasificacionPaciente.getClasificacionPacienteId()).isPresent()){
            clasificacionPacienteRepository.save(clasificacionPaciente);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != clasificacionPaciente){
            try{
                clasificacionPacienteRepository.save(clasificacionPaciente);
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
