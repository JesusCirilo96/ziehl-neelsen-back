package com.ziehlneelsen.laboratorio.daoImpl.seccion;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.SeccionEstudioDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.estudio.ReferenciaDAO;
import com.ziehlneelsen.laboratorio.dao.metodo.SeccionMetodoDAO;
import com.ziehlneelsen.laboratorio.dao.seccion.SeccionEstudioDAO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEstudio;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEstudioEntity;
import com.ziehlneelsen.laboratorio.repository.seccion.SeccionRepository;
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
public class SeccionEstudioDAOImpl implements SeccionEstudioDAO {

    @Autowired
    SeccionRepository seccionRepository ;

    @Autowired
    SeccionMetodoDAO seccionMetodoDAO;

    @Autowired
    ReferenciaDAO referenciaDAO;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public SeccionEstudioDTO getEstudioSeccion(Integer seccionId) {
        EntityManager em = emf.createEntityManager();
        List<SeccionEstudio> listSeccionEstudio = new ArrayList<>();
        List<EstudioDTO> listEstudio = new ArrayList<>();

        SeccionEstudioDTO seccionEstudio = new SeccionEstudioDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<SeccionEstudio> query = cb.createQuery(SeccionEstudio.class);

            Root<SeccionEstudio> c = query.from(SeccionEstudio.class);
            Fetch<SeccionEstudio, EstudioEntity> p = c.fetch("seccion");

            Predicate idSeccion = cb.equal(c.get("seccion").get("seccionId"), seccionId);

            query.select(c).where(idSeccion);

            listSeccionEstudio = em.createQuery(query).getResultList();
            listSeccionEstudio.forEach((estudio) -> {

                EstudioDTO estudioDTO = new EstudioDTO();
                estudioDTO.setEstudioId(estudio.getEstudio().getEstudioId());
                estudioDTO.setNombre(estudio.getEstudio().getNombre());
                estudioDTO.setEstado(estudio.getEstudio().getEstado());
                estudioDTO.setOrden(estudio.getOrden());
                estudioDTO.setFechaCreacion(estudio.getEstudio().getFechaCreacion());
                estudioDTO.setFechaActualizacion(estudio.getEstudio().getFechaActualizacion());
                estudioDTO.setReferencia(referenciaDAO.getByEstudio(estudio.getEstudio().getEstudioId()));
                listEstudio.add(estudioDTO);
            });



        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        seccionEstudio.setSeccion(seccionRepository.findById(seccionId));
        if(!listEstudio.isEmpty()){
            seccionEstudio.setMetodo(seccionMetodoDAO.getMetodoBySeccion(listSeccionEstudio.get(0).getSeccion().getSeccionId()));
            seccionEstudio.setEstudio(listEstudio);
        }

        return seccionEstudio;
    }

    @Override
    @Transactional
    @Modifying
    public ResponseDTO deleteSeccionEstudio(Integer seccionId, Integer estudioId) {
        EntityManager em = emf.createEntityManager();

        ResponseDTO response = new ResponseDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaDelete<SeccionEstudioEntity> queryDelete = cb.createCriteriaDelete(SeccionEstudioEntity.class);

            Root<SeccionEstudioEntity> root = queryDelete.from(SeccionEstudioEntity.class);

            Predicate idSeccion = cb.equal(root.get("seccionId"), seccionId);
            Predicate idEstudio = cb.equal(root.get("estudioId"), estudioId);

            Predicate andPredicate = cb.and(idSeccion,idEstudio);
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
