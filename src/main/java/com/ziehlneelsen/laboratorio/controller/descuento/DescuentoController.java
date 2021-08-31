package com.ziehlneelsen.laboratorio.controller.descuento;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.DescuentoSaveDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.service.descuento.DescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveDescuento(@Valid @RequestBody DescuentoEntity descuento, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = descuentoService.save(descuento);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.SAVE_DESCUENTO_EXAMEN, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveDescuentoExamen(@Valid @RequestBody DescuentoSaveDTO descuento) {

        ResponseDTO response;
        response = descuentoService.saveExamenDescuento(descuento);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
