package com.ziehlneelsen.laboratorio.beans.recepcion;

public class RecepcionDTO {

    private String recepcionId;

    private String horaIngreso;

    private Integer ficha;

    private String paciente;

    public String getRecepcionId() {
        return recepcionId;
    }

    public void setRecepcionId(String recepcionId) {
        this.recepcionId = recepcionId;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public Integer getFicha() {
        return ficha;
    }

    public void setFicha(Integer ficha) {
        this.ficha = ficha;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
}
