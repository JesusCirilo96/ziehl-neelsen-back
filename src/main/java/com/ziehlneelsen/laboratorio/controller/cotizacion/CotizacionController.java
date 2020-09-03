package com.ziehlneelsen.laboratorio.controller.cotizacion;


import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.cotizacion.CotizacionExamenesDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.cotizacion.CotizacionEntity;
import com.ziehlneelsen.laboratorio.service.cotizacion.CotizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Url.COTIZACION)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class CotizacionController {

    @Autowired
    CotizacionService cotizacionService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<CotizacionEntity> findAllCotizacion(){
        return cotizacionService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ID, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Optional<CotizacionEntity> findCotizacion(@PathVariable String id){
        return cotizacionService.findById(id);
    }

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveCotizacion(@Valid @RequestBody CotizacionEntity cotizacion, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = cotizacionService.save(cotizacion);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.COTIZACION_EXAMEN_SENCILLO, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public CotizacionExamenesDTO findExamenSencillo(@PathVariable String id){
        return cotizacionService.getExamenSencillo(id);
    }


}
