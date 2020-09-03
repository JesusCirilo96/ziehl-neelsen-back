package com.ziehlneelsen.laboratorio.constant;

import java.awt.*;

public class Url {

    //constante para application/json
    public static final String APLICATION_JSON = "application/json";

    //Urls comunes
    public static final String GET_ALL = "/get/all";
    public static final String FIND_BY_ID = "/get/id/{id}";
    public static final String SAVE = "/save";

    //Cotizacion
    public static final String COTIZACION = "/cotizacion";
    public static final String COTIZACION_EXAMEN_SENCILLO = "/examen/sencillo/{id}";
    public static final String COTIZACION_EXAMEN_GENERAL = "/examen/general/{id}";

    //Descuento
    public static final String DESCUENTO = "/descuento";

    //Examen
    public static final String EXAMEN_GENERAL = "/examen/general";
    public static final String EXAMEN_SENCILLO = "/examen/sencillo";

    //Estudio
    public static final String ESTUDIO = "/estudio";

    //Clasificacion paciente
    public static final String CLASIFICACION_PACIENTE = "/clasificacion/paciente";

    //Referencia
    public static final String ESTUDIO_REFERENCIA = "/referencia";
    public static final String FIND_BY_ESTUDIO = "/get/estudio/{id}";
    public static final String FIND_BY_CLASIFICACION = "/get/clasificacion/{id}";

    //Menu
    public static final String MENU = "/menu";
    public static final String SUB_MENU = "/menu/submenu";

    //Metodo
    public static final String METODO = "/metodo";

    //Persona
    public static final String USUARIO = "/usuario";
    public static final String AUTH = "/authenticate/{user}/{password}";
    public static final String PACIENTE = "/paciente";
    public static final String MEDICO = "/medico";

    //Rol
    public static final String ROL = "/rol";

    //Seccion
    public static final String SECCION = "/seccion";


    /**
     * Construtor de la clase
     */
    private Url(){

    }
}
