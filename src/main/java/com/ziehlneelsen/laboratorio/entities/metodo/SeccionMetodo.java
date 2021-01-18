package com.ziehlneelsen.laboratorio.entities.metodo;

import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@IdClass(SeccionMetodo.class)
@Table(name = "metodo_seccion")
public class SeccionMetodo implements Serializable {

    @Id
    @Column(name = "METODO_SECCION", unique = true, nullable = false)
    private UUID metodoSeccionId = UUID.randomUUID();

    @Id
    @ManyToOne
    @JoinColumn(name = "METODO_ID")
    MetodoEntity metodo;

    @Id
    @ManyToOne
    @JoinColumn(name = "SECCION_ID")
    SeccionEntity seccion;

    public UUID getMetodoSeccionId() {
        return metodoSeccionId;
    }

    public void setMetodoSeccionId(UUID metodoSeccionId) {
        this.metodoSeccionId = metodoSeccionId;
    }

    public MetodoEntity getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoEntity metodo) {
        this.metodo = metodo;
    }

    public SeccionEntity getSeccion() {
        return seccion;
    }

    public void setSeccion(SeccionEntity seccion) {
        this.seccion = seccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeccionMetodo)) return false;
        SeccionMetodo that = (SeccionMetodo) o;
        return Objects.equals(getMetodoSeccionId(), that.getMetodoSeccionId()) && Objects.equals(getMetodo(), that.getMetodo()) && Objects.equals(getSeccion(), that.getSeccion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMetodoSeccionId(), getMetodo(), getSeccion());
    }
}
