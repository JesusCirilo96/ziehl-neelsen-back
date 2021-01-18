package com.ziehlneelsen.laboratorio.service.metodo;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.metodo.SeccionMetodoEntity;

public interface MetodoSeccionService {

    ResponseDTO save(SeccionMetodoEntity metodoSeccion);

}
