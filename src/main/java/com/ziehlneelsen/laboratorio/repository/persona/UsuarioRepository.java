package com.ziehlneelsen.laboratorio.repository.persona;

import com.ziehlneelsen.laboratorio.entities.persona.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    Void save (Optional<UsuarioEntity> usuario);

    @Query("SELECT u.usuarioId, u.nombre, u.apellidoPaterno, u.apellidoMaterno, u.cedula FROM UsuarioEntity u WHERE u.nombreUsuario = :user AND u.password = :pass")
    Optional<UsuarioEntity> userLogin(@Param("user") String user, @Param("pass") String pass);

}
