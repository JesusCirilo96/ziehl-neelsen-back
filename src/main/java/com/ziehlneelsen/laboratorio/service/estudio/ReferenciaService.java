package com.ziehlneelsen.laboratorio.service.estudio;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ReferenciaDTO;
import com.ziehlneelsen.laboratorio.entities.estudio.ReferenciaEntity;

import java.util.List;
import java.util.UUID;

public interface ReferenciaService {

    /**
     * Obtenemos la lista de referencias
     * @return Lista con las referencias
     */
    List<ReferenciaEntity> findAll();

    /**
     * Obtener las referencias del estudio
     * @param idEstudio El id del estudio a obtener
     * @return Lista con las referencias del estudio
     */
    List<ReferenciaDTO> findByEstudio(Integer idEstudio);

    /**
     * Guardar una referencia
     * @param referencia La entidad de referencia
     * @return Respuesta del service
     */
    ResponseDTO save(ReferenciaEntity referencia);

    /**
     * Elimina la referencia vinculada al estudio
     * @param referenciaId la referencia a elimina
     * @return Respuesta del servicio
     */
    ResponseDTO deleteReferencia(UUID referenciaId);

    /**
     * Actualizamos la referencia
     * @param referencia Objeto con los datos de la referencia
     * @return Respuesta del servicio
     */
    ResponseDTO updateReferencia(ReferenciaEntity referencia);
}
