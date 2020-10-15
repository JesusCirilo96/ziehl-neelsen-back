package com.ziehlneelsen.laboratorio.dao.descuento;

import com.ziehlneelsen.laboratorio.beans.descuento.PaqueteDescuentoDTO;
import com.ziehlneelsen.laboratorio.entities.descuento.PaqueteDescuentoEntity;

import java.util.List;

public interface PaqueteDescuentoDAO {

    /**
     * Buscar los examenes relacionados con el paquete de descuento
     * @param paqueteId ID del paquete
     * @return Objeto con el paquete y la lista de examenes
     */
    public PaqueteDescuentoDTO findExamenByPaquete(Integer paqueteId);

    /**
     * Buscamos todos los paquetes con un estado activo
     * @return
     */
    public List<PaqueteDescuentoEntity> findAllPaquete();

}
