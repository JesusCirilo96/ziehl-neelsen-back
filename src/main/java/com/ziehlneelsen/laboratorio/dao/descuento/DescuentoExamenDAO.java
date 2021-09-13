package com.ziehlneelsen.laboratorio.dao.descuento;

import com.ziehlneelsen.laboratorio.beans.descuento.DescuentoExamenDTO;

public interface DescuentoExamenDAO {

    /**
     * Se obtienen los examenes por el ID de descuento
     * @param descuentoId El id del descuento
     * @return objeto con el descuento y la lista de examenes relacionados
     */
    DescuentoExamenDTO getDescuentoExamen(Integer descuentoId);
}
