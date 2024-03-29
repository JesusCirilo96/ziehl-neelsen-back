package com.ziehlneelsen.laboratorio.controller.examen;

import com.ziehlneelsen.laboratorio.beans.ExamenDescuentoDTO;
import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenEstudioDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenMetodoAux;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionSaveDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
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
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT})
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

    @RequestMapping(value = Url.EXAMEN_ESTUDIO, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<EstudioDTO> findExamenEstudio(@PathVariable Integer id){
        return examenGeneralService.findEstudioExamen(id);
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

    @RequestMapping(value = Url.SAVE_EXAMEN_ESTUDIO, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveEstudioExamen(@Valid @RequestBody ExamenEstudioDTO examenEstudioDTO, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = examenGeneralService.saveEstudioExamen(examenEstudioDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.SAVE_EXAMEN_SECCION, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveSeccionExamen(@Valid @RequestBody ExamenSeccionSaveDTO examenSeccion, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = examenGeneralService.saveSeccionExamen(examenSeccion);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.UPDATE_EXAMEN_SECCION, method = RequestMethod.PUT, produces = Url.APLICATION_JSON)
    public ResponseEntity updateSeccionExamen(@Valid @RequestBody ExamenSeccionSaveDTO examenSeccion, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = examenGeneralService.updateSeccionExamen(examenSeccion);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.DELETE_EXAMEN_SECCION, method = RequestMethod.DELETE, produces = Url.APLICATION_JSON)
    public ResponseEntity deleteExamenSeccion(@PathVariable Integer examenId, @PathVariable Integer seccionId){
        ResponseDTO responseDTO = examenGeneralService.deleteExamenSeccion(examenId, seccionId);

        return  new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping(value = Url.DELETE_EXAMEN_ESTUDIO, method = RequestMethod.DELETE, produces = Url.APLICATION_JSON)
    public ResponseEntity deleteExamenEstudio(@PathVariable Integer examenId, @PathVariable Integer estudioId){
        ResponseDTO responseDTO = examenGeneralService.deleteExamenEstudio(examenId, estudioId);

        return  new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping(value = Url.UPDATE_METODO_EXAMEN, method = RequestMethod.PUT, produces = Url.APLICATION_JSON)
    public ResponseEntity actualizarMetodo(@Valid @RequestBody ExamenMetodoAux examen, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = examenGeneralService.updateMetodo(examen);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.EXAMEN_DESCUENTO, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public ExamenDescuentoDTO descuentoPorExamen(@PathVariable Integer id){
        return examenGeneralService.findDescuentoByExamen(id);
    }
}
