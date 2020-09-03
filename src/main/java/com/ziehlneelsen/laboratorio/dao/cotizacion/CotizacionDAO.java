package com.ziehlneelsen.laboratorio.dao.cotizacion;

import com.ziehlneelsen.laboratorio.beans.cotizacion.CotizacionExamenesDTO;

public interface CotizacionDAO {
    public CotizacionExamenesDTO getExamenSencillo(String cotizacion);
}
