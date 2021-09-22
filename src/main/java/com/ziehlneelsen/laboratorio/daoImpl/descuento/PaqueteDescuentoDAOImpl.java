package com.ziehlneelsen.laboratorio.daoImpl.descuento;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.PaqueteDescuentoDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.descuento.PaqueteDescuentoDAO;
import com.ziehlneelsen.laboratorio.entities.descuento.*;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.util.Utileria;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaqueteDescuentoDAOImpl implements PaqueteDescuentoDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public PaqueteDescuentoDTO findExamenByPaquete(Integer paqueteId) {
        EntityManager em = emf.createEntityManager();
        List<PaqueteDescuentoExamen> listPaquete = new ArrayList<>();
        List<ExamenGeneralEntity> examenes = new ArrayList<>();

        PaqueteDescuentoDTO paqueteDescuento = new PaqueteDescuentoDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<PaqueteDescuentoExamen> query = cb.createQuery(PaqueteDescuentoExamen.class);

            Root<PaqueteDescuentoExamen> c = query.from(PaqueteDescuentoExamen.class);
            Fetch<PaqueteDescuentoExamen, PaqueteDescuentoEntity> p = c.fetch("paquete");

            Predicate idPaquete = cb.equal(c.get("paquete").get("paqueteId"), paqueteId);

            query.select(c).where(idPaquete);

            listPaquete = em.createQuery(query).getResultList();
            listPaquete.forEach((paquete) -> {
                examenes.add(paquete.getExamen());
            });

            paqueteDescuento.setPaquete(listPaquete.get(0).getPaquete());
            paqueteDescuento.setExamen(examenes);


        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return paqueteDescuento;
    }

    @Override
    public List<PaqueteDescuentoEntity> findAllPaquete() {
        EntityManager em = emf.createEntityManager();
        List<PaqueteDescuentoEntity> listPaqueteDescuento = new ArrayList<>();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<PaqueteDescuentoEntity> query = cb.createQuery(PaqueteDescuentoEntity.class);

            Root<PaqueteDescuentoEntity> c = query.from(PaqueteDescuentoEntity.class);

            Predicate estado = cb.equal(c.get("estado"),1);
            query.select(c).where(estado);

            listPaqueteDescuento = em.createQuery(query).getResultList();


        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return listPaqueteDescuento;
    }

    @Override
    public ResponseDTO updatePaquete(PaqueteDescuentoEntity paquete, Integer id) {

        ResponseDTO response = new ResponseDTO();
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaUpdate<PaqueteDescuentoEntity> update = cb.createCriteriaUpdate(PaqueteDescuentoEntity.class);

            Root updateComodin = update.from(PaqueteDescuentoEntity.class);

            Predicate paqueteId = cb.equal(updateComodin.get("paqueteId"),id);

            update.set("nombre", paquete.getNombre());
            update.set("descripcion", paquete.getDescripcion());
            update.set("fechaInicio", paquete.getFechaInicio());
            update.set("fechaFin", paquete.getFechaFin());
            update.set("dias", paquete.getDias());
            update.set("precio", paquete.getPrecio());
            update.set("porcentaje", paquete.getPorcentaje());
            update.set("porcentajeDescuentoTexto", paquete.getPorcentajeDescuentoTexto());
            update.set("descuento", paquete.getDescuento());
            update.set("estado", paquete.getEstado());
            update.set("fechaActualizacion", Utileria.fechaHoraActual());


            update.where(paqueteId);

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
    public ResponseDTO deleteExamenPaquete(Integer examenId, Integer paqueteId) {
        EntityManager em = emf.createEntityManager();

        ResponseDTO response = new ResponseDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaDelete<PaqueteExamenEntity> queryDelete = cb.createCriteriaDelete(PaqueteExamenEntity.class);

            Root<PaqueteExamenEntity> root = queryDelete.from(PaqueteExamenEntity.class);

            if(examenId == 0){
                Predicate idPaquete = cb.equal(root.get("paqueteId"), paqueteId);
                queryDelete.where(idPaquete);
            }else{
                Predicate idExamen = cb.equal(root.get("examenId"), examenId);
                Predicate idPaquete = cb.equal(root.get("paqueteId"), paqueteId);

                Predicate andPredicate = cb.and(idExamen,idPaquete);
                queryDelete.where(andPredicate);
            }



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
    public ResponseDTO deletePaquete(Integer paqueteId) {
        EntityManager em = emf.createEntityManager();

        ResponseDTO response = new ResponseDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaDelete<PaqueteDescuentoEntity> queryDelete = cb.createCriteriaDelete(PaqueteDescuentoEntity.class);

            Root<PaqueteDescuentoEntity> root = queryDelete.from(PaqueteDescuentoEntity.class);

            Predicate idPaquete = cb.equal(root.get("paqueteId"), paqueteId);

            queryDelete.where(idPaquete);

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
