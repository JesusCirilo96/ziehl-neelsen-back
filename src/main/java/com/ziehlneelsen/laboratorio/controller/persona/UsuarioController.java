package com.ziehlneelsen.laboratorio.controller.persona;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UserAuthDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UsuarioDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UsuarioRolDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.persona.UsuarioEntity;
import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;
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
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
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

    @RequestMapping(value = Url.FIND_ROL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public UsuarioRolDTO findRolByUsuario(@PathVariable Integer id){
        return usuarioService.findRolByUsuario(id);
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
    public UserAuthDTO  authenticate(@PathVariable String user, @PathVariable String password){
        return usuarioService.authenticate(user,password);
    }

    @RequestMapping(value = Url.UPDATE_DATOS, method = RequestMethod.PUT, produces = Url.APLICATION_JSON)
    public ResponseEntity updateDatos(@RequestBody UsuarioDTO usuario) {

        ResponseDTO response;
        response = usuarioService.actualizaDatos(usuario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
