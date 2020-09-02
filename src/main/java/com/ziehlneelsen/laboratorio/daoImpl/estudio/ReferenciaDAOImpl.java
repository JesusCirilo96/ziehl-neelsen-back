package com.ziehlneelsen.laboratorio.daoImpl.estudio;

import com.ziehlneelsen.laboratorio.dao.estudio.ReferenciaDAO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.estudio.ReferenciaEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReferenciaDAOImpl implements ReferenciaDAO {

    @Override
    public List<ReferenciaEntity> getByEstudio(Integer idEstudio) {
        List<ReferenciaEntity> listReferencia = new ArrayList<>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");
        EntityManager em = emf.createEntityManager();

        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<ReferenciaEntity> q = cb.createQuery(ReferenciaEntity.class);

            Root<ReferenciaEntity> c = q.from(ReferenciaEntity.class);
            Fetch<ReferenciaEntity,EstudioEntity> p = c.fetch("estudio");

            Predicate predicateEstudioId = cb.equal(c.get("estudio"),idEstudio);
            q.select(c).where(predicateEstudioId);
            listReferencia = em.createQuery(q).getResultList();

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return listReferencia;
    }
}
