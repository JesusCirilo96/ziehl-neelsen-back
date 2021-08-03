package com.ziehlneelsen.laboratorio.entities.metodo;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@DynamicUpdate
@Table(name = "estudio_metodo")
public class EstudioMetodoEntity implements Serializable {

    @Id
    @Column(name = "ESTUDIO_METODO_ID", unique = true, nullable = false)
    private UUID estudioMetodoId = UUID.randomUUID();

    @Column(name = "ESTUDIO_ID")
    private String estudioId;

    @Column(name = "METODO_ID")
    private String metodoId;

    public UUID getEstudioMetodoId() {
        return estudioMetodoId;
    }

    public void setEstudioMetodoId(UUID estudioMetodoId) {
        this.estudioMetodoId = estudioMetodoId;
    }

    public String getEstudioId() {
        return estudioId;
    }

    public void setEstudioId(String estudioId) {
        this.estudioId = estudioId;
    }

    public String getMetodoId() {
        return metodoId;
    }

    public void setMetodoId(String metodoId) {
        this.metodoId = metodoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstudioMetodoEntity)) return false;
        EstudioMetodoEntity that = (EstudioMetodoEntity) o;
        return Objects.equals(getEstudioMetodoId(), that.getEstudioMetodoId()) && Objects.equals(getEstudioId(), that.getEstudioId()) && Objects.equals(getMetodoId(), that.getMetodoId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEstudioMetodoId(), getEstudioId(), getMetodoId());
    }
}
