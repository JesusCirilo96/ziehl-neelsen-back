package com.ziehlneelsen.laboratorio.beans.recepcion;

import com.ziehlneelsen.laboratorio.entities.persona.MedicoEntity;
import com.ziehlneelsen.laboratorio.entities.persona.PacienteEntity;
import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionEntity;
import com.ziehlneelsen.laboratorio.entities.recepcion.RecepcionExamenGeneralEntity;

import java.util.List;
import java.util.Optional;

public class RecepcionResultadoDTO {

    Optional<PacienteEntity> paciente;

    Optional<MedicoEntity> medico;

    RecepcionEntity recepcion;

    List<RecepcionExamenGeneralEntity> recepcionExamen;

    public Optional<PacienteEntity> getPaciente() {
        return paciente;
    }

    public void setPaciente(Optional<PacienteEntity> paciente) {
        this.paciente = paciente;
    }

    public Optional<MedicoEntity> getMedico() {
        return medico;
    }

    public void setMedico(Optional<MedicoEntity> medico) {
        this.medico = medico;
    }

    public RecepcionEntity getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(RecepcionEntity recepcion) {
        this.recepcion = recepcion;
    }

    public List<RecepcionExamenGeneralEntity> getRecepcionExamen() {
        return recepcionExamen;
    }

    public void setRecepcionExamen(List<RecepcionExamenGeneralEntity> recepcionExamen) {
        this.recepcionExamen = recepcionExamen;
    }
}
