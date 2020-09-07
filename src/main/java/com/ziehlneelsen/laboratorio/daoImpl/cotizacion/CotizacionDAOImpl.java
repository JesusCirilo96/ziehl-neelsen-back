package com.ziehlneelsen.laboratorio.daoImpl.cotizacion;

import com.ziehlneelsen.laboratorio.beans.cotizacion.CotizacionExamenesDTO;
import com.ziehlneelsen.laboratorio.dao.cotizacion.CotizacionDAO;
import com.ziehlneelsen.laboratorio.entities.cotizacion.CotizacionEntity;
import com.ziehlneelsen.laboratorio.entities.cotizacion.CotizacionExamenGeneral;
import com.ziehlneelsen.laboratorio.entities.cotizacion.CotizacionExamenSencillo;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenSencilloEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CotizacionDAOImpl implements CotizacionDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public CotizacionExamenesDTO getExamenCotizacion(String cotizacionId) {

        List<CotizacionExamenSencillo> listCotizacion;
        CotizacionExamenesDTO cotizacionExamen = new CotizacionExamenesDTO();

        EntityManager em = emf.createEntityManager();

        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<CotizacionExamenSencillo> query = cb.createQuery(CotizacionExamenSencillo.class);

            Root<CotizacionExamenSencillo> c = query.from(CotizacionExamenSencillo.class);
            Fetch<CotizacionExamenSencillo, CotizacionEntity> p = c.fetch("cotizacion");

            Predicate idCotizacion = cb.equal(c.get("cotizacion").get("cotizacionId"),cotizacionId);

            query.select(c).where(idCotizacion);

            listCotizacion = em.createQuery(query).getResultList();

            List<ExamenSencilloEntity> examenes = new ArrayList<>();

            listCotizacion.forEach((cotizacion) -> {
                examenes.add(cotizacion.getExamenSencillo());
            });

            cotizacionExamen.setExamenGeneral(getExamenGeneral(cotizacionId));
            cotizacionExamen.setCotizacion(listCotizacion.get(0).getCotizacion());
            cotizacionExamen.setExamenSencillo(examenes);

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return cotizacionExamen;
    }

    @Override
    public List<CotizacionEntity> getCotizacionByFecha(String fecha) {

        EntityManager em = emf.createEntityManager();
        List<CotizacionEntity> listCotizacion = new ArrayList<>();
        try{

            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<CotizacionEntity> query = cb.createQuery(CotizacionEntity.class);

            Root<CotizacionEntity> cotizacionR = query.from(CotizacionEntity.class);

            Predicate fechaP = cb.equal(cotizacionR.get("fechaCotizacion"), fecha);

            query.select(cotizacionR).where(fechaP);

            listCotizacion = em.createQuery(query).getResultList();

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return listCotizacion;
    }

    private List<ExamenGeneralEntity> getExamenGeneral(String cotizacionId) {
        EntityManager em = emf.createEntityManager();
        List<CotizacionExamenGeneral> listCotizacion;
        List<ExamenGeneralEntity> examenes = new ArrayList<>();

        try {

            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<CotizacionExamenGeneral> query = cb.createQuery(CotizacionExamenGeneral.class);

            Root<CotizacionExamenGeneral> c = query.from(CotizacionExamenGeneral.class);
            Fetch<CotizacionExamenGeneral, CotizacionEntity> p = c.fetch("cotizacion");

            Predicate idCotizacion = cb.equal(c.get("cotizacion").get("cotizacionId"), cotizacionId);
            query.select(c).where(idCotizacion);

            listCotizacion = em.createQuery(query).getResultList();

            listCotizacion.forEach((cotizacion) -> {
                examenes.add(cotizacion.getExamenGeneral());
            });

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }


        return examenes;
    }
}
