package com.ziehlneelsen.laboratorio.controller.examen;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenEntity;
import com.ziehlneelsen.laboratorio.service.examen.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Url.EXAMEN)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class ExamenController {
    @Autowired
    ExamenService examenService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<ExamenEntity> findAllExamen(){
        return examenService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ID, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Optional<ExamenEntity> findExamen(@PathVariable Integer id){
        return examenService.findById(id);
    }

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveExamen(@Valid @RequestBody ExamenEntity examen, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = examenService.save(examen);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
