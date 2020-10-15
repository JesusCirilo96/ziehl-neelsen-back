package com.ziehlneelsen.laboratorio.daoImpl.descuento;

import com.ziehlneelsen.laboratorio.beans.descuento.PaqueteDescuentoDTO;
import com.ziehlneelsen.laboratorio.dao.descuento.PaqueteDescuentoDAO;
import com.ziehlneelsen.laboratorio.entities.descuento.PaqueteDescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.PaqueteDescuentoExamen;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaqueteDescuentoDAOImpl implements PaqueteDescuentoDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public PaqueteDescuentoDTO findExamenByPaquete(Integer paqueteId) {
        EntityManager em = emf.createEntityManager();
        List<PaqueteDescuentoExamen> listPaquete = new ArrayList<>();
        List<ExamenGeneralEntity> examenes = new ArrayList<>();

        PaqueteDescuentoDTO paqueteDescuento = new PaqueteDescuentoDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<PaqueteDescuentoExamen> query = cb.createQuery(PaqueteDescuentoExamen.class);

            Root<PaqueteDescuentoExamen> c = query.from(PaqueteDescuentoExamen.class);
            Fetch<PaqueteDescuentoExamen, PaqueteDescuentoEntity> p = c.fetch("paquete");

            Predicate idPaquete = cb.equal(c.get("paquete").get("paqueteId"), paqueteId);

            query.select(c).where(idPaquete);

            listPaquete = em.createQuery(query).getResultList();
            listPaquete.forEach((paquete) -> {
                examenes.add(paquete.getExamen());
            });

            paqueteDescuento.setPaquete(listPaquete.get(0).getPaquete());
            paqueteDescuento.setExamen(examenes);


        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return paqueteDescuento;
    }

    @Override
    public List<PaqueteDescuentoEntity> findAllPaquete() {
        EntityManager em = emf.createEntityManager();
        List<PaqueteDescuentoEntity> listPaqueteDescuento = new ArrayList<>();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<PaqueteDescuentoEntity> query = cb.createQuery(PaqueteDescuentoEntity.class);

            Root<PaqueteDescuentoEntity> c = query.from(PaqueteDescuentoEntity.class);

            Predicate estado = cb.equal(c.get("estado"),1);
            query.select(c).where(estado);

            listPaqueteDescuento = em.createQuery(query).getResultList();


        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return listPaqueteDescuento;
    }
}
