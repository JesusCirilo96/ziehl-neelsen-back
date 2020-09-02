package com.ziehlneelsen.laboratorio.beans.persona;

public class UserAuthDTO {

    /**
     * El id del usuario autenticado
     */
    Integer usuarioId;

    /**
     * El nombre de usuario autenticado
     */
    String nombre;

    /**
     * Apellido paterno del usuario autenticado
     */
    String apellidoPaterno;

    /**
     * Apellido materno del usuario autenticado
     */
    String apellidoMaterno;

    /**
     * Cedula del usuario autenticado
     */
    String cedula;

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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "UserAuthDTO{" +
                "usuarioId=" + usuarioId +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
