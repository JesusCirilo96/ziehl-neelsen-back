package com.ziehlneelsen.laboratorio.daoImpl.examen;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.SeccionEstudioDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.examen.ExamenGeneralSeccionDAO;
import com.ziehlneelsen.laboratorio.dao.seccion.SeccionEstudioDAO;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralSeccion;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralSeccionEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;
import com.ziehlneelsen.laboratorio.repository.examen.ExamenGeneralRepository;
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

    @Override
    public ExamenSeccionDTO getExamenSeccion(Integer examenId){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");
        EntityManager em = emf.createEntityManager();

        List<ExamenGeneralSeccion> listExamenSeccion = new ArrayList<>();
        List<SeccionEstudioDTO> listSeccionEstudio = new ArrayList<>();

        ExamenSeccionDTO examenSeccion = new ExamenSeccionDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<ExamenGeneralSeccion> query = cb.createQuery(ExamenGeneralSeccion.class);

            Root<ExamenGeneralSeccion> c = query.from(ExamenGeneralSeccion.class);
            Fetch<ExamenGeneralSeccion, SeccionEntity> p = c.fetch("seccion");

            Predicate idExamen = cb.equal(c.get("examen").get("examenGeneralId"), examenId);

            query.select(c).where(idExamen);

            listExamenSeccion = em.createQuery(query).getResultList();
            listExamenSeccion.forEach((seccion) -> {
                SeccionEstudioDTO seccionEstudio = seccionEstudioDAO.getEstudioSeccion(seccion.getSeccion().getSeccionId());

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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");
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
}
