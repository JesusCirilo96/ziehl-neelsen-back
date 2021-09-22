package com.ziehlneelsen.laboratorio.dao.descuento;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.PaqueteDescuentoDTO;
import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.ExamenDescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.PaqueteDescuentoEntity;

import java.util.List;

public interface PaqueteDescuentoDAO {

    /**
     * Buscar los examenes relacionados con el paquete de descuento
     * @param paqueteId ID del paquete
     * @return Objeto con el paquete y la lista de examenes
     */
    PaqueteDescuentoDTO findExamenByPaquete(Integer paqueteId);

    /**
     * Buscamos todos los paquetes con un estado activo
     * @return
     */
    List<PaqueteDescuentoEntity> findAllPaquete();

    /**
     * Actuializa el paquete
     * @param paquete El objeto de paquete
     * @param id El id del paquete
     * @return Respuesta del servicio
     */
    ResponseDTO updatePaquete(PaqueteDescuentoEntity paquete, Integer id);

    /**
     * Se eliminan el paquete y los examenes relacionados
     * @param examenId El id del examen
     * @param paqueteId El id del paquete
     * @return
     */
    ResponseDTO deleteExamenPaquete(Integer examenId, Integer paqueteId);

    /**
     * Elimina el paquete
     * @param paqueteId El id del paquete
     * @return Respuesta del servicio
     */
    ResponseDTO deletePaquete(Integer paqueteId);

}
