package com.ziehlneelsen.laboratorio.controller.menu;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.menu.SubMenuEntity;
import com.ziehlneelsen.laboratorio.service.menu.SubMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Url.SUB_MENU)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class SubMenuController {

    @Autowired
    SubMenuService subMenuService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<SubMenuEntity> findAllSubMenu(){
        return subMenuService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ID, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Optional<SubMenuEntity> findSubMenu(@PathVariable Integer id){
        return subMenuService.findById(id);
    }

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveSubMenu(@Valid @RequestBody SubMenuEntity subMenu, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = subMenuService.save(subMenu);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
