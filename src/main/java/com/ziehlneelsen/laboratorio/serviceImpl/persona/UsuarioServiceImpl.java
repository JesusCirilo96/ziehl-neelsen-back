package com.ziehlneelsen.laboratorio.serviceImpl.persona;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UserAuthDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UsuarioDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UsuarioRolDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.persona.UsuarioLoginDAO;
import com.ziehlneelsen.laboratorio.dao.persona.UsuarioRolDAO;
import com.ziehlneelsen.laboratorio.entities.persona.UsuarioEntity;
import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;
import com.ziehlneelsen.laboratorio.repository.persona.UsuarioRepository;
import com.ziehlneelsen.laboratorio.service.persona.UsuarioService;
import com.ziehlneelsen.laboratorio.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioLoginDAO usuarioLoginDAO;

    @Autowired
    private UsuarioRolDAO usuarioRolDAO;

    public UsuarioServiceImpl(UsuarioLoginDAO usuarioLoginDAO) {
        this.usuarioLoginDAO = usuarioLoginDAO;
    }

    @Override
    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<UsuarioEntity> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public UsuarioRolDTO findRolByUsuario(Integer usuarioId) {
        return usuarioRolDAO.findRolByUsuario(usuarioId);
    }

    @Override
    public ResponseDTO save(UsuarioEntity usuario) {
        ResponseDTO response = new ResponseDTO();
        if(null != usuario.getUsuarioId() && usuarioRepository.findById(usuario.getUsuarioId()).isPresent()){
            usuario.setFechaActualizacion(Utileria.fechaHoraActual());
            usuarioRepository.save(usuario);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != usuario){
            try{
                usuario.setFechaCreacion(Utileria.fechaHoraActual());
                usuario.setFechaActualizacion(Utileria.fechaHoraActual());
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
    public UserAuthDTO authenticate(String user, String password) {
        return login(user,password);
    }

    private UserAuthDTO login(String usuario, String password){
          UserAuthDTO usuarioLogeado = new UserAuthDTO();
          try {
              usuarioLogeado = usuarioLoginDAO.login(usuario, password);
          }catch (Exception e){
              e.printStackTrace();
          }
          return usuarioLogeado;
    }

    @Override
    public ResponseDTO actualizaDatos(UsuarioDTO usuarioDTO){
        return usuarioLoginDAO.updateData(usuarioDTO);
    }
}
