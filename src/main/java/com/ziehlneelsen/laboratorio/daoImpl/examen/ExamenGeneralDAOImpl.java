package com.ziehlneelsen.laboratorio.daoImpl.examen;

import com.ziehlneelsen.laboratorio.dao.examen.ExamenGeneralDAO;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.List;

@Service
public class ExamenGeneralDAOImpl implements ExamenGeneralDAO {

    @Override
    public ExamenGeneralEntity findByName(String nombre) {
        ExamenGeneralEntity examenGeneral = new ExamenGeneralEntity();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<ExamenGeneralEntity> q = cb.createQuery(ExamenGeneralEntity.class);

            Root<ExamenGeneralEntity> c = q.from(ExamenGeneralEntity.class);

            Predicate nombreExamen = cb.equal(c.get("nombre"),nombre);
            q.select(c).where(nombreExamen);

            List<ExamenGeneralEntity> lista = em.createQuery(q).getResultList();
            examenGeneral = lista.get(0);
        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }
        return examenGeneral;
    }
}
