package com.ziehlneelsen.laboratorio.serviceImpl.estudio;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ReferenciaDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.estudio.ReferenciaDAO;
import com.ziehlneelsen.laboratorio.entities.estudio.ReferenciaEntity;
import com.ziehlneelsen.laboratorio.repository.estudio.ReferenciaRepository;
import com.ziehlneelsen.laboratorio.service.estudio.ReferenciaService;
import com.ziehlneelsen.laboratorio.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenciaServiceImpl implements ReferenciaService {
    @Autowired
    ReferenciaRepository referenciaRepository;

    @Autowired
    ReferenciaDAO referenciaDAO;

    @Override
    public List<ReferenciaEntity> findAll() {
        return referenciaRepository.findAll();
    }

    @Override
    public List<ReferenciaDTO> findByEstudio(Integer idEstudio) {

        List<ReferenciaDTO> referencia = referenciaDAO.getByEstudio(idEstudio);

        System.out.println(referencia.toString());

        return referencia;
    }

    @Override
    public ResponseDTO save(ReferenciaEntity referencia) {
        ResponseDTO response = new ResponseDTO();

        try{
            referencia.setFechaCreacion(Utileria.fechaHoraActual());
            referencia.setFechaActualizacion(Utileria.fechaHoraActual());
            referenciaRepository.save(referencia);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.REGISTER_OK);
        }catch(DataAccessException ex) {
            response.setErrorCode(Messages.ERROR);
            response.setErrorInfo(ex.getMostSpecificCause().toString());
        }
        return response;
    }
}
