package com.ziehlneelsen.laboratorio.daoImpl.persona;

import com.ziehlneelsen.laboratorio.beans.persona.UsuarioRolDTO;
import com.ziehlneelsen.laboratorio.dao.persona.UsuarioRolDAO;
import com.ziehlneelsen.laboratorio.entities.persona.UsuarioRol;
import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;
import com.ziehlneelsen.laboratorio.repository.persona.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioRolDAOImpl implements UsuarioRolDAO {

    @Autowired
    UsuarioRepository usuarioRepository;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public UsuarioRolDTO findRolByUsuario(Integer usuarioId) {
        EntityManager em = emf.createEntityManager();
        List<UsuarioRol> listUsuarioRol = new ArrayList<>();
        List<RolEntity> listRol = new ArrayList<>();

        UsuarioRolDTO usuariRol = new UsuarioRolDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<UsuarioRol> query = cb.createQuery(UsuarioRol.class);

            Root<UsuarioRol> c = query.from(UsuarioRol.class);
            Fetch<UsuarioRol, RolEntity> p = c.fetch("usuario");

            Predicate idUsuario = cb.equal(c.get("usuario").get("usuarioId"), usuarioId);

            query.select(c).where(idUsuario);

            listUsuarioRol = em.createQuery(query).getResultList();
            listUsuarioRol.forEach((rol) -> {
                listRol.add(rol.getRol());
            });

            if(!listUsuarioRol.isEmpty()){
                usuariRol.setRol(listRol);
            }

            usuariRol.setUsuario(usuarioRepository.findById(usuarioId));

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return usuariRol;

    }
}
