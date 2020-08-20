package com.ziehlneelsen.laboratorio.controller.persona;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.persona.PacienteEntity;
import com.ziehlneelsen.laboratorio.service.persona.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Url.PACIENTE)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<PacienteEntity> findAllPaciente(){
        return pacienteService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ID, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Optional<PacienteEntity> findPaciente(@PathVariable Integer id){
        return pacienteService.findById(id);
    }

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity savePaciente(@Valid @RequestBody PacienteEntity paciente, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = pacienteService.save(paciente);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
