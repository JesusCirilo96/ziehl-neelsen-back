package com.ziehlneelsen.laboratorio.daoImpl.examen;

import com.ziehlneelsen.laboratorio.dao.examen.ExamenSencilloDAO;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenSencilloEntity;
import org.springframework.dao.DataAccessException;
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
public class ExamenSencilloDAOImpl implements ExamenSencilloDAO {

    @Override
    public ExamenSencilloEntity findByName(String nombre) {
        ExamenSencilloEntity examenSencillo = new ExamenSencilloEntity();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<ExamenSencilloEntity> q = cb.createQuery(ExamenSencilloEntity.class);

            Root<ExamenSencilloEntity> c = q.from(ExamenSencilloEntity.class);

            Predicate nombreExamen = cb.equal(c.get("nombre"),nombre);
            q.select(c).where(nombreExamen);

            List<ExamenSencilloEntity> lista = em.createQuery(q).getResultList();
            examenSencillo = lista.get(0);
        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }
        return examenSencillo;
    }
}
