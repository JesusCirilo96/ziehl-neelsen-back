package com.ziehlneelsen.laboratorio.serviceImpl.descuento;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.PaqueteDescuentoDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.descuento.PaqueteDescuentoDAO;
import com.ziehlneelsen.laboratorio.entities.descuento.DiaDescuento;
import com.ziehlneelsen.laboratorio.entities.descuento.PaqueteDescuentoEntity;
import com.ziehlneelsen.laboratorio.repository.descuento.PaqueteDescuentoRepository;
import com.ziehlneelsen.laboratorio.service.descuento.PaqueteDescuentoService;
import com.ziehlneelsen.laboratorio.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaqueteDesceuntoServiceImpl implements PaqueteDescuentoService {

    @Autowired
    PaqueteDescuentoRepository paqueteDescuentoRepository;

    @Autowired
    PaqueteDescuentoDAO paqueteDescuentoDAO;

    @Override
    public List<PaqueteDescuentoEntity> findAll() {
        return paqueteDescuentoRepository.findAll();
    }

    @Override
    public Optional<PaqueteDescuentoEntity> findById(Integer id) {
        return paqueteDescuentoRepository.findById(id);
    }

    @Override
    public ResponseDTO save(PaqueteDescuentoEntity paquete) {
        ResponseDTO response = new ResponseDTO();
        if(null != paquete.getPaqueteId() && paqueteDescuentoRepository.findById(paquete.getPaqueteId()).isPresent()){
            paqueteDescuentoRepository.save(paquete);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != paquete){
            try{
                paqueteDescuentoRepository.save(paquete);
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
    public PaqueteDescuentoDTO findExamenByPaquete(Integer paqueteId) {
        return paqueteDescuentoDAO.findExamenByPaquete(paqueteId);
    }

    @Override
    public List<PaqueteDescuentoDTO> findAllPaqueteByDia() throws ParseException {
        List<PaqueteDescuentoEntity> paqueteDescuento = paqueteDescuentoDAO.findAllPaquete();

        List<PaqueteDescuentoDTO> descuentos = new ArrayList<>();

        Date fechaActual = Utileria.convertirFecha(Utileria.fechaHoraActual());

        for(PaqueteDescuentoEntity descuento : paqueteDescuento){
            Date fechaInicio = Utileria.convertirFecha(descuento.getFechaInicio());
            Date fechaFin = Utileria.convertirFecha(descuento.getFechaFin());

            if(fechaInicio.compareTo(fechaActual) * fechaActual.compareTo(fechaFin) > 0){
                System.out.println("La fecha actual esta entre el rango");
                System.out.println("Dias del paquete" + descuento.getDias() );
                String diasDescuento = descuento.getDias();
                String hoy = Utileria.hoy();
                if(diasDescuento.contains(hoy)){
                    System.out.println("El paquete aplica hoy");
                    PaqueteDescuentoDTO paquete = paqueteDescuentoDAO.findExamenByPaquete(descuento.getPaqueteId());
                    descuentos.add(paquete);
                }
            }
        }

        return descuentos;
    }
}
