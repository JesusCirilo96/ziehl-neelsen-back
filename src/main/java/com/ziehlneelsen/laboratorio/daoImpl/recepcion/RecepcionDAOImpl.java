package com.ziehlneelsen.laboratorio.daoImpl.recepcion;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ReferenciaDTO;
import com.ziehlneelsen.laboratorio.beans.recepcion.HistorialAuxDTO;
import com.ziehlneelsen.laboratorio.beans.recepcion.HistorialDTO;
import com.ziehlneelsen.laboratorio.constant.Constantes;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.recepcion.RecepcionDAO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.estudio.Referencia;
import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionEntity;
import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.repository.persona.PacienteRepository;
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
public class RecepcionDAOImpl implements RecepcionDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    private EntityManager em;

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public Integer obtenerFicha() {
        em = emf.createEntityManager();
        int max = 0;
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaQuery<Integer> consulta = cb.createQuery(Integer.class);
            Root<RecepcionEntity> recepcion = consulta.from(RecepcionEntity.class);

            Predicate predicateActualDate = cb.equal(recepcion.get("fechaIngreso"),cb.currentDate());

            consulta.select(cb.max(recepcion.get("ficha"))).where(predicateActualDate);

            Integer ultimo = em.createQuery(consulta).getSingleResult();
            if(ultimo == null){
                max = 1;
            }else{
                max = ultimo + 1;
            }
        }catch (DataAccessException e){
            throw e;
        }finally {
            em.close();
        }

        return max;
    }

    @Override
    public List<RecepcionExamenGeneralEntity> obtenerResultados(String idRecepcion) {

        List<RecepcionExamenGeneralEntity> recepcionExamen;

        em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaQuery<RecepcionExamenGeneralEntity> consulta = cb.createQuery(RecepcionExamenGeneralEntity.class);
            Root<RecepcionExamenGeneralEntity> recepcion = consulta.from(RecepcionExamenGeneralEntity.class);
            Predicate predicateActualDate = cb.equal(recepcion.get("recepcionId"),idRecepcion);

            consulta.select(recepcion).where(predicateActualDate);

            recepcionExamen = em.createQuery(consulta).getResultList();

        }catch (DataAccessException e){
            throw e;
        }finally {
            em.close();
        }

        return recepcionExamen;
    }

    @Override
    public List<RecepcionEntity> obtenerRecepcion(String where, String equal) {

        List<RecepcionEntity> recepcionList;

        System.out.println("WHERE:: " + where + " Igual A:: " + equal);

        em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaQuery<RecepcionEntity> consulta = cb.createQuery(RecepcionEntity.class);
            Root<RecepcionEntity> recepcion = consulta.from(RecepcionEntity.class);
            Predicate predicateActualDate;
            switch (where){
                case Constantes.FECHA:
                        predicateActualDate = cb.equal(recepcion.get("fechaIngreso"),equal);
                    break;

                case Constantes.ID_RECEPCION:
                        predicateActualDate = cb.equal(recepcion.get("recepcionId"),equal);
                    break;
                default:
                    throw new IllegalStateException("Valor inesperado: " + where);
            }

            consulta.select(recepcion).where(predicateActualDate).orderBy(cb.desc(recepcion.get("ficha")));

            recepcionList = em.createQuery(consulta).getResultList();

        }catch (DataAccessException e){
            throw e;
        }finally {
            em.close();
        }

        return recepcionList;
    }

    @Override
    @Transactional
    @Modifying
    public ResponseDTO saveResultado(RecepcionExamenGeneralEntity resultado) {
        ResponseDTO response = new ResponseDTO();

        em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaUpdate<RecepcionExamenGeneralEntity> update = cb.createCriteriaUpdate(RecepcionExamenGeneralEntity.class);

            Root saveResult = update.from(RecepcionExamenGeneralEntity.class);

            Predicate examenId = cb.equal(saveResult.get("examenId"),resultado.getExamenId());
            Predicate recepcionId = cb.equal(saveResult.get("recepcionId"),resultado.getRecepcionId());
            Predicate clausula = cb.and(examenId,recepcionId);

            update.set("resultado", resultado.getResultado());

            update.where(clausula);

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
    public HistorialDTO obtenerHistorial(Integer pacienteId) {
        HistorialDTO historial = new HistorialDTO();

        List<RecepcionEntity> listRecepcion = new ArrayList<>();
        List<HistorialAuxDTO> historialAuxDTOS = new ArrayList<>();

        em = emf.createEntityManager();

        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<RecepcionEntity> q = cb.createQuery(RecepcionEntity.class);

            Root<RecepcionEntity> c = q.from(RecepcionEntity.class);

            Predicate idPaciente = cb.equal(c.get("pacienteId"),pacienteId);
            q.select(c).where(idPaciente).orderBy(cb.desc(c.get("fechaIngreso")));

            listRecepcion = em.createQuery(q).getResultList();
            listRecepcion.forEach((recepcion) -> {

                HistorialAuxDTO historia = new HistorialAuxDTO();

                historia.setRecepcionId(recepcion.getRecepcionId());
                historia.setFolio(recepcion.getFicha());
                historia.setFechaIngreso(recepcion.getFechaIngreso());
                historia.setHoraIngreso(recepcion.getHoraIngreso());

                historialAuxDTOS.add(historia);
            });

            historial.setHistorial(historialAuxDTOS);
            historial.setPaciente(pacienteRepository.findById(pacienteId));

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return historial;

    }

    @Override
    @Transactional
    @Modifying
    public ResponseDTO updateBanderas(String recepcionId, String opcion, Boolean valor) {
        ResponseDTO response = new ResponseDTO();

        em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaUpdate<RecepcionEntity> update = cb.createCriteriaUpdate(RecepcionEntity.class);

            Root saveResult = update.from(RecepcionEntity.class);

            Predicate idRecepcion = cb.equal(saveResult.get("recepcionId"),recepcionId);

            switch (opcion) {
                case "finalizado":
                    update.set("finalizado", valor);
                    break;
                case "impreso":
                    update.set("impreso", valor);
                    break;
                case "entregado":
                    update.set("entregado", valor);
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

            update.where(idRecepcion);

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
