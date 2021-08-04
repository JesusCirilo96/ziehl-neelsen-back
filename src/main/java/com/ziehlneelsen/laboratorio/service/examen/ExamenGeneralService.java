package com.ziehlneelsen.laboratorio.service.examen;

import com.ziehlneelsen.laboratorio.beans.ExamenDescuentoDTO;
import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenEstudioDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenMetodoAux;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionDTO;
import com.ziehlneelsen.laboratorio.beans.examen.ExamenSeccionSaveDTO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenGeneralSeccionEntity;

import java.util.List;
import java.util.Optional;

public interface ExamenGeneralService {

    /**
     * Buscamos todos lo examenes
     * @return una lista con todos los examenes
     */
    List<ExamenGeneralEntity> findAll();

    /**
     * Buscamos el examen por su ID
     * @param id El id del examen a buscar
     * @return El objeto con el examen encontrado
     */
    Optional<ExamenGeneralEntity> findById(Integer id);

    /**
     * Bucamos el examen por el nombre de la misma
     * @param nombre El nombre del examen a buscar
     * @return El objeto con los datos del examen encontrado
     */
    ExamenGeneralEntity findByName(String nombre);

    /**
     * Obtenemos los estduios del examen
     * @param examenId El id del examen
     * @return Lista con los estudios del examen
     */
    List<EstudioEntity> findEstudioExamen(Integer examenId);

    /**
     * Metodo para realizar el registro de un examen en la BD
     * @param examenGeneral El objeto deL examen a guardar
     * @return La respuesta
     */
    ResponseDTO save(ExamenGeneralEntity examenGeneral);

    /**
     * Metodo que buscar los descuentos aplicables para el exmane
     * @param examenId El id del examen a buscar
     * @return El objeto con la lista de descuentos y el examen
     */
    ExamenDescuentoDTO findDescuentoByExamen(Integer examenId);

    /**
     * Buscamos las secciones correspondientes al examen
     * @param examenId El id del examen a buscar
     * @return La lista de las secciones con sus respectivos estudios
     */
    ExamenSeccionDTO findSeccionByExamen(Integer examenId);

    /**
     * Guardamos el estudio del examen
     * @param estudio El objeto de estudio a guardar
     * @return Respuesta del repositorio
     */
    ResponseDTO saveEstudioExamen(ExamenEstudioDTO estudio);

    /**
     * Guardamos la seccion del examen
     * @param examenSeccion El objeto de el examen seccion a guardar
     * @return respuesta del repositorio
     */
    ResponseDTO saveSeccionExamen(ExamenSeccionSaveDTO examenSeccion);

    /**
     * Actualiza el examen seccion
     * @param examenSeccion Datos a actualizar
     * @return Respuesta del servicio
     */
    ResponseDTO updateSeccionExamen(ExamenSeccionSaveDTO examenSeccion);

    /**
     * Eliminamos la seccion relacionada con el examen general
     * @param examenId El ID del examen
     * @param seccionId El ID de la seccion
     * @return Respuesta del servicio
     */
    ResponseDTO deleteExamenSeccion(Integer examenId, Integer seccionId);

    /**
     * Eliminar el examen estudio relacionado de BD
     * @param examenId El id del examen
     * @param estudioId El id del estudio
     * @return Respuesta del repositorio
     */
    ResponseDTO deleteExamenEstudio(Integer examenId, Integer estudioId);

    /**
     * Actualizamos el metodo del examen
     * @param examen Datos a actualizar
     * @return Respuesta del servicio
     */
    ResponseDTO updateMetodo(ExamenMetodoAux examen);
}
