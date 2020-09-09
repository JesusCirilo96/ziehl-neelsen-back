package com.ziehlneelsen.laboratorio.controller.descuento;

import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.DiaDescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.service.descuento.DescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Url.DESCUENTO)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class DescuentoController {

    @Autowired
    DescuentoService descuentoService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<DescuentoEntity> findAllEstudio(){
        return descuentoService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ID, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Optional<DescuentoEntity> findEstudio(@PathVariable Integer id){
        return descuentoService.findById(id);
    }


    @RequestMapping(value = Url.DIA_DESCUENTO, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<DiaDescuentoEntity> findDiaDescuento(@PathVariable Integer id) throws ParseException {
        return descuentoService.findByDescuento(id);
    }

}
