package com.ziehlneelsen.laboratorio.service.descuento;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.descuento.DescuentoSaveDTO;
import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface DescuentoService {

    /**
     * Se buscan todos los descuentos con estado activo o inactivo
     * @return Todos los descuentos
     */
    List<DescuentoEntity> findAll();

    /**
     * Metodo para buscar solo los descuentos por ID
     * @param id El id del descuento
     * @return EL descuento
     */
    Optional<DescuentoEntity> findById(Integer id);

    /**
     * Metodo para determinar si el descuento aplica para el examen determinado
     * @param fechaI fecha en la que incia el descuento
     * @param fechaF fecha en la que termina el descuento
     * @param dias Dias en las que aplica el descuento
     * @return true en caso de aplicar el descuento false en caso de no aplicar
     * @throws ParseException Excepcion en caso de que no se puedan canvertir las fechas
     */
    Boolean aplicaDescuento(String fechaI, String fechaF, String dias) throws ParseException;

    /**
     * Se guarda en la base de datos el descuento
     * @param descuento El objeto descuento a guardar en BD
     * @return Objeto con la respuesta
     */
    ResponseDTO save(DescuentoEntity descuento);

    /**
     * Guarda la relacaion del descuento con los examenes
     * @return Respuesta del servicio
     */
    ResponseDTO saveExamenDescuento(DescuentoSaveDTO descuento);
}
