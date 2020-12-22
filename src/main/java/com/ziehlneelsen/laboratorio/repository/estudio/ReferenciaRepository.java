package com.ziehlneelsen.laboratorio.repository.estudio;

import com.ziehlneelsen.laboratorio.entities.estudio.ReferenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReferenciaRepository extends JpaRepository<ReferenciaEntity, UUID> {
    Void save(Optional<ReferenciaEntity> referencia);

    //@Query("SELECT ref.estudioId FROM ReferenciaEntity ref WHERE ref.estudioId = :idEstudio")
    //List<Integer> getReferencias(@Param("idEstudio") Integer idEstudio);

}
