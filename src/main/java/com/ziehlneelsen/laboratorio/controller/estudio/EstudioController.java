package com.ziehlneelsen.laboratorio.controller.estudio;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioSaveDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioSelectDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.service.estudio.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Url.ESTUDIO)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class EstudioController {

    @Autowired
    EstudioService estudioService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<EstudioEntity> findAllEstudio(){
        return estudioService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ID, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Optional<EstudioEntity> findEstudio(@PathVariable Integer id){
        return estudioService.findById(id);
    }

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveEstudio(@Valid @RequestBody EstudioEntity estudio, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = estudioService.save(estudio);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.SAVE_MASIVO, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveEstudioMasivo(@RequestBody ArrayList<EstudioSaveDTO> estudio) {

        ResponseDTO response;
        response = estudioService.saveMasivo(estudio);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.COMODIN, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public ResponseEntity updateComodin(@PathVariable Integer estudioId, @PathVariable Boolean estado){
        ResponseDTO response;
        response = estudioService.updateComodin(estudioId, estado);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.RES_SELECT, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity updateSelect(@Valid @RequestBody EstudioSelectDTO estudio, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = estudioService.updateSelect(estudio);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
