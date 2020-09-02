package com.ziehlneelsen.laboratorio.daoImpl.persona;

import com.ziehlneelsen.laboratorio.beans.persona.UserAuthDTO;
import com.ziehlneelsen.laboratorio.dao.persona.UsuarioLoginDAO;
import com.ziehlneelsen.laboratorio.entities.persona.UsuarioEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class UsuarioLoginDAOImpl implements UsuarioLoginDAO {

    @Override
    public UserAuthDTO login(String user, String password) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");
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
}
