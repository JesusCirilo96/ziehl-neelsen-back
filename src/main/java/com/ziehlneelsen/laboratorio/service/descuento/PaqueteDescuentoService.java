package com.ziehlneelsen.laboratorio.service.descuento;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.PaqueteDescuentoDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.PaqueteSaveDTO;
import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.PaqueteDescuentoEntity;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface PaqueteDescuentoService {

    /**
     * Busca todos los paquetes de descuentos
     * @return Lista con los paquetes de descuentos
     */
    List<PaqueteDescuentoEntity> findAll();

    /**
     * Busca el paquete de descuento por ID
     * @param id El ID del paquete
     * @return El objeto con los datos del paquete de descuento
     */
    Optional<PaqueteDescuentoEntity> findById(Integer id);

    /**
     * Guardamos el paquete de descuento
     * @param paquete El objeto del paquete de descuento
     * @return Respuesta obtenida
     */
    ResponseDTO save(PaqueteDescuentoEntity paquete);

    /**
     * @param paqueteId El id del paquete a buscar
     * @return El paquete con los examenes relacionados
     */
    PaqueteDescuentoDTO findExamenByPaquete(Integer paqueteId);

    /**
     * Buscamos la lista de paquetes con sus examenes relacionados y si aplican al dia actual
     * @return La lista de paquetes con los descuentos del dia
     */
    List<PaqueteDescuentoDTO> findAllPaqueteByDia() throws ParseException;

    /**
     * Se guardan el paquete y su examen seleccionado.
     * @param paquete Objeto con los datos del paquete y sus examenes relacionados
     * @return Respuesta del servicio
     */
    ResponseDTO savePaqueteExamen(PaqueteSaveDTO paquete);

    /**
     * Eliminar el paquete y sus examenes relacionados
     * @param paqueteId El id del paquete
     * @return Respuesta del servicio
     */
    ResponseDTO deletePaquete(Integer paqueteId);


}
