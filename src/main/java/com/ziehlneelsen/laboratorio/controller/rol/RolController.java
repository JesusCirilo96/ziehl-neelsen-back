package com.ziehlneelsen.laboratorio.controller.rol;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;
import com.ziehlneelsen.laboratorio.service.rol.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Url.ROL)
public class RolController {

    @Autowired
    RolService rolService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<RolEntity> findAllRol(){
        return rolService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ID, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Optional<RolEntity> findRol(@PathVariable Integer id){
        return rolService.findById(id);
    }

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveRol(@Valid @RequestBody RolEntity rol, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = rolService.save(rol);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
