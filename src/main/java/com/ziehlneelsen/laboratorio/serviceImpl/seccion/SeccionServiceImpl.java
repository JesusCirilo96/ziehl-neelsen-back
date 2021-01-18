package com.ziehlneelsen.laboratorio.serviceImpl.seccion;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.SeccionEstudioDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.seccion.SeccionEstudioDAO;
import com.ziehlneelsen.laboratorio.entities.persona.UsuarioEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;
import com.ziehlneelsen.laboratorio.repository.persona.UsuarioRepository;
import com.ziehlneelsen.laboratorio.repository.seccion.SeccionRepository;
import com.ziehlneelsen.laboratorio.service.seccion.SeccionService;
import com.ziehlneelsen.laboratorio.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeccionServiceImpl implements SeccionService {

    @Autowired
    SeccionRepository seccionRepository;

    @Autowired
    SeccionEstudioDAO seccionEstudioDAO;

    @Override
    public List<SeccionEntity> findAll() {
        return seccionRepository.findAll();
    }

    @Override
    public Optional<SeccionEntity> findById(Integer id) {
        return seccionRepository.findById(id);
    }

    @Override
    public ResponseDTO save(SeccionEntity seccion) {
        ResponseDTO response = new ResponseDTO();
        if(null != seccion.getSeccionId() && seccionRepository.findById(seccion.getSeccionId()).isPresent()){
            seccion.setFechaActualizacion(Utileria.fechaHoraActual());
            seccionRepository.save(seccion);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != seccion){
            try{
                seccion.setFechaCreacion(Utileria.fechaHoraActual());
                seccion.setFechaActualizacion(Utileria.fechaHoraActual());
                seccionRepository.save(seccion);
                response.setErrorCode(Messages.OK);
                response.setErrorInfo(Messages.REGISTER_OK);
            }catch(DataAccessException ex) {
                response.setErrorCode(Messages.ERROR);
                response.setErrorInfo(ex.getMostSpecificCause().toString());
            }
        }
        return response;
    }

    @Override
    public SeccionEstudioDTO getEstudioSeccion(Integer seccionId) {
        return seccionEstudioDAO.getEstudioSeccion(seccionId);
    }
}
