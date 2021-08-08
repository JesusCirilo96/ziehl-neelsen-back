package com.ziehlneelsen.laboratorio.beans.recepcion;

import com.ziehlneelsen.laboratorio.entities.persona.PacienteEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HistorialDTO {
    private Optional<PacienteEntity> paciente;

    private List<HistorialAuxDTO> historial;

    public Optional<PacienteEntity> getPaciente() {
        return paciente;
    }

    public void setPaciente(Optional<PacienteEntity> paciente) {
        this.paciente = paciente;
    }

    public List<HistorialAuxDTO> getHistorial() {
        return historial;
    }

    public void setHistorial(List<HistorialAuxDTO> historial) {
        this.historial = historial;
    }
}
