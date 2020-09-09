package com.ziehlneelsen.laboratorio.entities.descuento;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@DynamicUpdate
@Table(name = "cat_dias")
public class DiaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIA_ID")
    Integer diaId;

    @NotBlank(message = "Numero del dia es obligatorio")
    @Column(name = "NUMERO_DIA")
    String numeroDia;

    @NotBlank(message = "El nombre del dia es obligatorio")
    @Column(name = "NOMBRE")
    String nombre;

    public Integer getDiaId() {
        return diaId;
    }

    public void setDiaId(Integer diaId) {
        this.diaId = diaId;
    }

    public String getNumeroDia() {
        return numeroDia;
    }

    public void setNumeroDia(String numeroDia) {
        this.numeroDia = numeroDia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
