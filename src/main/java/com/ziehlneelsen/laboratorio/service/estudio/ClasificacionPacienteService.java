package com.ziehlneelsen.laboratorio.service.estudio;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.entities.estudio.ClasificacionPacienteEntity;

import java.util.List;
import java.util.Optional;

public interface ClasificacionPacienteService {

    /**
     * Buscamos todas las clasificaciones de los pacientes
     * @return Lista con las clasificaciones paciente
     */
    List<ClasificacionPacienteEntity> findAll();

    /**
     * Obtener clasificacion por el ID
     * @param id El id de la clasificacion
     * @return Objeto con la clasificacion
     */
    Optional<ClasificacionPacienteEntity> findById(Integer id);

    /**
     * Guardar la clasificacion del paciente
     * @param clasificacionPaciente Objeto de la clasificacion
     * @return Respuesta 
     */
    ResponseDTO save(ClasificacionPacienteEntity clasificacionPaciente);
}
