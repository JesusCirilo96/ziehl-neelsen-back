package com.ziehlneelsen.laboratorio.beans.cotizacion;

import com.ziehlneelsen.laboratorio.entities.cotizacion.CotizacionEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenSencilloEntity;

import java.util.List;

public class CotizacionExamenesDTO {

    private CotizacionEntity cotizacion;

    private List<ExamenSencilloEntity> examenSencillo;

    private List<ExamenGeneralEntity> examenGeneral;

    public CotizacionEntity getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(CotizacionEntity cotizacion) {
        this.cotizacion = cotizacion;
    }

    public List<ExamenSencilloEntity> getExamenSencillo() {
        return examenSencillo;
    }

    public void setExamenSencillo(List<ExamenSencilloEntity> examenSencillo) {
        this.examenSencillo = examenSencillo;
    }

    public List<ExamenGeneralEntity> getExamenGeneral() {
        return examenGeneral;
    }

    public void setExamenGeneral(List<ExamenGeneralEntity> examenGeneral) {
        this.examenGeneral = examenGeneral;
    }
}
