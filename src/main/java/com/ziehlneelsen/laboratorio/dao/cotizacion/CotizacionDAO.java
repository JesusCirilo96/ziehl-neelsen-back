package com.ziehlneelsen.laboratorio.dao.cotizacion;

import com.ziehlneelsen.laboratorio.beans.cotizacion.CotizacionExamenesDTO;
import com.ziehlneelsen.laboratorio.entities.cotizacion.CotizacionEntity;

import java.util.List;

public interface CotizacionDAO {

    /**
     * Metodo para obtener los examenes relacionados con la cotizacion
     * @param cotizacion Id de la cotizacion
     * @return Objeto con la lista de examenes y la cotizacion
     */
    public CotizacionExamenesDTO getExamenCotizacion(String cotizacion);

    /**
     * Buscamos las cotizaciones por fecha
     * @param fecha la fecha a buscar en formato YYYY-MM-DD
     * @return
     */
    public List<CotizacionEntity> getCotizacionByFecha(String fecha);

}
