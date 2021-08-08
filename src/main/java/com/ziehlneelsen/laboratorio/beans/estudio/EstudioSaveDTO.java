package com.ziehlneelsen.laboratorio.beans.estudio;

import com.ziehlneelsen.laboratorio.beans.metodo.MetodoDTO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.estudio.ReferenciaEntity;

import java.io.Serializable;
import java.util.ArrayList;

public class EstudioSaveDTO implements Serializable {

    private EstudioEntity estudio;
    private Integer examenId;
    private Integer seccionId;
    private ArrayList<ReferenciaEntity> referencia;
    private Integer ordenEstudio;
    private ArrayList<MetodoDTO> metodo;
    private ArrayList<EstudioSelectAuxDTO> resultadoPred;

    public EstudioEntity getEstudio() {
        return estudio;
    }

    public void setEstudio(EstudioEntity estudio) {
        this.estudio = estudio;
    }

    public Integer getExamenId() {
        return examenId;
    }

    public void setExamenId(Integer examenId) {
        this.examenId = examenId;
    }

    public Integer getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(Integer seccionId) {
        this.seccionId = seccionId;
    }

    public ArrayList<ReferenciaEntity> getReferencia() {
        return referencia;
    }

    public void setReferencia(ArrayList<ReferenciaEntity> referencia) {
        this.referencia = referencia;
    }

    public Integer getOrdenEstudio() {
        return ordenEstudio;
    }

    public void setOrdenEstudio(Integer ordenEstudio) {
        this.ordenEstudio = ordenEstudio;
    }

    public ArrayList<MetodoDTO> getMetodo() {
        return metodo;
    }

    public void setMetodo(ArrayList<MetodoDTO> metodo) {
        this.metodo = metodo;
    }

    public ArrayList<EstudioSelectAuxDTO> getResultadoPred() {
        return resultadoPred;
    }

    public void setResultadoPred(ArrayList<EstudioSelectAuxDTO> resultadoPred) {
        this.resultadoPred = resultadoPred;
    }

    @Override
    public String toString() {
        return "EstudioSaveDTO{" +
                "estudio=" + estudio +
                ", examenId=" + examenId +
                ", seccionId=" + seccionId +
                ", referencia=" + referencia +
                ", ordenEstudio=" + ordenEstudio +
                ", metodo=" + metodo +
                ", resultadoPred=" + resultadoPred +
                '}';
    }
}
