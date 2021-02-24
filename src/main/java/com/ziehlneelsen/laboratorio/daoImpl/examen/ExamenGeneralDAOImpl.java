package com.ziehlneelsen.laboratorio.daoImpl.examen;

import com.ziehlneelsen.laboratorio.beans.ExamenDescuentoDTO;
import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.examen.ExamenGeneralDAO;
import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.examen.*;
import com.ziehlneelsen.laboratorio.service.descuento.DescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<EstudioEntity> findEstudioByExamen(Integer examenId) {
        EntityManager em = emf.createEntityManager();
        List<ExamenEstudio> listEstudio;
        List<EstudioEntity> estudios = new ArrayList<>();

        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<ExamenEstudio> query = cb.createQuery(ExamenEstudio.class);

            Root<ExamenEstudio> c = query.from(ExamenEstudio.class);
            Fetch<ExamenEstudio, EstudioEntity> p = c.fetch("examen");

            Predicate idExamen = cb.equal(c.get("examen").get("examenGeneralId"), examenId);

            query.select(c).where(idExamen);

            listEstudio = em.createQuery(query).getResultList();


            listEstudio.forEach((estudio) -> {
                estudios.add(estudio.getEstudio());
            });

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return estudios;
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

    @Override
    @Transactional
    @Modifying
    public ResponseDTO deleteExamenEstudio(Integer examenId, Integer estudioId) {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");
        EntityManager em = emf.createEntityManager();

        ResponseDTO response = new ResponseDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaDelete<ExamenEstudioEntity> queryDelete = cb.createCriteriaDelete(ExamenEstudioEntity.class);

            Root<ExamenEstudioEntity> root = queryDelete.from(ExamenEstudioEntity.class);

            Predicate idExamen = cb.equal(root.get("examenId"), examenId);
            Predicate idEstudio = cb.equal(root.get("estudioId"), estudioId);

            Predicate andPredicate = cb.and(idExamen,idEstudio);
            queryDelete.where(andPredicate);

            em.getTransaction().begin();
            int result = em.createQuery(queryDelete).executeUpdate();
            em.getTransaction().commit();

            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.DELETE_OK);

            if(result == 0){
                response.setErrorCode(Messages.ERROR);
                response.setErrorInfo(Messages.ERROR_DELETE);
            }
        }catch (DataAccessException e){
            response.setErrorCode(Messages.ERROR);
            response.setErrorInfo(e.getMostSpecificCause().toString());
        }finally {
            em.close();
        }
        return response;
    }

}
