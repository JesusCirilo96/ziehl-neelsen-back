package com.ziehlneelsen.laboratorio.daoImpl.metodo;

import com.ziehlneelsen.laboratorio.beans.metodo.MetodoDTO;
import com.ziehlneelsen.laboratorio.dao.metodo.SeccionMetodoDAO;
import com.ziehlneelsen.laboratorio.entities.metodo.MetodoEntity;
import com.ziehlneelsen.laboratorio.entities.metodo.SeccionMetodo;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeccionMetodoDAOImpl implements SeccionMetodoDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public List<MetodoDTO> getMetodoBySeccion(Integer idSeccion) {
        EntityManager em = emf.createEntityManager();
        List<SeccionMetodo> listSeccionMetodo = new ArrayList<>();
        List<MetodoDTO> listMetodo = new ArrayList<>();

        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<SeccionMetodo> query = cb.createQuery(SeccionMetodo.class);

            Root<SeccionMetodo> c = query.from(SeccionMetodo.class);
            Fetch<SeccionMetodo, MetodoEntity> p = c.fetch("seccion");

            Predicate seccionId = cb.equal(c.get("seccion").get("seccionId"), idSeccion);

            query.select(c).where(seccionId);

            listSeccionMetodo = em.createQuery(query).getResultList();
            listSeccionMetodo.forEach((metodo) -> {

                MetodoDTO metodoDTO = new MetodoDTO();
                metodoDTO.setMetodoId(metodo.getMetodo().getMetodoId());
                metodoDTO.setNombre(metodo.getMetodo().getNombre());

                listMetodo.add(metodoDTO);
            });

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return listMetodo;
    }
}
