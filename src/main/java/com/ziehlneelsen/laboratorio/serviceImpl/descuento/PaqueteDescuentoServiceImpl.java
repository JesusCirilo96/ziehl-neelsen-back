package com.ziehlneelsen.laboratorio.serviceImpl.descuento;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.ExamenDescuentoAuxDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.ExamenPaqueteAuxDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.PaqueteDescuentoDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.PaqueteSaveDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.descuento.PaqueteDescuentoDAO;
import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.ExamenDescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.PaqueteDescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.PaqueteExamenEntity;
import com.ziehlneelsen.laboratorio.repository.descuento.PaqueteDescuentoRepository;
import com.ziehlneelsen.laboratorio.repository.descuento.PaqueteExamenRepository;
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
public class PaqueteDescuentoServiceImpl implements PaqueteDescuentoService {

    @Autowired
    PaqueteDescuentoRepository paqueteDescuentoRepository;

    @Autowired
    PaqueteExamenRepository paqueteExamenRepository;

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

    @Override
    public ResponseDTO savePaqueteExamen(PaqueteSaveDTO paquete) {
        ResponseDTO response = new ResponseDTO();

        PaqueteDescuentoEntity paqueteEntity = new PaqueteDescuentoEntity();
        paqueteEntity.setNombre(paquete.getNombre());
        paqueteEntity.setDescripcion(paquete.getDescripcion());
        paqueteEntity.setFechaInicio(paquete.getFechaInicio());
        paqueteEntity.setFechaFin(paquete.getFechaFin());
        paqueteEntity.setPorcentaje(paquete.getPorcentaje());
        paqueteEntity.setPorcentajeDescuentoTexto(paquete.getPorcentajeDescuentoTexto());
        paqueteEntity.setDescuento(paquete.getDescuento());
        paqueteEntity.setPrecio(paquete.getPrecio());

        String dias = "";
        for(Integer dia : paquete.getDias()){
            dias += dia.toString();
        }
        paqueteEntity.setDias(dias);
        paqueteEntity.setEstado(paquete.getEstado());
        Integer paqueteId;
        if(paquete.getOperacion().equals("editar")){
            paqueteId = paquete.getPaqueteId();
            paqueteDescuentoDAO.updatePaquete(paqueteEntity, paqueteId);
        }else{
            paqueteId = savePaquete(paqueteEntity);
        }


        for (ExamenPaqueteAuxDTO exPaquete : paquete.getExamen()) {
            PaqueteExamenEntity paqueteExamenEntity = new PaqueteExamenEntity();

            if(exPaquete.getAccion() != null){
                paqueteExamenEntity.setPaqueteId(paqueteId);
                paqueteExamenEntity.setExamenId(exPaquete.getExamenId());

                if(exPaquete.getAccion().equals("agregar")){
                    paqueteExamenRepository.save(paqueteExamenEntity);
                }else if(exPaquete.getAccion().equals("eliminar")){
                    paqueteDescuentoDAO.deleteExamenPaquete(paqueteExamenEntity.getExamenId(),paqueteExamenEntity.getPaqueteId());
                }
            }

        }

        response.setErrorCode(Messages.OK);
        response.setErrorInfo(Messages.REGISTER_OK);

        return response;
    }

    private Integer savePaquete(PaqueteDescuentoEntity descuento){
        save(descuento);
        return descuento.getPaqueteId();
    }

    @Override
    public ResponseDTO deletePaquete(Integer paqueteId) {

        ResponseDTO respuesta = paqueteDescuentoDAO.deleteExamenPaquete(0,paqueteId);
        if(respuesta.getErrorCode().equals(Messages.OK)){
            respuesta = paqueteDescuentoDAO.deletePaquete(paqueteId);
        }

        return respuesta;
    }
}
