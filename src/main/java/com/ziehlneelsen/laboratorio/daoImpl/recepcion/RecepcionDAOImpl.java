package com.ziehlneelsen.laboratorio.daoImpl.recepcion;

import com.ziehlneelsen.laboratorio.beans.recepcion.RecepcionResultadoDTO;
import com.ziehlneelsen.laboratorio.constant.Constantes;
import com.ziehlneelsen.laboratorio.dao.recepcion.RecepcionDAO;
import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionEntity;
import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.repository.persona.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecepcionDAOImpl implements RecepcionDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public Integer obtenerFicha() {
        EntityManager em = emf.createEntityManager();
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

        List<RecepcionExamenGeneralEntity> recepcionExamen = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
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

        EntityManager em = emf.createEntityManager();
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

            consulta.select(recepcion).where(predicateActualDate);

            recepcionList = em.createQuery(consulta).getResultList();

        }catch (DataAccessException e){
            throw e;
        }finally {
            em.close();
        }

        return recepcionList;
    }
}
