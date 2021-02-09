package com.ziehlneelsen.laboratorio.entities.seccion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@IdClass(SeccionEstudioEntity.class)
@Table(name = "estudio_seccion")
public class SeccionEstudioEntity implements Serializable {

    @Id
    @Column(name = "ESTUDIO_SECCION_ID", unique = true, nullable = false)
    private UUID estudioSeccionId = UUID.randomUUID();

    @Column(name = "ESTUDIO_ID")
    Integer estudioId;

    @Column(name = "SECCION_ID")
    Integer seccionId;

    @Column(name = "ORDEN")
    Integer orden;

    public UUID getEstudioSeccionId() {
        return estudioSeccionId;
    }

    public void setEstudioSeccionId(UUID estudioSeccionId) {
        this.estudioSeccionId = estudioSeccionId;
    }

    public Integer getEstudioId() {
        return estudioId;
    }

    public void setEstudioId(Integer estudioId) {
        this.estudioId = estudioId;
    }

    public Integer getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(Integer seccionId) {
        this.seccionId = seccionId;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeccionEstudioEntity)) return false;
        SeccionEstudioEntity that = (SeccionEstudioEntity) o;
        return Objects.equals(getEstudioSeccionId(), that.getEstudioSeccionId()) && Objects.equals(getEstudioId(), that.getEstudioId()) && Objects.equals(getSeccionId(), that.getSeccionId()) && Objects.equals(getOrden(), that.getOrden());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEstudioSeccionId(), getEstudioId(), getSeccionId(), getOrden());
    }
}
