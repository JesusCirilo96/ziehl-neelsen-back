package com.ziehlneelsen.laboratorio.daoImpl.descuento;

import com.ziehlneelsen.laboratorio.beans.descuento.DescuentoDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.DescuentoExamenDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.ExamenDescuentoAuxDTO;
import com.ziehlneelsen.laboratorio.dao.descuento.DescuentoExamenDAO;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralDescuento;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
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
            Fetch<ExamenGeneralDescuento, ExamenGeneralEntity> p = c.fetch("examen");

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
            descuentoDTO.setDescuentoId(listDescuento.get(0).getDescuento().getDescuentoId());
            descuentoDTO.setNombre(listDescuento.get(0).getDescuento().getNombre());
            descuentoDTO.setDescripcion(listDescuento.get(0).getDescuento().getDescripcion());
            descuentoDTO.setFechaInicio(listDescuento.get(0).getDescuento().getFechaInicio());
            descuentoDTO.setFechaFin(listDescuento.get(0).getDescuento().getFechaFin());
            descuentoDTO.setDias(listDescuento.get(0).getDescuento().getDias());

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
}
