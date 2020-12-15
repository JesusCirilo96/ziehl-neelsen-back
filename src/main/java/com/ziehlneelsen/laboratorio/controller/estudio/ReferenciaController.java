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

@RestController
@RequestMapping(value = Url.ESTUDIO_REFERENCIA)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
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
}
