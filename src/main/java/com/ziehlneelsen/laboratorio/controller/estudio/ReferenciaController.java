package com.ziehlneelsen.laboratorio.controller.estudio;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ReferenciaDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.estudio.ReferenciaEntity;
import com.ziehlneelsen.laboratorio.service.estudio.ReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = Url.ESTUDIO_REFERENCIA)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT})
public class ReferenciaController {

    @Autowired
    ReferenciaService referenciaService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<ReferenciaEntity> findAllReferencia(){
        return referenciaService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ESTUDIO, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<ReferenciaDTO> findByEstudio(@PathVariable Integer id){
        return referenciaService.findByEstudio(id);
    }

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveReferencia(@Valid @RequestBody ReferenciaEntity referencia, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = referenciaService.save(referencia);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.DELETE_REFERENCIA, method = RequestMethod.DELETE, produces = Url.APLICATION_JSON)
    public ResponseEntity deleteReferencia(@PathVariable UUID referenciaId){
        ResponseDTO responseDTO = referenciaService.deleteReferencia(referenciaId);

        return  new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping(value = Url.UPDATE_REFERENCIA, method = RequestMethod.PUT, produces = Url.APLICATION_JSON)
    public ResponseEntity updateReferencia(@Valid @RequestBody ReferenciaEntity referencia, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = referenciaService.updateReferencia(referencia);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
