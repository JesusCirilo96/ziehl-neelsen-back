package com.ziehlneelsen.laboratorio.controller.menu;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.menu.MenuDTO;
import com.ziehlneelsen.laboratorio.beans.menu.MenuSubmenuDTO;
import com.ziehlneelsen.laboratorio.constant.Url;
import com.ziehlneelsen.laboratorio.entities.menu.MenuEntity;
import com.ziehlneelsen.laboratorio.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Url.MENU)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class MenuController {
    @Autowired
    MenuService menuService;

    @RequestMapping(value = Url.GET_ALL, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<MenuEntity> findAllMenu(){
        return menuService.findAll();
    }

    @RequestMapping(value = Url.FIND_BY_ID, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public Optional<MenuEntity> findMenu(@PathVariable Integer id){
        return menuService.findById(id);
    }

    @RequestMapping(value = Url.SUB_MENU_BY_MENU, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public MenuSubmenuDTO findSubmenuByMenu(@PathVariable Integer id){
        return menuService.findSubmenuByMenu(id);
    }

    @RequestMapping(value = Url.MENU_SUB_MENU, method = RequestMethod.GET, produces = Url.APLICATION_JSON)
    public List<MenuDTO> getAllMenuSubmenu(){
        return menuService.findAllMenuSubmenu();
    }

    @RequestMapping(value = Url.SAVE, method = RequestMethod.POST, produces = Url.APLICATION_JSON)
    public ResponseEntity saveMenu(@Valid @RequestBody MenuEntity menu, BindingResult bindingResult) {

        ResponseDTO response;
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.OK);
        }
        response = menuService.save(menu);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
