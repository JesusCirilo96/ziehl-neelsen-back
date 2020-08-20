package com.ziehlneelsen.laboratorio.controller.persona;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.persona.MedicoEntity;
import com.ziehlneelsen.laboratorio.service.persona.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Url.MEDICO)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<MedicoEntity> findAllMedico(){
        return medicoService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ID, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Optional<MedicoEntity> findMedico(@PathVariable Integer id){
        return medicoService.findById(id);
    }

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveMedico(@Valid @RequestBody MedicoEntity medico, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = medicoService.save(medico);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
