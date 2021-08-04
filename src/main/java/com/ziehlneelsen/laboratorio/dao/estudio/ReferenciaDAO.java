package com.ziehlneelsen.laboratorio.dao.estudio;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioSelectDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ReferenciaDTO;
import com.ziehlneelsen.laboratorio.entities.estudio.ReferenciaEntity;

import java.util.List;
import java.util.UUID;

public interface ReferenciaDAO {
    /**
     * obtenemos las referencias segun el estudio
     * @param estudio id del estudio a buscar
     * @return una lista de referencias dependiendo del estudio
     */
    List<ReferenciaDTO> getByEstudio(Integer estudio);

    /**
     * Actualizamos el campo si es comodin
     * @param estudioId El id del estudio
     * @param estado El estado a poner (true/false)
     * @return Respuesta del servicio
     */
    ResponseDTO actualizarComodin(Integer estudioId, Boolean estado);

    /**
     * Actualizamos la respuesta con menu seleccionable
     * @param select Objeto con el estudioId y el menu seleccionable
     * @return
     */
    ResponseDTO actualizarSelectRespuesta(EstudioSelectDTO select);

    /**
     * Actualiza el nombre del estudio
     * @param idEstudio el id del estudio a actualizar
     * @param nombre En nuevo nombre a colocar
     * @return Respuesta del servicio
     */
    ResponseDTO actualizaNombreEstudio(Integer idEstudio, String nombre);

    /**
     * Elimina la referencia vinculada al estudio
     * @param referenciaId El id de la referencia
     * @return Respuesta del servicio
     */
    ResponseDTO eliminaReferencia(UUID referenciaId);

    /**
     * Actauliamos la referencia
     * @param referenciaDTO Objeto con los datos a actualizar
     * @return Respuesta del servicio
     */
    ResponseDTO actualizaReferencia(ReferenciaEntity referenciaDTO);
}
