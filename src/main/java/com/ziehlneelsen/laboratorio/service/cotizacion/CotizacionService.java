package com.ziehlneelsen.laboratorio.service.cotizacion;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.cotizacion.CotizacionExamenesDTO;
import com.ziehlneelsen.laboratorio.entities.cotizacion.CotizacionEntity;

import java.util.List;
import java.util.Optional;

public interface CotizacionService {
    public List<CotizacionEntity> findAll();

    public Optional<CotizacionEntity> findById(String id);

    public ResponseDTO save(CotizacionEntity cotizacion);

    public CotizacionExamenesDTO getExamenCotizacion(String cotizacionId);

    public List<CotizacionEntity> findByFecha(String fecha);

}
