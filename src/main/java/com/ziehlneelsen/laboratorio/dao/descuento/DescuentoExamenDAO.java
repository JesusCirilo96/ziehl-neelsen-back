package com.ziehlneelsen.laboratorio.dao.descuento;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.DescuentoExamenDTO;
import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.ExamenDescuentoEntity;

public interface DescuentoExamenDAO {

    /**
     * Se obtienen los examenes por el ID de descuento
     * @param descuentoId El id del descuento
     * @return objeto con el descuento y la lista de examenes relacionados
     */
    DescuentoExamenDTO getDescuentoExamen(Integer descuentoId);

    /**
     * Actualizar el descuento
     * @param descuento objeto con datos del descuento
     * @return Respuesta del servicio
     */
    ResponseDTO updateDescuento(DescuentoEntity descuento, Integer id);

    /**
     * Actualizamos el examen descuento
     * @param examenDescuentoEntity El objeto con los datos del examen descuento
     * @return Respuesta del servicio
     */
    ResponseDTO updateExamenDescuento(ExamenDescuentoEntity examenDescuentoEntity);

    /**
     * Eliminar el descuento
     * @param descuentoId El id del descuento
     * @return Respuesta del servicio
     */
    ResponseDTO deleteDescuento(Integer descuentoId);

    /**
     * Eliminar realacion del descuento con el examen
     * @param examenId El id del examen
     * @param descuentoId
     * @return
     */
    ResponseDTO deleteExamenDescuento(Integer examenId, Integer descuentoId);
}
