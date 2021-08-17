package com.ziehlneelsen.laboratorio.daoImpl.persona;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UserAuthDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UsuarioDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.persona.UsuarioLoginDAO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.persona.UsuarioEntity;
import com.ziehlneelsen.laboratorio.util.Utileria;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.List;

@Service
public class UsuarioLoginDAOImpl implements UsuarioLoginDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public UserAuthDTO login(String user, String password) {
        EntityManager em = emf.createEntityManager();

        UserAuthDTO usuarioAuth = new UserAuthDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaQuery<UsuarioEntity> consulta = cb.createQuery(UsuarioEntity.class);
            Root<UsuarioEntity> usuarios = consulta.from(UsuarioEntity.class);

            Predicate predicateUser = cb.equal(usuarios.get("nombreUsuario"),user);
            Predicate predicatePass = cb.equal(usuarios.get("password"),password);

            Predicate clausula = cb.and(predicateUser,predicatePass);

            consulta.select(usuarios).where(clausula);

            List<UsuarioEntity> lista = em.createQuery(consulta).getResultList();
            lista.forEach((usuario) -> {

                usuarioAuth.setUsuarioId(usuario.getUsuarioId());
                usuarioAuth.setNombre(usuario.getNombre());
                usuarioAuth.setApellidoPaterno(usuario.getApellidoPaterno());
                usuarioAuth.setApellidoMaterno(usuario.getApellidoMaterno());
                usuarioAuth.setCedula(usuario.getCedula());

                System.out.println(usuarioAuth.toString());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }

        return usuarioAuth;
    }

    @Override
    public ResponseDTO updateData(UsuarioDTO usuarioDTO) {
        ResponseDTO response = new ResponseDTO();
        EntityManager emg = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaUpdate<UsuarioEntity> update = cb.createCriteriaUpdate(UsuarioEntity.class);

            Root updateUsuario = update.from(UsuarioEntity.class);

            Predicate usuarioId = cb.equal(updateUsuario.get("usuarioId"),usuarioDTO.getUsuarioId());

            update.set("nombre", usuarioDTO.getNombre());
            update.set("apellidoPaterno", usuarioDTO.getApellidoPaterno());
            update.set("apellidoMaterno", usuarioDTO.getApellidoMaterno());
            update.set("nombreUsuario", usuarioDTO.getNombreUsuario());
            update.set("cedula",usuarioDTO.getCedula());
            update.set("email",usuarioDTO.getEmail());
            update.set("movil",usuarioDTO.getMovil());
            update.set("direccion", usuarioDTO.getDireccion());

            update.set("fechaActualizacion", Utileria.fechaHoraActual());

            update.where(usuarioId);

            emg.getTransaction().begin();
            int result = emg.createQuery(update).executeUpdate();
            emg.getTransaction().commit();

            if(result == 0){
                response.setErrorCode(Messages.ERROR);
                response.setErrorInfo(Messages.UPDATE_ERROR);
            }
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);

        }catch (DataAccessException e){
            response.setErrorCode(Messages.ERROR);
            response.setErrorInfo(Messages.UPDATE_ERROR);
            throw e;
        }finally {
            emg.close();
        }

        return response;
    }
}
