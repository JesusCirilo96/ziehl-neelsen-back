package com.ziehlneelsen.laboratorio.dao.cotizacion;

import com.ziehlneelsen.laboratorio.beans.cotizacion.CotizacionExamenesDTO;
import com.ziehlneelsen.laboratorio.entities.cotizacion.CotizacionEntity;

import java.util.List;

public interface CotizacionDAO {

    public CotizacionExamenesDTO getExamenCotizacion(String cotizacion);

    public List<CotizacionEntity> getCotizacionByFecha(String fecha);

}
