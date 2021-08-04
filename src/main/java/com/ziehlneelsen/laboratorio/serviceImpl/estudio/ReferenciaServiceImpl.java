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
import java.util.UUID;

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

        return referencia;
    }

    @Override
    public ResponseDTO save(ReferenciaEntity referencia) {
        ResponseDTO response = new ResponseDTO();

        try{
            referencia.setFechaCreacion(Utileria.fechaHoraActual());
            referencia.setFechaActualizacion(Utileria.fechaHoraActual());
            if(referencia.getMasculino() == null){
                referencia.setMasculino("");
            }
            if (referencia.getFemenino() == null){
                referencia.setFemenino("");
            }
            if (referencia.getGeneral() == null){
                referencia.setGeneral("");
            }
            if (referencia.getNota() == null) {
                referencia.setNota("");
            }
            referenciaRepository.save(referencia);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.REGISTER_OK);
        }catch(DataAccessException ex) {
            response.setErrorCode(Messages.ERROR);
            response.setErrorInfo(ex.getMostSpecificCause().toString());
        }
        return response;
    }

    @Override
    public ResponseDTO deleteReferencia(UUID referenciaId) {
        return referenciaDAO.eliminaReferencia(referenciaId);
    }

    @Override
    public ResponseDTO updateReferencia(ReferenciaEntity referencia) {
        return referenciaDAO.actualizaReferencia(referencia);
    }
}
