package com.ziehlneelsen.laboratorio.daoImpl.descuento;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.DescuentoDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.DescuentoExamenDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.ExamenDescuentoAuxDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.descuento.DescuentoExamenDAO;
import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.ExamenDescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralDescuento;
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
public class DescuentoExamenDAOImpl implements DescuentoExamenDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public DescuentoExamenDTO getDescuentoExamen(Integer descuentoId) {

        EntityManager em = emf.createEntityManager();
        List<ExamenGeneralDescuento> listDescuento;
        DescuentoExamenDTO descuentoExamen = new DescuentoExamenDTO();

        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<ExamenGeneralDescuento> query = cb.createQuery(ExamenGeneralDescuento.class);

            Root<ExamenGeneralDescuento> c = query.from(ExamenGeneralDescuento.class);
            Fetch<ExamenGeneralDescuento, ExamenGeneralEntity> p = c.fetch("descuento");

            Predicate idDescuento = cb.equal(c.get("descuento").get("descuentoId"), descuentoId);

            query.select(c).where(idDescuento);

            listDescuento = em.createQuery(query).getResultList();

            List<ExamenDescuentoAuxDTO> examenDescuentoAuxDTOList = new ArrayList<>();

            listDescuento.forEach((descuento) -> {
                ExamenDescuentoAuxDTO examenDescuentoAuxDTO = new ExamenDescuentoAuxDTO();
                examenDescuentoAuxDTO.setExamenDescuentoId(descuento.getExamenDescuentoId());
                examenDescuentoAuxDTO.setExamenId(descuento.getExamen().getExamenGeneralId());
                examenDescuentoAuxDTO.setNombreEstudio(descuento.getExamen().getNombre());
                examenDescuentoAuxDTO.setPorcentajeDescuento(descuento.getPorcentaje());
                examenDescuentoAuxDTO.setPorcentajeDescuentoText(descuento.getPorcentajeText());
                examenDescuentoAuxDTO.setDescuento(descuento.getDescuentoMonto());

                examenDescuentoAuxDTOList.add(examenDescuentoAuxDTO);
            });

            DescuentoDTO descuentoDTO = new DescuentoDTO();
            if(!listDescuento.isEmpty()){
                descuentoDTO.setDescuentoId(listDescuento.get(0).getDescuento().getDescuentoId());
                descuentoDTO.setNombre(listDescuento.get(0).getDescuento().getNombre());
                descuentoDTO.setDescripcion(listDescuento.get(0).getDescuento().getDescripcion());
                descuentoDTO.setFechaInicio(listDescuento.get(0).getDescuento().getFechaInicio());
                descuentoDTO.setFechaFin(listDescuento.get(0).getDescuento().getFechaFin());
                descuentoDTO.setDias(listDescuento.get(0).getDescuento().getDias());
            }

            descuentoExamen.setDescuento(descuentoDTO);
            if(!examenDescuentoAuxDTOList.isEmpty()){
                descuentoExamen.setExamen(examenDescuentoAuxDTOList);
            }

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return descuentoExamen;
    }

    @Override
    public ResponseDTO updateDescuento(DescuentoEntity descuento, Integer id) {

        ResponseDTO response = new ResponseDTO();
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaUpdate<DescuentoEntity> update = cb.createCriteriaUpdate(DescuentoEntity.class);

            Root updateComodin = update.from(DescuentoEntity.class);

            Predicate descuentoId = cb.equal(updateComodin.get("descuentoId"),id);

            update.set("nombre", descuento.getNombre());
            update.set("descripcion", descuento.getDescripcion());
            update.set("fechaInicio", descuento.getFechaInicio());
            update.set("fechaFin", descuento.getFechaFin());
            update.set("dias", descuento.getDias());
            update.set("estado", descuento.getEstado());
            update.set("fechaActualizacion", Utileria.fechaHoraActual());

            update.where(descuentoId);

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
    public ResponseDTO updateExamenDescuento(ExamenDescuentoEntity examenDescuentoEntity) {
        ResponseDTO response = new ResponseDTO();
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaUpdate<ExamenDescuentoEntity> update = cb.createCriteriaUpdate(ExamenDescuentoEntity.class);

            Root updateEntity = update.from(ExamenDescuentoEntity.class);

            /*Predicate idSeccion = cb.equal(updateOrden.get("seccionId"),seccionId);
            Predicate idExamen = cb.equal(updateOrden.get("examenId"),examenId);
            Predicate andPredicate = cb.and(idSeccion,idExamen);

            update.set("orden", orden);*/

            update.set("porcentajeDescuento", examenDescuentoEntity.getPorcentajeDescuento());
            update.set("porcentajeText", examenDescuentoEntity.getPorcentajeDescuento());
            update.set("descuento", examenDescuentoEntity.getDescuento());

            Predicate id = cb.equal(updateEntity.get("examenDescuentoId"),examenDescuentoEntity.getExamenDescuentoId());

            update.where(id);

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
    public ResponseDTO deleteExamenDescuento(Integer examenId, Integer descuentoId) {
        EntityManager em = emf.createEntityManager();

        ResponseDTO response = new ResponseDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaDelete<ExamenDescuentoEntity> queryDelete = cb.createCriteriaDelete(ExamenDescuentoEntity.class);

            Root<ExamenDescuentoEntity> root = queryDelete.from(ExamenDescuentoEntity.class);

            if(examenId == 0){
                Predicate idDescuento = cb.equal(root.get("descuentoId"), descuentoId);
                queryDelete.where(idDescuento);
            }else{
                Predicate idExamen = cb.equal(root.get("examenId"), examenId);
                Predicate idDescuento = cb.equal(root.get("descuentoId"), descuentoId);

                Predicate andPredicate = cb.and(idExamen,idDescuento);
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
    public ResponseDTO deleteDescuento(Integer descuentoId) {
        EntityManager em = emf.createEntityManager();

        ResponseDTO response = new ResponseDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaDelete<DescuentoEntity> queryDelete = cb.createCriteriaDelete(DescuentoEntity.class);

            Root<DescuentoEntity> root = queryDelete.from(DescuentoEntity.class);

            Predicate idDescuento = cb.equal(root.get("descuentoId"), descuentoId);

            queryDelete.where(idDescuento);

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
