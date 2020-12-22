package com.ziehlneelsen.laboratorio.daoImpl.examen;

import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.SeccionEstudioDTO;
import com.ziehlneelsen.laboratorio.dao.examen.ExamenGeneralSeccionDAO;
import com.ziehlneelsen.laboratorio.dao.seccion.SeccionEstudioDAO;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralSeccion;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;
import com.ziehlneelsen.laboratorio.repository.examen.ExamenGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExamenGeneralSeccionDAOImpl implements ExamenGeneralSeccionDAO {

    @Autowired
    SeccionEstudioDAO seccionEstudioDAO;

    @Autowired
    ExamenGeneralRepository examenGeneralRepository;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public ExamenSeccionDTO getExamenSeccion(Integer examenId){

        EntityManager em = emf.createEntityManager();
        List<ExamenGeneralSeccion> listExamenSeccion = new ArrayList<>();
        List<SeccionEstudioDTO> listSeccionEstudio = new ArrayList<>();

        ExamenSeccionDTO examenSeccion = new ExamenSeccionDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<ExamenGeneralSeccion> query = cb.createQuery(ExamenGeneralSeccion.class);

            Root<ExamenGeneralSeccion> c = query.from(ExamenGeneralSeccion.class);
            Fetch<ExamenGeneralSeccion, SeccionEntity> p = c.fetch("seccion");

            Predicate idExamen = cb.equal(c.get("examen").get("examenGeneralId"), examenId);

            query.select(c).where(idExamen);

            listExamenSeccion = em.createQuery(query).getResultList();
            listExamenSeccion.forEach((seccion) -> {
                SeccionEstudioDTO seccionEstudio = seccionEstudioDAO.getEstudioSeccion(seccion.getSeccion().getSeccionId());

                listSeccionEstudio.add(seccionEstudio);
            });

            examenSeccion.setExamen(examenGeneralRepository.findById(examenId));
            examenSeccion.setSeccion(listSeccionEstudio);

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return examenSeccion;
    }
}
