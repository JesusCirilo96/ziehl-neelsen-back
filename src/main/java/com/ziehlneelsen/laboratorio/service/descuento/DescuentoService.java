package com.ziehlneelsen.laboratorio.service.descuento;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.descuento.DescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.descuento.DiaDescuento;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface DescuentoService {

    /**
     * Se buscan todos los descuentos con estado activo o inactivo
     * @return Todos los descuentos
     */
    public List<DescuentoEntity> findAll();

    /**
     * Metodo para buscar solo los descuentos por ID
     * @param id El id del descuento
     * @return EL descuento
     */
    public Optional<DescuentoEntity> findById(Integer id);

    /**
     * Metodo para buscar los descuentos con los dias en las que aplica
     * @param descuentoId El identificador del descuento
     * @return La lista de descuentos con los dias en las que aplica
     * @throws ParseException Se lanza una excepcion en caso de error al parsear las fechas
     */
    public List<DiaDescuento> findByDescuento(Integer descuentoId) throws ParseException;

    /**
     * Metodo para determinar si el descuento aplica para el examen determinado
     * @param descuentoId El id del descuento
     * @return true en caso de aplicar el descuento false en caso de no aplicar
     * @throws ParseException Excepcion en caso de que no se puedan canvertir las fechas
     */
    public Boolean aplicaDescuento(Integer descuentoId) throws ParseException;

    /**
     * Se guarda en la base de datos el descuento
     * @param descuento El objeto descuento a guardar en BD
     * @return Objeto con la respuesta
     */
    public ResponseDTO save(DescuentoEntity descuento);
}
