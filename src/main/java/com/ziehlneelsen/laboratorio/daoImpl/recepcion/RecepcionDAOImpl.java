package com.ziehlneelsen.laboratorio.daoImpl.recepcion;

import com.ziehlneelsen.laboratorio.dao.recepcion.RecepcionDAO;
import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class RecepcionDAOImpl implements RecepcionDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public Integer obtenerFicha() {
        EntityManager em = emf.createEntityManager();
        int max = 0;
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaQuery<Integer> consulta = cb.createQuery(Integer.class);
            Root<RecepcionEntity> recepcion = consulta.from(RecepcionEntity.class);

            Predicate predicateActualDate = cb.equal(recepcion.get("fechaIngreso"),cb.currentDate());

            consulta.select(cb.max(recepcion.get("ficha"))).where(predicateActualDate);

            Integer ultimo = em.createQuery(consulta).getSingleResult();
            if(ultimo == null){
                max = 1;
            }else{
                max = ultimo + 1;
            }
        }catch (DataAccessException e){
            throw e;
        }finally {
            em.close();
        }

        return max;
    }
}
