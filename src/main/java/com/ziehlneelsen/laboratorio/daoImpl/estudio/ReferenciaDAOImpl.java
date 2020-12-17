package com.ziehlneelsen.laboratorio.daoImpl.estudio;

import com.ziehlneelsen.laboratorio.beans.examen.ReferenciaDTO;
import com.ziehlneelsen.laboratorio.dao.estudio.ReferenciaDAO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.estudio.Referencia;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReferenciaDAOImpl implements ReferenciaDAO {

    @Override
    public List<ReferenciaDTO> getByEstudio(Integer idEstudio) {
        List<Referencia> listReferencia = new ArrayList<>();

        List<ReferenciaDTO> referencias = new ArrayList<>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");
        EntityManager em = emf.createEntityManager();

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
}
