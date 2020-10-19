package com.ziehlneelsen.laboratorio.serviceImpl.examen;

import com.ziehlneelsen.laboratorio.beans.ResponseDTO;
import com.ziehlneelsen.laboratorio.constant.Messages;
import com.ziehlneelsen.laboratorio.entities.examen.CategoriaEntity;
import com.ziehlneelsen.laboratorio.repository.examen.CategoriaRepository;
import com.ziehlneelsen.laboratorio.service.examen.CategoriaService;
import com.ziehlneelsen.laboratorio.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaEntity> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<CategoriaEntity> findById(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public ResponseDTO save(CategoriaEntity categoria) {
        ResponseDTO response = new ResponseDTO();
        if(null != categoria.getCategoriaId() && categoriaRepository.findById(categoria.getCategoriaId()).isPresent()){
            categoria.setFechaActualizacion(Utileria.fechaHoraActual());
            categoriaRepository.save(categoria);
            response.setErrorCode(Messages.OK);
            response.setErrorInfo(Messages.UPDATE_OK);
        } else if(null != categoria){
            try{
                categoria.setFechaCreacion(Utileria.fechaHoraActual());
                categoria.setFechaActualizacion(Utileria.fechaHoraActual());
                categoriaRepository.save(categoria);
                response.setErrorCode(Messages.OK);
                response.setErrorInfo(Messages.REGISTER_OK);
            }catch(DataAccessException ex) {
                response.setErrorCode(Messages.ERROR);
                response.setErrorInfo(ex.getMostSpecificCause().toString());
            }
        }
        return response;
    }
}
