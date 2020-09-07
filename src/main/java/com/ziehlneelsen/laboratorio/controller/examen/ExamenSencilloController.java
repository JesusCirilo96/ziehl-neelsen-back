package com.ziehlneelsen.laboratorio.controller.examen;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenSencilloEntity;
import com.ziehlneelsen.laboratorio.service.examen.ExamenSencilloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Url.EXAMEN_SENCILLO)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class ExamenSencilloController {
    @Autowired
    ExamenSencilloService examenService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<ExamenSencilloEntity> findAllExamen(){
        return examenService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ID, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Optional<ExamenSencilloEntity> findExamen(@PathVariable Integer id){
        return examenService.findById(id);
    }

    @RequestMapping(value = Url.FIND_BY_NAME, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public ExamenSencilloEntity findExamenByName(@PathVariable String name){
        return examenService.findByName(name);
    }

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveExamen(@Valid @RequestBody ExamenSencilloEntity examen, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = examenService.save(examen);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
