package com.ziehlneelsen.laboratorio.serviceImpl.estudio;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioSaveDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioSelectAuxDTO;
import com.ziehlneelsen.laboratorio.beans.estudio.EstudioSelectDTO;
import com.ziehlneelsen.laboratorio.beans.metodo.MetodoDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.dao.estudio.ReferenciaDAO;
import com.ziehlneelsen.laboratorio.entities.estudio.EstudioEntity;
import com.ziehlneelsen.laboratorio.entities.estudio.ReferenciaEntity;
import com.ziehlneelsen.laboratorio.entities.examen.ExamenEstudioEntity;
import com.ziehlneelsen.laboratorio.entities.metodo.EstudioMetodoEntity;
import com.ziehlneelsen.laboratorio.entities.metodo.MetodoEntity;
import com.ziehlneelsen.laboratorio.entities.seccion.SeccionEstudioEntity;
import com.ziehlneelsen.laboratorio.repository.estudio.EstudioRepository;
import com.ziehlneelsen.laboratorio.repository.estudio.ReferenciaRepository;
import com.ziehlneelsen.laboratorio.repository.examen.ExamenEstudioRepository;
import com.ziehlneelsen.laboratorio.repository.metodo.MetodoEstudioRepository;
import com.ziehlneelsen.laboratorio.repository.metodo.MetodoRepository;
import com.ziehlneelsen.laboratorio.repository.seccion.SeccionEstudioRepository;
import com.ziehlneelsen.laboratorio.service.estudio.EstudioService;
import com.ziehlneelsen.laboratorio.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudioServiceImpl implements EstudioService {
    @Autowired
    EstudioRepository estudioRepository;

    @Autowired
    ReferenciaDAO referenciaDAO;

    @Autowired
    ExamenEstudioRepository examenEstudioRepository;

    @Autowired
    SeccionEstudioRepository seccionEstudioRepository;

    @Autowired
    ReferenciaRepository referenciaRepository;

    @Autowired
    MetodoEstudioRepository metodoEstudioRepository;

    @Override
    public List<EstudioEntity> findAll() {
        return estudioRepository.findAll();
    }

    @Override
    public Optional<EstudioEntity> findById(Integer id) {
        return estudioRepository.findById(id);
    }

    @Override
    public ResponseDTO save(EstudioEntity estudio) {
        ResponseDTO response = new ResponseDTO();
        if(null != estudio.getEstudioId() && estudioRepository.findById(estudio.getEstudioId()).isPresent()){
            estudioRepository.save(estudio);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != estudio){
            try{
                estudio.setMostrarInput(false);
                estudioRepository.save(estudio);
                response.setErrorCode(Messages.OK);
                response.setErrorInfo(Messages.REGISTER_OK);
            }catch(DataAccessException ex) {
                response.setErrorCode(Messages.ERROR);
                response.setErrorInfo(ex.getMostSpecificCause().toString());
            }
        }
        return response;
    }

    @Override
    public ResponseDTO saveMasivo(ArrayList<EstudioSaveDTO> request) {

        for(EstudioSaveDTO data : request){
            Integer estudioId = null;

            if(data.getEstudio().getEstudioId() == null || data.getEstudio().getEstudioId() == 0){

                EstudioEntity estudioEntity = new EstudioEntity();

                estudioEntity.setNombre(data.getEstudio().getNombre());
                estudioEntity.setComodin(data.getEstudio().getComodin());
                estudioEntity.setMostrarInput(false);
                estudioEntity.setEstado(true);

                String resultado = "[";
                for(EstudioSelectAuxDTO res : data.getResultadoPred()){
                    resultado += "{\"value\"" + ":\"" + res.getValue() + "\"," +  "\"viewValue\"" + ":\"" + res.getViewValue() + "\"" + "}," ;
                }
                if(resultado.length() > 2){
                    resultado = resultado.substring(0, resultado.length() -1);
                }
                resultado += "]";
                System.out.println("El resultado:: " + resultado);
                estudioEntity.setResultadoSelect(resultado);
                estudioEntity.setFechaCreacion(Utileria.fechaHoraActual());
                estudioEntity.setFechaActualizacion(Utileria.fechaHoraActual());

                estudioRepository.save(estudioEntity);
                estudioId = estudioEntity.getEstudioId();
            }else{
                estudioId = data.getEstudio().getEstudioId();
            }

            if(data.getSeccionId()==null || data.getSeccionId() == 0){
                ExamenEstudioEntity examenEstudioEntity = new ExamenEstudioEntity();
                examenEstudioEntity.setEstudioId(estudioId);
                examenEstudioEntity.setExamenId(data.getExamenId());
                examenEstudioEntity.setOrden(data.getOrdenEstudio());

                examenEstudioRepository.save(examenEstudioEntity);
            }else{
                SeccionEstudioEntity seccionEstudioEntity = new SeccionEstudioEntity();

                seccionEstudioEntity.setEstudioId(estudioId);
                seccionEstudioEntity.setSeccionId(data.getSeccionId());
                seccionEstudioEntity.setOrden(data.getOrdenEstudio());

                seccionEstudioRepository.save(seccionEstudioEntity);
            }

            for(ReferenciaEntity ref : data.getReferencia()){
                ReferenciaEntity referencia = new ReferenciaEntity();
                referencia.setEstudioId(estudioId.toString());

                referencia.setClasificacionId(ref.getClasificacionId());
                referencia.setMasculino(ref.getMasculino());
                referencia.setFemenino(ref.getFemenino());
                referencia.setGeneral(ref.getGeneral());
                referencia.setOrden(ref.getOrden());
                referencia.setPrefijo(ref.getPrefijo());
                referencia.setSufijo("");
                referencia.setNota(ref.getNota());

                referencia.setFechaCreacion(Utileria.fechaHoraActual());
                referencia.setFechaActualizacion(Utileria.fechaHoraActual());

                referenciaRepository.save(referencia);
            }

            for(MetodoDTO metodo: data.getMetodo()){
                EstudioMetodoEntity estudioMetodo = new EstudioMetodoEntity();
                estudioMetodo.setEstudioId(estudioId.toString());
                estudioMetodo.setMetodoId(metodo.getMetodoId().toString());

                metodoEstudioRepository.save(estudioMetodo);
            }

        }
        ResponseDTO response = new ResponseDTO();
        response.setErrorCode(Messages.OK);
        response.setErrorInfo(Messages.REGISTER_OK);
        return response;
    }

    @Override
    public ResponseDTO updateComodin(Integer estudioId, Boolean estado) {
        return referenciaDAO.actualizarComodin(estudioId, estado);
    }

    @Override
    public ResponseDTO updateSelect(EstudioSelectDTO selectEstudio) {
        return referenciaDAO.actualizarSelectRespuesta(selectEstudio);
    }
}
