package com.ziehlneelsen.laboratorio.daoImpl.estudio;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioSelectDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ReferenciaDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.SeccionEstudioDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.estudio.ReferenciaDAO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.estudio.Referencia;
import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEstudio;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEstudioEntity;
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
public class ReferenciaDAOImpl implements ReferenciaDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    private EntityManager em;

    @Override
    public List<ReferenciaDTO> getByEstudio(Integer idEstudio) {
        List<Referencia> listReferencia = new ArrayList<>();
        List<ReferenciaDTO> referencias = new ArrayList<>();

        em = emf.createEntityManager();

        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<Referencia> q = cb.createQuery(Referencia.class);

            Root<Referencia> c = q.from(Referencia.class);
            Fetch<Referencia,EstudioEntity> p = c.fetch("estudio");

            Predicate predicateEstudioId = cb.equal(c.get("estudio"),idEstudio);
            q.select(c).where(predicateEstudioId);
            listReferencia = em.createQuery(q).getResultList();
            listReferencia.forEach((referencia) -> {

                ReferenciaDTO referenciaDTO = new ReferenciaDTO();

                referenciaDTO.setClasificacion(referencia.getClasificacionPaciente());
                referenciaDTO.setReferenciaFemenino(referencia.getFemenino());
                referenciaDTO.setReferenciaMasculino(referencia.getMasculino());
                referenciaDTO.setReferenciaGeneral(referencia.getGeneral());
                referencias.add(referenciaDTO);
            });

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return referencias;
    }

    @Override
    @Transactional
    @Modifying
    public ResponseDTO actualizarComodin(Integer estudioId,Boolean estado) {
        ResponseDTO response = new ResponseDTO();
        em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaUpdate<EstudioEntity> update = cb.createCriteriaUpdate(EstudioEntity.class);

            Root updateComodin = update.from(EstudioEntity.class);

            Predicate examenId = cb.equal(updateComodin.get("estudioId"),estudioId);

            update.set("comodin", estado);

            update.where(examenId);

            em.getTransaction().begin();
            em.createQuery(update).executeUpdate();
            em.getTransaction().commit();

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
    public ResponseDTO actualizarSelectRespuesta(EstudioSelectDTO select) {
        ResponseDTO response = new ResponseDTO();
        em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaUpdate<EstudioEntity> update = cb.createCriteriaUpdate(EstudioEntity.class);

            Root updateComodin = update.from(EstudioEntity.class);

            Predicate examenId = cb.equal(updateComodin.get("estudioId"),select.getEstudioId());

            update.set("resultadoSelect", select.getResultadoSelect());

            update.where(examenId);

            em.getTransaction().begin();
            em.createQuery(update).executeUpdate();
            em.getTransaction().commit();

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
    public ResponseDTO actualizaNombreEstudio(Integer idEstudio, String nombre) {
        ResponseDTO response = new ResponseDTO();
        em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaUpdate<EstudioEntity> update = cb.createCriteriaUpdate(EstudioEntity.class);

            Root updateNombre = update.from(EstudioEntity.class);

            Predicate examenId = cb.equal(updateNombre.get("estudioId"),idEstudio);

            update.set("nombre", nombre);

            update.where(examenId);

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
