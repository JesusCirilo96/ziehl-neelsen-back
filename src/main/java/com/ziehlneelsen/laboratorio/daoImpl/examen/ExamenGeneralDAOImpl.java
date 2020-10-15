package com.ziehlneelsen.laboratorio.daoImpl.examen;

import com.ziehlneelsen.laboratorio.beans.ExamenDescuentoDTO;
import com.ziehlneelsen.laboratorio.dao.examen.ExamenGeneralDAO;
import com.ziehlneelsen.laboratorio.entities.cotizacion.CotizacionEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralDescuento;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.service.descuento.DescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExamenGeneralDAOImpl implements ExamenGeneralDAO {

    @Autowired
    DescuentoService descuentoService;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public ExamenGeneralEntity findByName(String nombre) {
        ExamenGeneralEntity examenGeneral = new ExamenGeneralEntity();
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

    @Override
    public ExamenDescuentoDTO findDescuentoByExamen(Integer examenId) {
        EntityManager em = emf.createEntityManager();
        List<ExamenGeneralDescuento> listDescuento;
        List<DescuentoEntity> descuentos = new ArrayList<>();

        ExamenDescuentoDTO examenDescuento = new ExamenDescuentoDTO();

        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<ExamenGeneralDescuento> query = cb.createQuery(ExamenGeneralDescuento.class);

            Root<ExamenGeneralDescuento> c = query.from(ExamenGeneralDescuento.class);
            Fetch<ExamenGeneralDescuento, ExamenGeneralEntity> p = c.fetch("examen");

            Predicate idExamen = cb.equal(c.get("examen").get("examenGeneralId"), examenId);

            query.select(c).where(idExamen);

            listDescuento = em.createQuery(query).getResultList();

            listDescuento.forEach((descuento) -> {
                try {
                    if(descuentoService.aplicaDescuento(descuento.getDescuento().getDescuentoId())){
                        descuentos.add(descuento.getDescuento());
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });

            if(!listDescuento.isEmpty()){
                examenDescuento.setExamen(listDescuento.get(0).getExamen());
                examenDescuento.setDescuento(descuentos);
            }


        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return examenDescuento;
    }
// nesCiriloEst@
}
