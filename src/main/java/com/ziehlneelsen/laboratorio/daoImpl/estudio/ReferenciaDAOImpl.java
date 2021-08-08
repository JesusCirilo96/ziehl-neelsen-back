package com.ziehlneelsen.laboratorio.daoImpl.estudio;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioSelectDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ReferenciaDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.estudio.ReferenciaDAO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.estudio.Referencia;
import com.ziehlneelsen.laboratorio.entities.estudio.ReferenciaEntity;
import com.ziehlneelsen.laboratorio.util.Utileria;
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
import java.util.UUID;

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
            q.select(c).where(predicateEstudioId).orderBy(cb.asc(c.get("orden")));

            listReferencia = em.createQuery(q).getResultList();
            listReferencia.forEach((referencia) -> {

                ReferenciaDTO referenciaDTO = new ReferenciaDTO();

                referenciaDTO.setClasificacion(referencia.getClasificacionPaciente());
                referenciaDTO.setReferenciaId(referencia.getReferenciaId());
                referenciaDTO.setReferenciaFemenino(referencia.getFemenino());
                referenciaDTO.setReferenciaMasculino(referencia.getMasculino());
                referenciaDTO.setReferenciaGeneral(referencia.getGeneral());
                referenciaDTO.setOrden(referencia.getOrden());
                referenciaDTO.setNota(referencia.getNota());
                referenciaDTO.setPrefijo(referencia.getPrefijo());
                referenciaDTO.setSufijo(referencia.getSufijo());


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
            update.set("fechaActualizacion", Utileria.fechaHoraActual());

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

    @Override
    public ResponseDTO eliminaReferencia(UUID referenciaId) {
        EntityManager em = emf.createEntityManager();

        ResponseDTO response = new ResponseDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaDelete<ReferenciaEntity> queryDelete = cb.createCriteriaDelete(ReferenciaEntity.class);

            Root<ReferenciaEntity> root = queryDelete.from(ReferenciaEntity.class);

            Predicate idReferencia = cb.equal(root.get("referenciaId"), referenciaId);

            queryDelete.where(idReferencia);

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
    public ResponseDTO actualizaReferencia(ReferenciaEntity referenciaDTO) {
        ResponseDTO response = new ResponseDTO();
        em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaUpdate<ReferenciaEntity> update = cb.createCriteriaUpdate(ReferenciaEntity.class);

            Root updateRef = update.from(ReferenciaEntity.class);

            Predicate referenciaId = cb.equal(updateRef.get("referenciaId"),referenciaDTO.getReferenciaId());

            update.set("clasificacionId", referenciaDTO.getClasificacionId());
            update.set("sufijo", referenciaDTO.getSufijo());
            update.set("prefijo", referenciaDTO.getPrefijo());
            update.set("masculino", referenciaDTO.getMasculino());
            update.set("femenino", referenciaDTO.getFemenino());
            update.set("general", referenciaDTO.getGeneral());
            update.set("orden", referenciaDTO.getOrden());
            update.set("nota", referenciaDTO.getNota());


            update.where(referenciaId);

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
