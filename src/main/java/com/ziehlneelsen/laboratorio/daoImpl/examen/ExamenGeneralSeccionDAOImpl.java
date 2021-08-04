package com.ziehlneelsen.laboratorio.daoImpl.examen;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionSaveDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.SeccionEstudioDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.examen.ExamenGeneralSeccionDAO;
import com.ziehlneelsen.laboratorio.dao.seccion.SeccionEstudioDAO;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralSeccion;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralSeccionEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;
import com.ziehlneelsen.laboratorio.repository.examen.ExamenGeneralRepository;
import com.ziehlneelsen.laboratorio.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExamenGeneralSeccionDAOImpl implements ExamenGeneralSeccionDAO {

    @Autowired
    SeccionEstudioDAO seccionEstudioDAO;

    @Autowired
    ExamenGeneralRepository examenGeneralRepository;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public ExamenSeccionDTO getExamenSeccion(Integer examenId){
        EntityManager em = emf.createEntityManager();

        List<ExamenGeneralSeccion> listExamenSeccion;
        List<SeccionEstudioDTO> listSeccionEstudio = new ArrayList<>();

        ExamenSeccionDTO examenSeccion = new ExamenSeccionDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<ExamenGeneralSeccion> query = cb.createQuery(ExamenGeneralSeccion.class);

            Root<ExamenGeneralSeccion> c = query.from(ExamenGeneralSeccion.class);
            Fetch<ExamenGeneralSeccion, SeccionEntity> p = c.fetch("seccion");

            Predicate idExamen = cb.equal(c.get("examen").get("examenGeneralId"), examenId);
            query.select(c).where(idExamen).orderBy(cb.asc(c.get("orden")));

            listExamenSeccion = em.createQuery(query).getResultList();
            listExamenSeccion.forEach((seccion) -> {
                SeccionEstudioDTO seccionEstudio = seccionEstudioDAO.getEstudioSeccion(seccion.getSeccion().getSeccionId());
                seccionEstudio.setOrden(seccion.getOrden());
                listSeccionEstudio.add(seccionEstudio);
            });

            examenSeccion.setExamen(examenGeneralRepository.findById(examenId));
            examenSeccion.setSeccion(listSeccionEstudio);

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return examenSeccion;
    }

    @Override
    @Transactional
    @Modifying
    public ResponseDTO deleteExamenSeccion(Integer examenId, Integer seccionId) {
        EntityManager em = emf.createEntityManager();

        ResponseDTO response = new ResponseDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaDelete<ExamenGeneralSeccionEntity> queryDelete = cb.createCriteriaDelete(ExamenGeneralSeccionEntity.class);

            Root<ExamenGeneralSeccionEntity> root = queryDelete.from(ExamenGeneralSeccionEntity.class);

            Predicate idExamen = cb.equal(root.get("examenId"), examenId);
            Predicate idSeccion = cb.equal(root.get("seccionId"), seccionId);

            Predicate andPredicate = cb.and(idExamen,idSeccion);
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

    @Override
    @Transactional
    @Modifying
    public ResponseDTO updateOrdenSeccionExamen(Integer seccionId, Integer examenId, Integer orden) {
        ResponseDTO response = new ResponseDTO();
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaUpdate<ExamenGeneralSeccionEntity> update = cb.createCriteriaUpdate(ExamenGeneralSeccionEntity.class);

            Root updateOrden = update.from(ExamenGeneralSeccionEntity.class);

            Predicate idSeccion = cb.equal(updateOrden.get("seccionId"),seccionId);
            Predicate idExamen = cb.equal(updateOrden.get("examenId"),examenId);
            Predicate andPredicate = cb.and(idSeccion,idExamen);

            update.set("orden", orden);

            update.where(andPredicate);

            em.getTransaction().begin();
            int result = em.createQuery(update).executeUpdate();
            em.getTransaction().commit();

            if(result == 0){
                response.setErrorCode(Messages.ERROR);
                response.setErrorInfo(Messages.UPDATE_ERROR);
            }
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);

        }catch (DataAccessException e){
            response.setErrorCode(Messages.ERROR);
            response.setErrorInfo(Messages.UPDATE_ERROR);
            throw e;
        }finally {
            em.close();
        }

        return response;
    }

    @Override
    @Transactional
    @Modifying
    public ResponseDTO updateSeccion(ExamenSeccionSaveDTO seccionSaveDTO) {
        ResponseDTO response = new ResponseDTO();
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaUpdate<SeccionEntity> update = cb.createCriteriaUpdate(SeccionEntity.class);

            Root updateOrden = update.from(SeccionEntity.class);

            Predicate idSeccion = cb.equal(updateOrden.get("seccionId"),seccionSaveDTO.getSeccionId());

            update.set("nombre", seccionSaveDTO.getNombreSeccion());
            update.set("textoCent", seccionSaveDTO.getTextoCent());
            update.set("textoDer", seccionSaveDTO.getTextoDer());
            update.set("titulo", seccionSaveDTO.getTitulo());
            update.set("fechaActualizacion", Utileria.fechaHoraActual());

            update.where(idSeccion);

            em.getTransaction().begin();
            int result = em.createQuery(update).executeUpdate();
            em.getTransaction().commit();

            if(result == 0){
                response.setErrorCode(Messages.ERROR);
                response.setErrorInfo(Messages.UPDATE_ERROR);
            }
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);

        }catch (DataAccessException e){
            response.setErrorCode(Messages.ERROR);
            response.setErrorInfo(Messages.UPDATE_ERROR);
            throw e;
        }finally {
            em.close();
        }

        return response;
    }
}
