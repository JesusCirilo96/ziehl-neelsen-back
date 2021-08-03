package com.ziehlneelsen.laboratorio.beans.estudio;

import com.ziehlneelsen.laboratorio.beans.examen.ReferenciaDTO;
import com.ziehlneelsen.laboratorio.beans.metodo.MetodoDTO;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class EstudioDTO {

    private Integer estudioId;

    private String nombre;

    private Boolean comodin;

    private ArrayList<EstudioSelectAuxDTO> resultadoSelect;

    private String resultado;

    private Boolean estado;

    private String fechaCreacion;

    private String fechaActualizacion;

    private Integer orden;

    private List<ReferenciaDTO> referencia;

    private List<MetodoDTO> metodo;

    public Integer getEstudioId() {
        return estudioId;
    }

    public void setEstudioId(Integer estudioId) {
        this.estudioId = estudioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getComodin() {
        return comodin;
    }

    public void setComodin(Boolean comodin) {
        this.comodin = comodin;
    }

    public ArrayList<EstudioSelectAuxDTO> getResultadoSelect() {
        return resultadoSelect;
    }

    public void setResultadoSelect(ArrayList<EstudioSelectAuxDTO> resultadoSelect) {
        this.resultadoSelect = resultadoSelect;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public List<ReferenciaDTO> getReferencia() {
        return referencia;
    }

    public void setReferencia(List<ReferenciaDTO> referencia) {
        this.referencia = referencia;
    }

    public List<MetodoDTO> getMetodo() {
        return metodo;
    }

    public void setMetodo(List<MetodoDTO> metodo) {
        this.metodo = metodo;
    }
}
