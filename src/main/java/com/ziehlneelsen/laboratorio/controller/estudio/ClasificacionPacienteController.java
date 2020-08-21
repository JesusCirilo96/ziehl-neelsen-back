package com.ziehlneelsen.laboratorio.controller.estudio;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.estudio.ClasificacionPacienteEntity;
import com.ziehlneelsen.laboratorio.service.estudio.ClasificacionPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Url.CLASIFICACION_PACIENTE)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class ClasificacionPacienteController {

    @Autowired
    ClasificacionPacienteService clasificacionPacienteService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<ClasificacionPacienteEntity> findAllClasificacionPaciente(){
        return clasificacionPacienteService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ID, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Optional<ClasificacionPacienteEntity> findClasificacionPaciente(@PathVariable Integer id){
        return clasificacionPacienteService.findById(id);
    }

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveClasificacionPaciente(@Valid @RequestBody ClasificacionPacienteEntity clasificacionPaciente, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = clasificacionPacienteService.save(clasificacionPaciente);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
