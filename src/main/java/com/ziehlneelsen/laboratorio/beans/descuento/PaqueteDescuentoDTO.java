package com.ziehlneelsen.laboratorio.beans.descuento;

import com.ziehlneelsen.laboratorio.entities.descuento.PaqueteDescuentoEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;

import java.util.List;

public class PaqueteDescuentoDTO {

    PaqueteDescuentoEntity paquete;

    List<ExamenGeneralEntity> examen;

    public PaqueteDescuentoEntity getPaquete() {
        return paquete;
    }

    public void setPaquete(PaqueteDescuentoEntity paquete) {
        this.paquete = paquete;
    }

    public List<ExamenGeneralEntity> getExamen() {
        return examen;
    }

    public void setExamen(List<ExamenGeneralEntity> examen) {
        this.examen = examen;
    }
}
