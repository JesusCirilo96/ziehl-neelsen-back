package com.ziehlneelsen.laboratorio.daoImpl.examen;

import com.ziehlneelsen.laboratorio.beans.ExamenDescuentoDTO;
import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.DescuentoDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioSelectAuxDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenMetodoAux;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.estudio.ReferenciaDAO;
import com.ziehlneelsen.laboratorio.dao.examen.ExamenGeneralDAO;
import com.ziehlneelsen.laboratorio.dao.metodo.SeccionMetodoDAO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenEstudio;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenEstudioEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralDescuento;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.service.descuento.DescuentoService;
import org.json.JSONArray;
import org.json.JSONObject;
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

    @Autowired
    ReferenciaDAO referenciaDAO;

    @Autowired
    SeccionMetodoDAO seccionMetodoDAO;

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
    public List<EstudioDTO> findEstudioByExamen(Integer examenId) {
        EntityManager em = emf.createEntityManager();
        List<ExamenEstudio> listEstudio;
        List<EstudioDTO> estudios = new ArrayList<>();

        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<ExamenEstudio> query = cb.createQuery(ExamenEstudio.class);

            Root<ExamenEstudio> c = query.from(ExamenEstudio.class);
            Fetch<ExamenEstudio, EstudioEntity> p = c.fetch("examen");

            Predicate idExamen = cb.equal(c.get("examen").get("examenGeneralId"), examenId);
            query.select(c).where(idExamen).orderBy(cb.asc(c.get("orden")));


            listEstudio = em.createQuery(query).getResultList();


            listEstudio.forEach((estudio) -> {
                EstudioDTO estudioDTO = new EstudioDTO();
                estudioDTO.setEstudioId(estudio.getEstudio().getEstudioId());
                estudioDTO.setNombre(estudio.getEstudio().getNombre());
                estudioDTO.setEstado(estudio.getEstudio().getEstado());
                estudioDTO.setOrden(estudio.getOrden());
                estudioDTO.setFechaCreacion(estudio.getEstudio().getFechaCreacion());
                estudioDTO.setFechaActualizacion(estudio.getEstudio().getFechaActualizacion());
                estudioDTO.setReferencia(referenciaDAO.getByEstudio(estudio.getEstudio().getEstudioId()));
                estudioDTO.setMetodo(seccionMetodoDAO.getMetodoByEstudio(estudio.getEstudio().getEstudioId()));
                estudioDTO.setMostrarInput(estudio.getEstudio().getMostrarInput());
                if(estudio.getEstudio().getResultadoSelect() != null){
                    ArrayList<EstudioSelectAuxDTO> respuestas = new ArrayList<>();
                    JSONArray jsonArr = new JSONArray(estudio.getEstudio().getResultadoSelect());
                    for(int i = 0 ; i < jsonArr.length(); i++){
                        EstudioSelectAuxDTO resp = new EstudioSelectAuxDTO();
                        JSONObject object = jsonArr.getJSONObject(i);
                        resp.setValue(object.getString("value"));
                        resp.setViewValue(object.getString("viewValue"));
                        respuestas.add(resp);
                    }
                    estudioDTO.setResultadoSelect(respuestas);
                }
                estudios.add(estudioDTO);
            });

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return estudios;
    }

    @Override
    public List<EstudioDTO> findEstudioByExamenReferencia(Integer examenId) {
        EntityManager em = emf.createEntityManager();
        List<ExamenEstudio> listEstudio;
        List<EstudioDTO> estudios = new ArrayList<>();

        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<ExamenEstudio> query = cb.createQuery(ExamenEstudio.class);

            Root<ExamenEstudio> c = query.from(ExamenEstudio.class);
            Fetch<ExamenEstudio, EstudioEntity> p = c.fetch("examen");

            Predicate idExamen = cb.equal(c.get("examen").get("examenGeneralId"), examenId);

            query.select(c).where(idExamen).orderBy(cb.asc(c.get("orden")));

            listEstudio = em.createQuery(query).getResultList();

            listEstudio.forEach((estudio) -> {
                EstudioDTO estudioDTO = new EstudioDTO();
                estudioDTO.setEstudioId(estudio.getEstudio().getEstudioId());
                estudioDTO.setNombre(estudio.getEstudio().getNombre());
                estudioDTO.setEstado(estudio.getEstudio().getEstado());
                estudioDTO.setOrden(estudio.getOrden());
                estudioDTO.setFechaCreacion(estudio.getEstudio().getFechaCreacion());
                estudioDTO.setFechaActualizacion(estudio.getEstudio().getFechaActualizacion());
                estudioDTO.setReferencia(referenciaDAO.getByEstudio(estudio.getEstudio().getEstudioId()));
                estudioDTO.setMetodo(seccionMetodoDAO.getMetodoByEstudio(estudio.getEstudio().getEstudioId()));
                estudioDTO.setMostrarInput(estudio.getEstudio().getMostrarInput());
                if(estudio.getEstudio().getResultadoSelect() != null){
                    ArrayList<EstudioSelectAuxDTO> respuestas = new ArrayList<>();
                    JSONArray jsonArr = new JSONArray(estudio.getEstudio().getResultadoSelect());
                    for(int i = 0 ; i < jsonArr.length(); i++){
                        EstudioSelectAuxDTO resp = new EstudioSelectAuxDTO();
                        JSONObject object = jsonArr.getJSONObject(i);
                        resp.setValue(object.getString("value"));
                        resp.setViewValue(object.getString("viewValue"));
                        respuestas.add(resp);
                    }
                    estudioDTO.setResultadoSelect(respuestas);
                }
                estudios.add(estudioDTO);
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
        List<DescuentoDTO> descuentos = new ArrayList<>();

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
                    if(descuentoService.aplicaDescuento(descuento.getDescuento().getFechaInicio(),descuento.getDescuento().getFechaFin(),descuento.getDescuento().getDias())){
                        DescuentoDTO descuentoDTO = new DescuentoDTO();
                        descuentoDTO.setDescuentoId(descuento.getDescuento().getDescuentoId());
                        descuentoDTO.setNombre(descuento.getDescuento().getNombre());
                        descuentoDTO.setDescripcion((descuento.getDescuento().getDescripcion()));
                        descuentoDTO.setFechaInicio(descuento.getDescuento().getFechaInicio());
                        descuentoDTO.setFechaFin(descuento.getDescuento().getFechaFin());
                        descuentoDTO.setDias(descuento.getDescuento().getDias());
                        descuentoDTO.setPorcentaje(descuento.getPorcentaje());
                        descuentoDTO.setPorcentajeText(descuento.getPorcentajeText());
                        descuentoDTO.setDescuentoMonto(descuento.getDescuentoMonto());

                        descuentos.add(descuentoDTO);
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

    @Override
    @Transactional
    @Modifying
    public ResponseDTO updateMetodo(ExamenMetodoAux examen) {
        ResponseDTO response = new ResponseDTO();
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaUpdate<ExamenGeneralEntity> update = cb.createCriteriaUpdate(ExamenGeneralEntity.class);

            Root updateComodin = update.from(ExamenGeneralEntity.class);

            Predicate examenId = cb.equal(updateComodin.get("examenGeneralId"),examen.getExamenId());

            update.set("metodo", examen.getMetodo());

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
}
