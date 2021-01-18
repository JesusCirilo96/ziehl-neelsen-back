package com.ziehlneelsen.laboratorio.entities.examen;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@IdClass(ExamenEstudioEntity.class)
@Table(name = "estudio_examen_general")
public class ExamenEstudioEntity implements Serializable {
    @Id
    @Column(name = "ESTUDIO_EXAMEN_ID", unique = true, nullable = false)
    private UUID examenEstudioId = UUID.randomUUID();

    @Column(name = "ESTUDIO_ID")
    private Integer estudioId;

    @Column(name = "EXAMEN_ID")
    private Integer examenId;

    public UUID getExamenEstudioId() {
        return examenEstudioId;
    }

    public void setExamenEstudioId(UUID examenEstudioId) {
        this.examenEstudioId = examenEstudioId;
    }

    public Integer getEstudioId() {
        return estudioId;
    }

    public void setEstudioId(Integer estudioId) {
        this.estudioId = estudioId;
    }

    public Integer getExamenId() {
        return examenId;
    }

    public void setExamenId(Integer examenId) {
        this.examenId = examenId;
    }
}
