package com.ziehlneelsen.laboratorio.daoImpl.descuento;

import com.ziehlneelsen.laboratorio.dao.descuento.DiaDescuentoDAO;
import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.DiaDescuento;
import com.ziehlneelsen.laboratorio.entities.descuento.DiaEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiaDescuentoDAOImpl implements DiaDescuentoDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public List<DiaDescuento> getByDescuento(Integer descuentoId) {
        EntityManager em = emf.createEntityManager();
        List<DiaDescuento> listDiaDescuento = new ArrayList<>();
        List<DiaEntity> descuento = new ArrayList<>();

        //DiaDescuentoDTO diaDescuentoDTO = new DiaDescuentoDTO();

        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<DiaDescuento> query = cb.createQuery(DiaDescuento.class);

            Root<DiaDescuento> c = query.from(DiaDescuento.class);
            Fetch<DiaDescuento, DescuentoEntity> p = c.fetch("dia");

            Predicate idDescuento = cb.equal(c.get("descuento").get("descuentoId"), descuentoId);
            Predicate estado = cb.equal(c.get("descuento").get("estado"),1);
            Predicate clausula = cb.and(idDescuento,estado);

            query.select(c).where(clausula);

            listDiaDescuento = em.createQuery(query).getResultList();

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }
        return listDiaDescuento;
    }
}
