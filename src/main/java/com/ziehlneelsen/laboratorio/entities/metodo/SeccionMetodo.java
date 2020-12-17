package com.ziehlneelsen.laboratorio.entities.metodo;

import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(SeccionMetodo.class)
@Table(name = "metodo_seccion")
public class SeccionMetodo implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "METODO_ID")
    MetodoEntity metodo;

    @Id
    @ManyToOne
    @JoinColumn(name = "SECCION_ID")
    SeccionEntity seccion;

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
        if (o == null || getClass() != o.getClass()) return false;
        SeccionMetodo that = (SeccionMetodo) o;
        return Objects.equals(metodo, that.metodo) &&
                Objects.equals(seccion, that.seccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metodo, seccion);
    }
}
