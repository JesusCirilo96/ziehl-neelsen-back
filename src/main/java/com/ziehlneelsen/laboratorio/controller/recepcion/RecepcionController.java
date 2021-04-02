package com.ziehlneelsen.laboratorio.controller.recepcion;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.recepcion.RecepcionDTO;
import com.ziehlneelsen.laboratorio.beans.recepcion.RecepcionResultadoDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionEntity;
import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.service.recepcion.RecepcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveRecepcion(@Valid @RequestBody RecepcionEntity recepcionEntity, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = recepcionService.saveRecepcion(recepcionEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.SAVE_RECEPCION_EXAMEN, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveRecepcionExamen(@Valid @RequestBody RecepcionExamenGeneralEntity recepcionEntity, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = recepcionService.saveRecepcionExamen(recepcionEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.SAVE_RESULTADO, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveResultado(@Valid @RequestBody RecepcionExamenGeneralEntity resultado, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = recepcionService.guardarResultados(resultado);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.RECEPCION_FECHA, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<RecepcionDTO> recepcionPorFecha(@PathVariable String fecha){
        return recepcionService.obtenerRecepcionPorFecha(fecha);
    }

    @RequestMapping(value = Url.RECEPCION_RESULTADO, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public RecepcionResultadoDTO obtenerResultado(@PathVariable String idRecepcion){
        return recepcionService.obtenerResultados(idRecepcion);
    }

}
