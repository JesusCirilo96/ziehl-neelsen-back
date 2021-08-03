package com.ziehlneelsen.laboratorio.daoImpl.metodo;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.metodo.MetodoDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.metodo.SeccionMetodoDAO;
import com.ziehlneelsen.laboratorio.entities.metodo.*;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEstudioEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeccionMetodoDAOImpl implements SeccionMetodoDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public List<MetodoDTO> getMetodoBySeccion(Integer idSeccion) {
        EntityManager em = emf.createEntityManager();
        List<SeccionMetodo> listSeccionMetodo = new ArrayList<>();
        List<MetodoDTO> listMetodo = new ArrayList<>();

        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<SeccionMetodo> query = cb.createQuery(SeccionMetodo.class);

            Root<SeccionMetodo> c = query.from(SeccionMetodo.class);
            Fetch<SeccionMetodo, MetodoEntity> p = c.fetch("seccion");

            Predicate seccionId = cb.equal(c.get("seccion").get("seccionId"), idSeccion);

            query.select(c).where(seccionId);

            listSeccionMetodo = em.createQuery(query).getResultList();
            listSeccionMetodo.forEach((metodo) -> {

                MetodoDTO metodoDTO = new MetodoDTO();
                metodoDTO.setMetodoId(metodo.getMetodo().getMetodoId());
                metodoDTO.setNombre(metodo.getMetodo().getNombre());

                listMetodo.add(metodoDTO);
            });

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return listMetodo;
    }

    @Override
    public List<MetodoDTO> getMetodoByEstudio(Integer idEstudio) {
        EntityManager em = emf.createEntityManager();
        List<EstudioMetodo> listSeccionMetodo = new ArrayList<>();
        List<MetodoDTO> listMetodo = new ArrayList<>();

        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<EstudioMetodo> query = cb.createQuery(EstudioMetodo.class);

            Root<EstudioMetodo> c = query.from(EstudioMetodo.class);
            Fetch<EstudioMetodo, MetodoEntity> p = c.fetch("estudio");

            Predicate estudioId = cb.equal(c.get("estudio").get("estudioId"), idEstudio);

            query.select(c).where(estudioId);

            listSeccionMetodo = em.createQuery(query).getResultList();
            listSeccionMetodo.forEach((metodo) -> {

                MetodoDTO metodoDTO = new MetodoDTO();
                metodoDTO.setMetodoId(metodo.getMetodo().getMetodoId());
                metodoDTO.setNombre(metodo.getMetodo().getNombre());

                listMetodo.add(metodoDTO);
            });

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return listMetodo;
    }

    @Override
    public ResponseDTO deleteMetodoSeccion(Integer seccionId, Integer metodoId) {
        EntityManager em = emf.createEntityManager();

        ResponseDTO response = new ResponseDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaDelete<SeccionMetodoEntity> queryDelete = cb.createCriteriaDelete(SeccionMetodoEntity.class);

            Root<SeccionMetodoEntity> root = queryDelete.from(SeccionMetodoEntity.class);

            Predicate idSeccion = cb.equal(root.get("seccionId"), seccionId);
            Predicate idMetodo = cb.equal(root.get("metodoId"), metodoId);

            Predicate andPredicate = cb.and(idSeccion,idMetodo);
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
    public ResponseDTO deleteMetodoEstudio(Integer estudioId, Integer metodoId) {
        EntityManager em = emf.createEntityManager();

        ResponseDTO response = new ResponseDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaDelete<EstudioMetodoEntity> queryDelete = cb.createCriteriaDelete(EstudioMetodoEntity.class);

            Root<EstudioMetodoEntity> root = queryDelete.from(EstudioMetodoEntity.class);

            Predicate idEstudio = cb.equal(root.get("estudioId"), estudioId);
            Predicate idMetodo = cb.equal(root.get("metodoId"), metodoId);

            Predicate andPredicate = cb.and(idEstudio,idMetodo);
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
