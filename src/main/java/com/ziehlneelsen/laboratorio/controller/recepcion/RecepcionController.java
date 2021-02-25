package com.ziehlneelsen.laboratorio.controller.recepcion;

import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.service.recepcion.RecepcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Url.RECEPCION)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class RecepcionController {

    @Autowired
    RecepcionService recepcionService;

    @RequestMapping(value = Url.RECEPCION_FICHA, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Integer obtenerFicha(){
        return recepcionService.obtenerFicha();
    }

}
