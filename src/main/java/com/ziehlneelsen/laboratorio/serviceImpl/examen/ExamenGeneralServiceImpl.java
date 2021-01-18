package com.ziehlneelsen.laboratorio.serviceImpl.examen;

import com.ziehlneelsen.laboratorio.beans.ExamenDescuentoDTO;
import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenEstudioDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.examen.ExamenGeneralDAO;
import com.ziehlneelsen.laboratorio.dao.examen.ExamenGeneralSeccionDAO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenEstudioEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralSeccionEntity;
import com.ziehlneelsen.laboratorio.repository.estudio.EstudioRepository;
import com.ziehlneelsen.laboratorio.repository.examen.ExamenEstudioRepository;
import com.ziehlneelsen.laboratorio.repository.examen.ExamenGeneralRepository;
import com.ziehlneelsen.laboratorio.repository.examen.ExamenSeccionRepository;
import com.ziehlneelsen.laboratorio.service.examen.ExamenGeneralService;
import com.ziehlneelsen.laboratorio.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenGeneralServiceImpl implements ExamenGeneralService {

    @Autowired
    ExamenGeneralRepository examenGeneralRepository;

    @Autowired
    ExamenGeneralDAO examenGeneralDAO;

    @Autowired
    ExamenGeneralSeccionDAO examenGeneralSeccionDAO;

    @Autowired
    ExamenEstudioRepository examenEstudioRepository;

    @Autowired
    EstudioRepository estudioRepository;

    @Autowired
    ExamenSeccionRepository examenSeccionRepository;

    @Override
    public List<ExamenGeneralEntity> findAll() {
        return examenGeneralRepository.findAll();
    }

    @Override
    public Optional<ExamenGeneralEntity> findById(Integer id) {
        return examenGeneralRepository.findById(id);
    }

    @Override
    public ExamenGeneralEntity findByName(String nombre) {
        return examenGeneralDAO.findByName(nombre);
    }

    @Override
    public List<EstudioEntity> findEstudioExamen(Integer examenId) {
        return examenGeneralDAO.findEstudioByExamen(examenId);
    }

    @Override
    public ResponseDTO save(ExamenGeneralEntity examenGeneral) {
        ResponseDTO response = new ResponseDTO();
        if(null != examenGeneral.getExamenGeneralId() && examenGeneralRepository.findById(examenGeneral.getExamenGeneralId()).isPresent()){
            examenGeneral.setFechaActualizacion(Utileria.fechaHoraActual());
            examenGeneralRepository.save(examenGeneral);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != examenGeneral){
            try{
                examenGeneral.setFechaCreacion(Utileria.fechaHoraActual());
                examenGeneral.setFechaActualizacion(Utileria.fechaHoraActual());
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

    @Override
    public ExamenDescuentoDTO findDescuentoByExamen(Integer examenId) {
        return examenGeneralDAO.findDescuentoByExamen(examenId);
    }

    @Override
    public ExamenSeccionDTO findSeccionByExamen(Integer examenId) {
        ExamenSeccionDTO examenSeccion = examenGeneralSeccionDAO.getExamenSeccion(examenId);
        examenSeccion.setEstudio(findEstudioExamen(examenId));
        return examenSeccion;
    }

    @Override
    public ResponseDTO saveEstudioExamen(ExamenEstudioDTO estudioDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        EstudioEntity estudio = new EstudioEntity();

        estudio.setNombre(estudioDTO.getNombreEstudio());
        estudio.setEstado(true);
        estudio.setFechaCreacion(Utileria.fechaHoraActual());
        estudio.setFechaActualizacion(Utileria.fechaHoraActual());


        try{

            estudioRepository.save(estudio);
            Integer idEstudio = estudio.getEstudioId();

            ExamenEstudioEntity examenEstudioEntity = new ExamenEstudioEntity();
            examenEstudioEntity.setEstudioId(idEstudio);
            examenEstudioEntity.setExamenId(estudioDTO.getExamenId());

            examenEstudioRepository.save(examenEstudioEntity);


            responseDTO.setErrorCode(Messages.OK);
            responseDTO.setErrorInfo(Messages.REGISTER_OK);
        }catch (DataAccessException e){
            responseDTO.setErrorCode(Messages.ERROR);
            responseDTO.setErrorInfo(e.getMostSpecificCause().toString());
        }

        return responseDTO;
    }

    @Override
    public ResponseDTO saveSeccionExamen(ExamenGeneralSeccionEntity examenSeccion) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            examenSeccionRepository.save(examenSeccion);
            responseDTO.setErrorCode(Messages.OK);
            responseDTO.setErrorInfo(Messages.REGISTER_OK);
        }catch (DataAccessException e){
            responseDTO.setErrorCode(Messages.ERROR);
            responseDTO.setErrorInfo(e.getMostSpecificCause().toString());
        }
        return responseDTO;
    }
}
