package com.ziehlneelsen.laboratorio.controller.metodo;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.metodo.MetodoDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.metodo.EstudioMetodoEntity;
import com.ziehlneelsen.laboratorio.entities.metodo.MetodoEntity;
import com.ziehlneelsen.laboratorio.entities.metodo.SeccionMetodo;
import com.ziehlneelsen.laboratorio.entities.metodo.SeccionMetodoEntity;
import com.ziehlneelsen.laboratorio.service.metodo.MetodoEstudioService;
import com.ziehlneelsen.laboratorio.service.metodo.MetodoSeccionService;
import com.ziehlneelsen.laboratorio.service.metodo.MetodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Url.METODO)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE})
public class MetodoController {

    @Autowired
    MetodoService metodoService;

    @Autowired
    MetodoSeccionService metodoSeccionService;

    @Autowired
    MetodoEstudioService metodoEstudioService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<MetodoEntity> findAllMetodo(){
        return metodoService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ID, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Optional<MetodoEntity> findMetodo(@PathVariable Integer id){
        return metodoService.findById(id);
    }

    @RequestMapping(value = Url.METODO_BY_SECCION, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<MetodoDTO> findMetodoBySeccion(@PathVariable Integer id){
        return metodoService.getMetodoBySeccion(id);
    }

    @RequestMapping(value = Url.METODO_BY_ESTUDIO, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<MetodoDTO> findMetodoByEstudio(@PathVariable Integer estudioId){
        return metodoService.getMetodoByEstudio(estudioId);
    }

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveMetodo(@Valid @RequestBody MetodoEntity metodo, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = metodoService.save(metodo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.SAVE_METODO_SECCION, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public  ResponseEntity saveMetodoSeccion(@Valid @RequestBody SeccionMetodoEntity seccionMetodo, BindingResult bindingResult){
        ResponseDTO responseDTO;
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }else{
            responseDTO = metodoSeccionService.save(seccionMetodo);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
    }

    @RequestMapping(value = Url.SAVE_METODO_ESTUDIO, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public  ResponseEntity saveMetodoEstudio(@Valid @RequestBody EstudioMetodoEntity estudioMetodo, BindingResult bindingResult){
        ResponseDTO responseDTO;
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }else{
            responseDTO = metodoEstudioService.save(estudioMetodo);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
    }

    @RequestMapping(value = Url.DELETE_METODO_SECCION, method = RequestMethod.DELETE, produces = Url.APLICATION_JSON)
    public ResponseEntity deleteMetodoSeccion(@PathVariable Integer seccionId, @PathVariable Integer metodoId){
        ResponseDTO responseDTO = metodoService.deleteMetodoSeccion(seccionId, metodoId);

        return  new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping(value = Url.DELETE_METODO_ESTUDIO, method = RequestMethod.DELETE, produces = Url.APLICATION_JSON)
    public ResponseEntity deleteMetodoEstudio(@PathVariable Integer estudioId, @PathVariable Integer metodoId){
        ResponseDTO responseDTO = metodoService.deleteMetodoEstudio(estudioId,metodoId);

        return  new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
