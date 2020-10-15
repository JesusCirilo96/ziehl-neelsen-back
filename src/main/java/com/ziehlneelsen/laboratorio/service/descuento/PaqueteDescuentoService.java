package com.ziehlneelsen.laboratorio.service.descuento;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.PaqueteDescuentoDTO;
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
    public List<PaqueteDescuentoEntity> findAll();

    /**
     * Busca el paquete de descuento por ID
     * @param id El ID del paquete
     * @return El objeto con los datos del paquete de descuento
     */
    public Optional<PaqueteDescuentoEntity> findById(Integer id);

    /**
     * Guardamos el paquete de descuento
     * @param paquete El objeto del paquete de descuento
     * @return Respuesta obtenida
     */
    public ResponseDTO save(PaqueteDescuentoEntity paquete);

    /**
     * @param paqueteId El id del paquete a buscar
     * @return El paquete con los examenes relacionados
     */
    public PaqueteDescuentoDTO findExamenByPaquete(Integer paqueteId);

    /**
     * Buscamos la lista de paquetes con sus examenes relacionados y si aplican al dia actual
     * @return La lista de paquetes con los descuentos del dia
     */
    public List<PaqueteDescuentoDTO> findAllPaqueteByDia() throws ParseException;
}
