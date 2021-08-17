package com.ziehlneelsen.laboratorio.daoImpl.persona;

import com.ziehlneelsen.laboratorio.dao.persona.PacienteDAO;
import com.ziehlneelsen.laboratorio.entities.persona.PacienteEntity;
import com.ziehlneelsen.laboratorio.entities.persona.UsuarioEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class PacienteDAOImpl implements PacienteDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorio");

    @Override
    public String obtenerNombrePaciente(Integer pacienteid) {
        EntityManager em = emf.createEntityManager();
        PacienteEntity pacienteEntity;
        String nombrePaciente = null;
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaQuery<PacienteEntity> consulta = cb.createQuery(PacienteEntity.class);
            Root<PacienteEntity> paciente = consulta.from(PacienteEntity.class);

            Predicate predicateActualDate = cb.equal(paciente.get("pacienteId"),pacienteid);

            consulta.select(paciente).where(predicateActualDate);

            pacienteEntity = em.createQuery(consulta).getSingleResult();

            if(pacienteEntity != null){
                nombrePaciente = (pacienteEntity.getNombre() + " " + pacienteEntity.getApellidoPaterno() + " " +  pacienteEntity.getApellidoMaterno());
            }

        }catch (DataAccessException e){
            throw e;
        }finally {
            em.close();
        }

        return nombrePaciente;
    }

    @Override
    public String obtenerNombreUsuario(Integer usuarioId) {
        EntityManager em = emf.createEntityManager();
        UsuarioEntity pacienteEntity;
        String nombreUsuario = null;
        try {
            CriteriaBuilder cb = emf.getCriteriaBuilder();

            CriteriaQuery<UsuarioEntity> consulta = cb.createQuery(UsuarioEntity.class);
            Root<UsuarioEntity> paciente = consulta.from(UsuarioEntity.class);

            Predicate usuario = cb.equal(paciente.get("usuarioId"),usuarioId);

            consulta.select(paciente).where(usuario);

            pacienteEntity = em.createQuery(consulta).getSingleResult();

            if(pacienteEntity != null){
                nombreUsuario = (pacienteEntity.getNombre() + " " + pacienteEntity.getApellidoPaterno() + " " +  pacienteEntity.getApellidoMaterno());
            }

        }catch (DataAccessException e){
            throw e;
        }finally {
            em.close();
        }

        return nombreUsuario;
    }
}
