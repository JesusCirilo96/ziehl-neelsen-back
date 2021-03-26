package com.ziehlneelsen.laboratorio.entities.recepcion;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "examen_general_recepcion")
@DynamicUpdate
public class RecepcionExamenGeneralEntity implements Serializable {

    @Id
    @Column(name = "EXAMEN_RECEPCION_ID", unique = true, nullable = false)
    private UUID metodoSeccionId = UUID.randomUUID();

    @Column(name = "EXAMEN_ID")
    private String examenId;

    @Column(name = "RECEPCION_ID")
    private String recepcionId;

    @Column(name = "USUARIO_ID")
    private Integer usuarioId;

    @Column(name = "REALIZADO")
    private Boolean realizado;

    @Column(name = "IMPRESO")
    private Boolean impreso;

    @Column(name = "ENTREGADO")
    private Boolean entregado;

    @Column(name = "RESULTADO")
    private String resultado;

    public UUID getMetodoSeccionId() {
        return metodoSeccionId;
    }

    public void setMetodoSeccionId(UUID metodoSeccionId) {
        this.metodoSeccionId = metodoSeccionId;
    }

    public String getExamenId() {
        return examenId;
    }

    public void setExamenId(String examenId) {
        this.examenId = examenId;
    }

    public String getRecepcionId() {
        return recepcionId;
    }

    public void setRecepcionId(String recepcionId) {
        this.recepcionId = recepcionId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }

    public Boolean getImpreso() {
        return impreso;
    }

    public void setImpreso(Boolean impreso) {
        this.impreso = impreso;
    }

    public Boolean getEntregado() {
        return entregado;
    }

    public void setEntregado(Boolean entregado) {
        this.entregado = entregado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
