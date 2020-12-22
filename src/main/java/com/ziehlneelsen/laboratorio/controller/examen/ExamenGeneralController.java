package com.ziehlneelsen.laboratorio.controller.examen;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.service.examen.ExamenGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Url.EXAMEN_GENERAL)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class ExamenGeneralController {

    @Autowired
    ExamenGeneralService examenGeneralService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<ExamenGeneralEntity> findAllExamenGeneral(){
        return examenGeneralService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ID, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Optional<ExamenGeneralEntity> findExamenGeneral(@PathVariable Integer id){
        return examenGeneralService.findById(id);
    }

    @RequestMapping(value = Url.FIND_BY_NAME, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public ExamenGeneralEntity findExamenGeneralByName(@PathVariable String name){
        return examenGeneralService.findByName(name);
    }

    @RequestMapping(value = Url.EXAMEN_SECCION, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public ExamenSeccionDTO findSeccionByExamen(@PathVariable Integer id) {
        return examenGeneralService.findSeccionByExamen(id);
    }

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveExamenGeneral(@Valid @RequestBody ExamenGeneralEntity examenGeneral, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = examenGeneralService.save(examenGeneral);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
