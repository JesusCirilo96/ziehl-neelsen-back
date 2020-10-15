package com.ziehlneelsen.laboratorio.beans.descuento;

import java.util.List;

public class PaqueteDTO {
    List<PaqueteDescuentoDTO> paquete;

    public List<PaqueteDescuentoDTO> getPaquete() {
        return paquete;
    }

    public void setPaquete(List<PaqueteDescuentoDTO> paquete) {
        this.paquete = paquete;
    }
}
