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
    private UUID examenRecepcionId = UUID.randomUUID();

    @Column(name = "EXAMEN_ID")
    private String examenId;

    @Column(name = "RECEPCION_ID")
    private String recepcionId;

    @Column(name = "USUARIO_ID")
    private Integer usuarioId;

    @Column(name = "RESULTADO")
    private String resultado;

    public UUID getExamenRecepcionId() {
        return examenRecepcionId;
    }

    public void setExamenRecepcionId(UUID examenRecepcionId) {
        this.examenRecepcionId = examenRecepcionId;
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

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
