package com.ziehlneelsen.laboratorio.daoImpl.seccion;

import com.ziehlneelsen.laboratorio.beans.estudio.EstudioDTO;
import com.ziehlneelsen.laboratorio.beans.persona.UsuarioRolDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.SeccionDTO;
import com.ziehlneelsen.laboratorio.beans.seccion.SeccionEstudioDTO;
import com.ziehlneelsen.laboratorio.dao.seccion.SeccionEstudioDAO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.persona.UsuarioRol;
import com.ziehlneelsen.laboratorio.entities.rol.RolEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEstudio;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeccionEstudioDAOImpl implements SeccionEstudioDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public SeccionEstudioDTO getEstudioSeccion(Integer seccionId) {
        EntityManager em = emf.createEntityManager();
        List<SeccionEstudio> listSeccionEstudio = new ArrayList<>();
        List<EstudioDTO> listEstudio = new ArrayList<>();

        SeccionEstudioDTO seccionEstudio = new SeccionEstudioDTO();
        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<SeccionEstudio> query = cb.createQuery(SeccionEstudio.class);

            Root<SeccionEstudio> c = query.from(SeccionEstudio.class);
            Fetch<SeccionEstudio, EstudioEntity> p = c.fetch("seccion");

            Predicate idSeccion = cb.equal(c.get("seccion").get("seccionId"), seccionId);

            query.select(c).where(idSeccion);

            listSeccionEstudio = em.createQuery(query).getResultList();
            listSeccionEstudio.forEach((estudio) -> {

                EstudioDTO estudioDTO = new EstudioDTO();
                estudioDTO.setEstudioId(estudio.getEstudio().getEstudioId());
                estudioDTO.setNombre(estudio.getEstudio().getNombre());
                estudioDTO.setEstado(estudio.getEstudio().getEstado());
                estudioDTO.setOrden(estudio.getOrden());
                estudioDTO.setFechaCreacion(estudio.getEstudio().getFechaCreacion());
                estudioDTO.setFechaActualizacion(estudio.getEstudio().getFechaActualizacion());

                listEstudio.add(estudioDTO);
            });

            seccionEstudio.setSeccion(listSeccionEstudio.get(0).getSeccion());
            seccionEstudio.setEstudio(listEstudio);

        }catch (DataAccessException e){
            e.printStackTrace();
        }finally {
            em.close();
        }

        return seccionEstudio;
    }
}