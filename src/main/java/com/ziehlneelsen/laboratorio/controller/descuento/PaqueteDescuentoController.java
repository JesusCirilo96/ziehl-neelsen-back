package com.ziehlneelsen.laboratorio.controller.descuento;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.DescuentoSaveDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.PaqueteDescuentoDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.PaqueteSaveDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.descuento.PaqueteDescuentoEntity;
import com.ziehlneelsen.laboratorio.service.descuento.PaqueteDescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Url.PAQUETE_DESCUENTO)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE})
public class PaqueteDescuentoController {

    @Autowired
    PaqueteDescuentoService paqueteDescuentoService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<PaqueteDescuentoEntity> findAllPaquete(){
        return paqueteDescuentoService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ID, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Optional<PaqueteDescuentoEntity> findPaquete(@PathVariable Integer id){
        return paqueteDescuentoService.findById(id);
    }

    @RequestMapping(value = Url.FIND_BY_PAQUETE, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public PaqueteDescuentoDTO findExamenByPaquete(@PathVariable Integer id){
        return paqueteDescuentoService.findExamenByPaquete(id);
    }

    @RequestMapping(value = Url.FIND_ALL_PAQUETE, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<PaqueteDescuentoDTO> findAllPaqueteByDia() throws ParseException {
        return paqueteDescuentoService.findAllPaqueteByDia();
    }

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity savePaqueteDescuento(@Valid @RequestBody PaqueteDescuentoEntity paquete, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = paqueteDescuentoService.save(paquete);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.SAVE_PAQUETE_EXAMEN, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity savePaqueteExamen(@Valid @RequestBody PaqueteSaveDTO descuento) {

        ResponseDTO response;
        response = paqueteDescuentoService.savePaqueteExamen(descuento);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.DELETE_DESCUENTO, method = RequestMethod.DELETE, produces = Url.APLICATION_JSON)
    public ResponseDTO eliminaPaquete(@PathVariable Integer id){
        return paqueteDescuentoService.deletePaquete(id);
    }

}
