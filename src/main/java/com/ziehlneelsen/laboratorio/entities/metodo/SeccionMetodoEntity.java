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
@Table(name = "metodo_seccion")
public class SeccionMetodoEntity implements Serializable {

    @Id
    @Column(name = "METODO_SECCION", unique = true, nullable = false)
    private UUID metodoSeccionId = UUID.randomUUID();

    @Column(name = "METODO_ID")
    private String metodoId;

    @Column(name = "SECCION_ID")
    private String seccionId;

    public UUID getMetodoSeccionId() {
        return metodoSeccionId;
    }

    public void setMetodoSeccionId(UUID metodoSeccionId) {
        this.metodoSeccionId = metodoSeccionId;
    }

    public String getMetodoId() {
        return metodoId;
    }

    public void setMetodoId(String metodoId) {
        this.metodoId = metodoId;
    }

    public String getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(String seccionId) {
        this.seccionId = seccionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeccionMetodoEntity)) return false;
        SeccionMetodoEntity that = (SeccionMetodoEntity) o;
        return Objects.equals(getMetodoSeccionId(), that.getMetodoSeccionId()) && Objects.equals(getMetodoId(), that.getMetodoId()) && Objects.equals(getSeccionId(), that.getSeccionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMetodoSeccionId(), getMetodoId(), getSeccionId());
    }
}
