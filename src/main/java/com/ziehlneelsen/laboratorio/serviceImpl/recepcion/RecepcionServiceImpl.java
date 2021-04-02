package com.ziehlneelsen.laboratorio.serviceImpl.recepcion;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.recepcion.RecepcionDTO;
import com.ziehlneelsen.laboratorio.beans.recepcion.RecepcionResultadoDTO;
import com.ziehlneelsen.laboratorio.constant.Constantes;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.persona.PacienteDAO;
import com.ziehlneelsen.laboratorio.dao.recepcion.RecepcionDAO;
import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionEntity;
import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.repository.persona.MedicoRepository;
import com.ziehlneelsen.laboratorio.repository.persona.PacienteRepository;
import com.ziehlneelsen.laboratorio.repository.recepcion.RecepcionExamenGeneralRepository;
import com.ziehlneelsen.laboratorio.repository.recepcion.RecepcionRepository;
import com.ziehlneelsen.laboratorio.service.recepcion.RecepcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecepcionServiceImpl implements RecepcionService {

    @Autowired
    RecepcionDAO recepcionDAO;

    @Autowired
    RecepcionRepository recepcionRepository;

    @Autowired
    RecepcionExamenGeneralRepository recepcionExamenGeneralRepository;

    @Autowired
    PacienteDAO pacienteDAO;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public Integer obtenerFicha() {
        return recepcionDAO.obtenerFicha();
    }

    @Override
    public ResponseDTO saveRecepcion(RecepcionEntity recepcion) {
        ResponseDTO response = new ResponseDTO();
            try {
                recepcionRepository.save(recepcion);
                response.setErrorCode(Messages.OK);
                response.setErrorInfo(Messages.REGISTER_OK);
            }catch (DataAccessException ex){
                response.setErrorCode(Messages.ERROR);
                response.setErrorInfo(ex.getMostSpecificCause().toString());
            }

        return response;
    }

    @Override
    public ResponseDTO saveRecepcionExamen(RecepcionExamenGeneralEntity recepcionExamen) {
        ResponseDTO response = new ResponseDTO();
        try {
            recepcionExamenGeneralRepository.save(recepcionExamen);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.REGISTER_OK);
        }catch (DataAccessException ex){
            response.setErrorCode(Messages.ERROR);
            response.setErrorInfo(ex.getMostSpecificCause().toString());
        }
        return response;
    }

    @Override
    public List<RecepcionDTO> obtenerRecepcionPorFecha(String fecha) {
        List<RecepcionEntity> recepcionList = recepcionDAO.obtenerRecepcion(Constantes.FECHA, fecha);
        List<RecepcionDTO> recepcionDTOList = new ArrayList<>();
        if(recepcionList != null){
            recepcionList.forEach((recepcionFetch) -> {

                RecepcionDTO recepcionDTO = new RecepcionDTO();

                recepcionDTO.setRecepcionId(recepcionFetch.getRecepcionId());
                recepcionDTO.setFicha(recepcionFetch.getFicha());
                recepcionDTO.setPaciente(pacienteDAO.obtenerNombrePaciente(recepcionFetch.getPacienteId()));
                recepcionDTO.setHoraIngreso(recepcionFetch.getHoraIngreso());

                recepcionDTOList.add(recepcionDTO);
            });
        }

        return recepcionDTOList;
    }

    @Override
    public RecepcionResultadoDTO obtenerResultados(String idRecepcion) {

        RecepcionResultadoDTO recepcionResultadoDTO = new RecepcionResultadoDTO();
        recepcionResultadoDTO.setRecepcionExamen(recepcionDAO.obtenerResultados(idRecepcion));

        RecepcionEntity recepcionEntity = recepcionDAO.obtenerRecepcion(Constantes.ID_RECEPCION,idRecepcion).get(0);

        recepcionResultadoDTO.setRecepcion(recepcionEntity);
        recepcionResultadoDTO.setPaciente(pacienteRepository.findById(recepcionEntity.getPacienteId()));
        recepcionResultadoDTO.setMedico(medicoRepository.findById(recepcionEntity.getMedicoId()));

        return recepcionResultadoDTO;
    }

    @Override
    public ResponseDTO guardarResultados(RecepcionExamenGeneralEntity resultado) {
        return recepcionDAO.saveResultado(resultado);
    }
}
