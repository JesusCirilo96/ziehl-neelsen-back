package com.ziehlneelsen.laboratorio.serviceImpl.recepcion;

import com.ziehlneelsen.laboratorio.dao.recepcion.RecepcionDAO;
import com.ziehlneelsen.laboratorio.service.recepcion.RecepcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecepcionServiceImpl implements RecepcionService {

    @Autowired
    RecepcionDAO recepcionDAO;

    @Override
    public Integer obtenerFicha() {
        return recepcionDAO.obtenerFicha();
    }
}
