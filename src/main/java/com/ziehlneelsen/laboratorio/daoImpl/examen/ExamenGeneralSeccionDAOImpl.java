package com.ziehlneelsen.laboratorio.daoImpl.examen;

import java.util.ArrayList;
import java.util.List;

import com.ziehlneelsen.laboratorio.beans.estudio.EstudioDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.SeccionDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.SeccionEstudioDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UsuarioRolDTO;
import com.ziehlneelsen.laboratorio.dao.examen.ExamenGeneralSeccionDAO;
import com.ziehlneelsen.laboratorio.dao.seccion.SeccionEstudioDAO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralSeccion;
import com.ziehlneelsen.laboratorio.entities.persona.UsuarioRol;
import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEstudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;

@Service
public class ExamenGeneralSeccionDAOImpl implements ExamenGeneralSeccionDAO {

    @Autowired
    SeccionEstudioDAO seccionEstudioDAO;

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

            examenSeccion.setExamen(listExamenSeccion.get(0).getExamen());
            examenSeccion.setSeccion(listSeccionEstudio);

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return examenSeccion;
    }
}