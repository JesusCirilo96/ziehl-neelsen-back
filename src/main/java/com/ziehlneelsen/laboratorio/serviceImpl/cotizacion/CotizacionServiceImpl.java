package com.ziehlneelsen.laboratorio.serviceImpl.cotizacion;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.cotizacion.CotizacionExamenesDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.cotizacion.CotizacionDAO;
import com.ziehlneelsen.laboratorio.entities.cotizacion.CotizacionEntity;
import com.ziehlneelsen.laboratorio.repository.cotizacion.CotizacionRepository;
import com.ziehlneelsen.laboratorio.service.cotizacion.CotizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CotizacionServiceImpl implements CotizacionService {

    @Autowired
    CotizacionRepository cotizacionRepository;

    @Autowired
    CotizacionDAO cotizacionDAO;

    @Override
    public List<CotizacionEntity> findAll() {
        return cotizacionRepository.findAll();
    }

    @Override
    public Optional<CotizacionEntity> findById(String id) {
        return cotizacionRepository.findById(id);
    }

    @Override
    public ResponseDTO save(CotizacionEntity cotizacion) {
        ResponseDTO response = new ResponseDTO();
        if(null != cotizacion.getCotizacionId() && cotizacionRepository.findById(cotizacion.getCotizacionId()).isPresent()){
            cotizacionRepository.save(cotizacion);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != cotizacion){
            try{
                cotizacionRepository.save(cotizacion);
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
    public CotizacionExamenesDTO getExamenCotizacion(String cotizacionId) {
        return cotizacionDAO.getExamenCotizacion(cotizacionId);
    }

    @Override
    public List<CotizacionEntity> findByFecha(String fecha) {
        return cotizacionDAO.getCotizacionByFecha(fecha) ;
    }
}
