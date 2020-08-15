package com.ziehlneelsen.laboratorio.controller.persona;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.UserAuthDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.persona.UsuarioEntity;
import com.ziehlneelsen.laboratorio.service.persona.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Url.USUARIO)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<UsuarioEntity> findAllUsuario(){
        return usuarioService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ID, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Optional<UsuarioEntity> findUsuario(@PathVariable Integer id){
        return usuarioService.findById(id);
    }

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveUsuario(@Valid @RequestBody UsuarioEntity usuario, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = usuarioService.save(usuario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Url.AUTH, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public UsuarioEntity authenticate(@PathVariable String user, @PathVariable String password){
        return usuarioService.authenticate(user,password);
    }

}
