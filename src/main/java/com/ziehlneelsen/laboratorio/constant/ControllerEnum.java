package com.ziehlneelsen.laboratorio.constant;

public enum ControllerEnum {

    USUARIO("/usuario"),
    USUARIO_ALL("/usuario/all"),
    USUARIO_ADD("/usuario/add"),
    USUARIO_SAVE("/usuario/save"),
    USUARIO_UPDATE("/usuario/update");

    private String ruta;

    /**
     * Constructor del enum
     * @param ruta ruta del controller
     */
    ControllerEnum(final String ruta){
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }
}
