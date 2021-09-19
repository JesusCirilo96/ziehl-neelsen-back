package com.ziehlneelsen.laboratorio.serviceImpl.descuento;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.DescuentoExamenDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.DescuentoSaveDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.ExamenDescuentoAuxDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.descuento.DescuentoExamenDAO;
import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.ExamenDescuentoEntity;
import com.ziehlneelsen.laboratorio.repository.descuento.DescuentoRepository;
import com.ziehlneelsen.laboratorio.repository.descuento.ExamenDescuentoRepository;
import com.ziehlneelsen.laboratorio.service.descuento.DescuentoService;
import com.ziehlneelsen.laboratorio.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DescuentoServiceImpl implements DescuentoService {

    @Autowired
    DescuentoRepository descuentoRepository;

    @Autowired
    ExamenDescuentoRepository examenDescuentoRepository;

    @Autowired
    DescuentoExamenDAO descuentoExamenDAO;

    @Override
    public List<DescuentoEntity> findAll() {
        return descuentoRepository.findAll();
    }

    @Override
    public Optional<DescuentoEntity> findById(Integer id) {
        return descuentoRepository.findById(id);
    }

    @Override
    public Boolean aplicaDescuento(String fechaI, String fechaF, String dias) throws ParseException {
        Date fechaActual = Utileria.convertirFecha(Utileria.fechaHoraActual());

        Date fechaInicio = Utileria.convertirFecha(fechaI);
        Date fechaFin = Utileria.convertirFecha(fechaF);
        if(fechaInicio.compareTo(fechaActual) * fechaActual.compareTo(fechaFin) > 0) {
            System.out.println("La fecha actual esta entre el rango");
            System.out.println("El dias que aplica el descuento: " + dias);

            String hoy = Utileria.hoy();
            if(dias.contains(hoy)){
                System.out.println("El descuento");
                return true;
            }
        }
        return false;
    }

    @Override
    public ResponseDTO save(DescuentoEntity descuento) {
        ResponseDTO response = new ResponseDTO();
        if(null != descuento.getDescuentoId() && descuentoRepository.findById(descuento.getDescuentoId()).isPresent()){
            descuento.setFechaActualizacion(Utileria.fechaHoraActual());
            descuentoRepository.save(descuento);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != descuento){
            try{
                descuento.setFechaCreacion(Utileria.fechaHoraActual());
                descuento.setFechaActualizacion(Utileria.fechaHoraActual());
                descuentoRepository.save(descuento);
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
    public ResponseDTO saveExamenDescuento(DescuentoSaveDTO descuento){
        ResponseDTO response = new ResponseDTO();

        DescuentoEntity descuentoEntity = new DescuentoEntity();
        descuentoEntity.setNombre(descuento.getNombre());
        descuentoEntity.setDescripcion(descuento.getDescripcion());
        descuentoEntity.setFechaInicio(descuento.getFechaInicio());
        descuentoEntity.setFechaFin(descuento.getFechaFin());
        String dias = "";
        for(Integer dia : descuento.getDias()){
            dias += dia.toString();
        }
        descuentoEntity.setDias(dias);
        descuentoEntity.setEstado(descuento.getEstado());
        Integer descuentoId;
        if(descuento.getOperacion().equals("editar")){
            descuentoId = descuento.getDescuentoId();
            descuentoExamenDAO.updateDescuento(descuentoEntity, descuentoId);
        }else{
            descuentoId = saveDescuento(descuentoEntity);
        }


        for (ExamenDescuentoAuxDTO exDescuento : descuento.getExamen()) {
            ExamenDescuentoEntity examenDescuentoEntity = new ExamenDescuentoEntity();

            if(exDescuento.getAccion() != null){
                examenDescuentoEntity.setDescuentoId(descuentoId);
                examenDescuentoEntity.setExamenId(exDescuento.getExamenId());
                examenDescuentoEntity.setPorcentajeDescuento(exDescuento.getPorcentajeDescuento());
                examenDescuentoEntity.setPorcentajeText(exDescuento.getPorcentajeDescuentoText());
                examenDescuentoEntity.setDescuento(exDescuento.getDescuento());

                if(exDescuento.getAccion().equals("editar")){
                    examenDescuentoEntity.setExamenDescuentoId(exDescuento.getExamenDescuentoId());
                    descuentoExamenDAO.updateExamenDescuento(examenDescuentoEntity);
                }else if(exDescuento.getAccion().equals("agregar")){
                    examenDescuentoRepository.save(examenDescuentoEntity);
                }else if(exDescuento.getAccion().equals("eliminar")){
                    descuentoExamenDAO.deleteExamenDescuento(examenDescuentoEntity.getExamenId(),examenDescuentoEntity.getDescuentoId());
                }
            }

        }

        response.setErrorCode(Messages.OK);
        response.setErrorInfo(Messages.REGISTER_OK);

        return response;
    }

    private Integer saveDescuento(DescuentoEntity descuento){
        save(descuento);
        return descuento.getDescuentoId();
    }

    @Override
    public DescuentoExamenDTO getDescuentoExamen(Integer descuentoId){
        return descuentoExamenDAO.getDescuentoExamen(descuentoId);
    }

    @Override
    public ResponseDTO deleteDescuento(Integer descuentoId) {

        ResponseDTO respuesta = descuentoExamenDAO.deleteExamenDescuento(0,descuentoId);
        if(respuesta.getErrorCode().equals(Messages.OK)){
            respuesta = descuentoExamenDAO.deleteDescuento(descuentoId);
        }

        return respuesta;
    }
}
