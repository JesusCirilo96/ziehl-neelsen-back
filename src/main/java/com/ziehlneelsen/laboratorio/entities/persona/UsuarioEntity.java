package com.ziehlneelsen.laboratorio.entities.persona;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "cat_usuario")
@DynamicUpdate
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USUARIO_ID")
    Integer usuarioId;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Column(name = "NOMBRE")
    String nombre;

    @NotBlank(message = "El apellido paterno no puede estar vacio")
    @Column(name = "APELLIDO_PATERNO")
    String apellidoPaterno;

    @Column(name = "APELLIDO_MATERNO")
    String apellidoMaterno;

    @NotBlank(message = "El nombre de usuario no puede estar vacio")
    @Column(name = "NOMBRE_USUARIO")
    String nombreUsuario;

    @Column(name = "CEDULA")
    String cedula;

    @NotBlank(message = "La contrasena no puede estar vacio")
    @Column(name = "PASSWORD")
    String password;

    @Column(name = "ESTADO", columnDefinition = "boolean default true")
    Boolean estado;

    @Column(name = "FECHA_CREACION")
    String fechaCreacion;

    @Column(name = "FECHA_ACTUALIZACION")
    String fechaActualizacion;

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
