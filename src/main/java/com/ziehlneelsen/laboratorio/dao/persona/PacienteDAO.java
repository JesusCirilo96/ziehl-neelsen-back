package com.ziehlneelsen.laboratorio.dao.persona;

public interface PacienteDAO {

    /**
     * Obtenemos el nombre del paciente dado el ID
     * @param pacienteid El ID del paciente
     * @return El nombre del paciente
     */
    String obtenerNombrePaciente(Integer pacienteid);

    /**
     * Obtenemos el nombre del paciente dado el ID
     * @param usuarioId El ID del usuario
     * @return El nombre del paciente
     */
    String obtenerNombreUsuario(Integer usuarioId);
}
