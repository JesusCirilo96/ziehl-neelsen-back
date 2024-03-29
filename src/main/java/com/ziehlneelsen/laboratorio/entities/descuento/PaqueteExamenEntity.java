package com.ziehlneelsen.laboratorio.entities.descuento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@IdClass(PaqueteExamenEntity.class)
@Table(name = "cat_paquete_examen")
public class PaqueteExamenEntity implements Serializable {

    @Id
    @Column(name = "PAQUETE_EXAMEN_ID", unique = true, nullable = false)
    private UUID examenPaqueteId = UUID.randomUUID();

    @Column(name = "PAQUETE_ID")
    private Integer paqueteId;

    @Column(name = "EXAMEN_ID")
    private Integer examenId;

    public UUID getExamenDescuentoId() {
        return examenPaqueteId;
    }

    public void setExamenDescuentoId(UUID examenDescuentoId) {
        this.examenPaqueteId = examenDescuentoId;
    }

    public Integer getPaqueteId() {
        return paqueteId;
    }

    public void setPaqueteId(Integer paqueteId) {
        this.paqueteId = paqueteId;
    }

    public Integer getExamenId() {
        return examenId;
    }

    public void setExamenId(Integer examenId) {
        this.examenId = examenId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaqueteExamenEntity that = (PaqueteExamenEntity) o;
        return Objects.equals(examenPaqueteId, that.examenPaqueteId) && Objects.equals(paqueteId, that.paqueteId) && Objects.equals(examenId, that.examenId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examenPaqueteId, paqueteId, examenId);
    }
}
