package com.ziehlneelsen.laboratorio.serviceImpl.examen;

import com.ziehlneelsen.laboratorio.beans.ExamenDescuentoDTO;
import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenEstudioDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenMetodoAux;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionSaveDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.examen.ExamenGeneralDAO;
import com.ziehlneelsen.laboratorio.dao.examen.ExamenGeneralSeccionDAO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenEstudioEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralSeccionEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;
import com.ziehlneelsen.laboratorio.repository.estudio.EstudioRepository;
import com.ziehlneelsen.laboratorio.repository.examen.ExamenEstudioRepository;
import com.ziehlneelsen.laboratorio.repository.examen.ExamenGeneralRepository;
import com.ziehlneelsen.laboratorio.repository.examen.ExamenSeccionRepository;
import com.ziehlneelsen.laboratorio.repository.seccion.SeccionRepository;
import com.ziehlneelsen.laboratorio.service.examen.ExamenGeneralService;
import com.ziehlneelsen.laboratorio.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    SeccionRepository seccionRepository;

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
    public List<EstudioDTO> findEstudioExamen(Integer examenId) {
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
        ExamenDescuentoDTO response = new ExamenDescuentoDTO();
        response = examenGeneralDAO.findDescuentoByExamen(examenId);
        response.setPaquete(examenGeneralDAO.findPaqueteByExamen(examenId));
        return response;
    }

    @Override
    public ExamenSeccionDTO findSeccionByExamen(Integer examenId) {
        ExamenSeccionDTO examenSeccion = examenGeneralSeccionDAO.getExamenSeccion(examenId);
        examenSeccion.setEstudio(examenGeneralDAO.findEstudioByExamenReferencia(examenId));

        return examenSeccion;
    }

    @Override
    public ResponseDTO saveEstudioExamen(ExamenEstudioDTO estudioDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        EstudioEntity estudio = new EstudioEntity();
        Integer idEstudio;
        if(estudioDTO.isPorId()){
            idEstudio = estudioDTO.getEstudioId();
        }else{
            estudio.setNombre(estudioDTO.getNombreEstudio());
            estudio.setEstado(true);
            estudio.setFechaCreacion(Utileria.fechaHoraActual());
            estudio.setFechaActualizacion(Utileria.fechaHoraActual());
            estudio.setComodin(false);

            estudioRepository.save(estudio);

            idEstudio = estudio.getEstudioId();
        }
        try{
            ExamenEstudioEntity examenEstudioEntity = new ExamenEstudioEntity();
            examenEstudioEntity.setEstudioId(idEstudio);
            examenEstudioEntity.setExamenId(estudioDTO.getExamenId());
            examenEstudioEntity.setOrden(estudioDTO.getOrden());

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
    public ResponseDTO saveSeccionExamen(ExamenSeccionSaveDTO examenSeccion) {
        ResponseDTO responseDTO = new ResponseDTO();

        Integer idSeccion;
        if(examenSeccion.isPorId()){
            idSeccion = examenSeccion.getSeccionId();
        }else{
            SeccionEntity seccion = new SeccionEntity();
            seccion.setNombre(examenSeccion.getNombreSeccion());
            seccion.setTitulo(examenSeccion.getTitulo());
            seccion.setTextoCent(examenSeccion.getTextoCent());
            seccion.setTextoDer(examenSeccion.getTextoDer());
            seccion.setEstado(true);
            seccion.setFechaCreacion(Utileria.fechaHoraActual());
            seccion.setFechaActualizacion(Utileria.fechaHoraActual());

            seccionRepository.save(seccion);

            idSeccion = seccion.getSeccionId();
        }
        try{
            ExamenGeneralSeccionEntity seccionExamen = new ExamenGeneralSeccionEntity();

            seccionExamen.setSeccionId(idSeccion);
            seccionExamen.setExamenId(examenSeccion.getExamenId());
            seccionExamen.setOrden(examenSeccion.getOrden());

            examenSeccionRepository.save(seccionExamen);

            responseDTO.setErrorCode(Messages.OK);
            responseDTO.setErrorInfo(Messages.REGISTER_OK);
        }catch (DataAccessException e){
            responseDTO.setErrorCode(Messages.ERROR);
            responseDTO.setErrorInfo(e.getMostSpecificCause().toString());
        }

        return responseDTO;
    }

    @Override
    @Transactional
    @Modifying
    public ResponseDTO updateSeccionExamen(ExamenSeccionSaveDTO examenSeccion) {
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            examenGeneralSeccionDAO.updateOrdenSeccionExamen(examenSeccion.getSeccionId(),examenSeccion.getExamenId(), examenSeccion.getOrden());
            examenGeneralSeccionDAO.updateSeccion(examenSeccion);

            responseDTO.setErrorCode(Messages.OK);
            responseDTO.setErrorInfo(Messages.UPDATE_OK);
        }catch (DataAccessException ex){
            responseDTO.setErrorCode(Messages.OK);
            responseDTO.setErrorInfo(Messages.UPDATE_ERROR);
        }

        return responseDTO;
    }

    @Override
    @Transactional
    @Modifying
    public ResponseDTO deleteExamenSeccion(Integer examenId, Integer seccionId) {
        return examenGeneralSeccionDAO.deleteExamenSeccion(examenId,seccionId);
    }

    @Override
    @Transactional
    @Modifying
    public ResponseDTO deleteExamenEstudio(Integer examenId, Integer estudioId) {
        return examenGeneralDAO.deleteExamenEstudio(examenId, estudioId);
    }

    @Override
    @Transactional
    @Modifying
    public ResponseDTO updateMetodo(ExamenMetodoAux examen) {
        return examenGeneralDAO.updateMetodo(examen);
    }
}
