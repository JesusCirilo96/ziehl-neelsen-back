package com.ziehlneelsen.laboratorio.serviceImpl.persona;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.UserAuthDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.entities.persona.UsuarioEntity;
import com.ziehlneelsen.laboratorio.repository.persona.UsuarioRepository;
import com.ziehlneelsen.laboratorio.service.persona.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<UsuarioEntity> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public ResponseDTO save(UsuarioEntity usuario) {
        ResponseDTO response = new ResponseDTO();
        if(null != usuario.getUsuarioId() && usuarioRepository.findById(usuario.getUsuarioId()).isPresent()){
            usuarioRepository.save(usuario);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != usuario){
            try{
                usuarioRepository.save(usuario);
                response.setErrorCode(Messages.OK);
                response.setErrorInfo(Messages.REGISTER_OK);
            }catch(DataAccessException ex) {
                response.setErrorCode(Messages.ERROR);
                response.setErrorInfo(ex.getMostSpecificCause().toString());
            }
        }
        return response;
    }

    @Override
    public UsuarioEntity authenticate(String user, String password) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();

        try{
            Optional<UsuarioEntity> response = usuarioRepository.userLogin(user,password);
            usuarioEntity = response.get();
            /**usuarioDTO.setUsuarioId(response.get().getUsuarioId());
            usuarioDTO.setNombre(response.get().getNombre());
            usuarioDTO.setApellidoMaterno(response.get().getApellidoPaterno());
            usuarioDTO.setApellidoPaterno(response.get().getApellidoMaterno());
            usuarioDTO.setCedula(response.get().getCedula());*/

        }catch (DataAccessException e){
            e.getMostSpecificCause();
        }

        return usuarioEntity;
    }
}
