package com.ziehlneelsen.laboratorio.controller.seccion;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.AuxSeccionEstudioDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.SeccionEstudioDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEstudioEntity;
import com.ziehlneelsen.laboratorio.service.seccion.SeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Url.SECCION)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT})
public class SeccionController {
    @Autowired
    SeccionService seccionService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<SeccionEntity> findAllSeccion(){
        return seccionService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ID, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Optional<SeccionEntity> findSeccion(@PathVariable Integer id){
        return seccionService.findById(id);
    }

    @RequestMapping(value = Url.SECCION_ESTUDIO, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public SeccionEstudioDTO findSeccionEstudio(@PathVariable Integer id){
        return seccionService.getEstudioSeccion(id);
    }

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveSeccion(@Valid @RequestBody SeccionEntity seccionEntity, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = seccionService.save(seccionEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.SAVE_SECCION_ESTUDIO, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveSeccionEstudio(@Valid @RequestBody AuxSeccionEstudioDTO seccionEstudio, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = seccionService.saveSeccionEstudio(seccionEstudio);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.DELETE_SECCION_ESTUDIO, method = RequestMethod.DELETE, produces = Url.APLICATION_JSON)
    public ResponseEntity deleteSeccionEstudio(@PathVariable Integer seccionId, @PathVariable Integer estudioId){
        ResponseDTO responseDTO = seccionService.deleteSeccionEstudio(seccionId, estudioId);

        return  new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping(value = Url.UPDATE_SECCION_ESTUDIO, method = RequestMethod.PUT, produces = Url.APLICATION_JSON)
    public ResponseEntity updateSeccionEstudio(@Valid @RequestBody AuxSeccionEstudioDTO seccionEstudio, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = seccionService.updateSeccionEstudio(seccionEstudio);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
