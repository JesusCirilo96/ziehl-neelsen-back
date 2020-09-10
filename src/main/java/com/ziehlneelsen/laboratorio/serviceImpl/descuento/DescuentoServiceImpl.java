package com.ziehlneelsen.laboratorio.serviceImpl.descuento;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.dao.descuento.DiaDescuentoDAO;
import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.DiaDescuento;
import com.ziehlneelsen.laboratorio.repository.descuento.DescuentoRepository;
import com.ziehlneelsen.laboratorio.service.descuento.DescuentoService;
import com.ziehlneelsen.laboratorio.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DescuentoServiceImpl implements DescuentoService {

    @Autowired
    DescuentoRepository descuentoRepository;

    @Autowired
    DiaDescuentoDAO diaDescuentoDAO;

    @Override
    public List<DescuentoEntity> findAll() {
        return descuentoRepository.findAll();
    }

    @Override
    public Optional<DescuentoEntity> findById(Integer id) {
        return descuentoRepository.findById(id);
    }

    @Override
    public List<DiaDescuento> findByDescuento(Integer descuentoId) throws ParseException {
        List<DiaDescuento> diaDescuento = diaDescuentoDAO.getByDescuento(descuentoId);

        List<DiaDescuento> descuentos = new ArrayList<>();

        Date fechaActual = Utileria.convertirFecha(Utileria.fechaHoraActual());

        for(DiaDescuento dia : diaDescuento){
            Date fechaInicio = Utileria.convertirFecha(dia.getInicio());
            Date fechaFin = Utileria.convertirFecha(dia.getFin());

            if(fechaInicio.compareTo(fechaActual) * fechaActual.compareTo(fechaFin) > 0){
                System.out.println("La fecha actual esta entre el rango");
                System.out.println("El dia de hoy BD: " + dia.getDia().getNumeroDia());
                if(Utileria.hoy().equals(dia.getDia().getNumeroDia())){
                    System.out.println("El descuento aplica hoy");
                    descuentos.add(dia);
                }
            }
        }


        return descuentos;
    }

    @Override
    public Boolean aplicaDescuento(Integer descuentoId) throws ParseException {
        List<DiaDescuento> diaDescuento = diaDescuentoDAO.getByDescuento(descuentoId);

        Date fechaActual = Utileria.convertirFecha(Utileria.fechaHoraActual());

        for(DiaDescuento dia : diaDescuento){
            Date fechaInicio = Utileria.convertirFecha(dia.getInicio());
            Date fechaFin = Utileria.convertirFecha(dia.getFin());

            if(fechaInicio.compareTo(fechaActual) * fechaActual.compareTo(fechaFin) > 0){
                System.out.println("La fecha actual esta entre el rango");
                System.out.println("El dia de hoy BD: " + dia.getDia().getNumeroDia());
                if(Utileria.hoy().equals(dia.getDia().getNumeroDia())){
                    System.out.println("El descuento aplica hoy");
                    return true;
                }
            }
        }


        return false;
    }

    @Override
    public ResponseDTO save(DescuentoEntity descuento) {
        return null;
    }
}
