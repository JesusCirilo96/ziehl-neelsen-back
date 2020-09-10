package com.ziehlneelsen.laboratorio.constant;

import java.awt.*;

public class Url {

    //constante para application/json
    public static final String APLICATION_JSON = "application/json";

    //Urls comunes
    public static final String GET_ALL = "/get/all";
    public static final String FIND_BY_ID = "/get/{id}";
    public static final String FIND_BY_NAME = "/get/name/{name}";
    public static final String SAVE = "/save";

    //Cotizacion
    public static final String COTIZACION = "/cotizacion";
    public static final String COTIZACION_EXAMENES = "/examen/{id}";
    public static final String COTIZACION_BY_FECHA = "/fecha/{fecha}";

    //Descuento
    public static final String DESCUENTO = "/descuento";
    public static final String DIA_DESCUENTO = "/dia/{id}";

    //Examen
    public static final String EXAMEN_GENERAL = "/examen";
    public static final String EXAMEN_DESCUENTO = "/descuento/{id}";

    //Estudio
    public static final String ESTUDIO = "/estudio";

    //Clasificacion paciente
    public static final String CLASIFICACION_PACIENTE = "/clasificacion/paciente";

    //Referencia
    public static final String ESTUDIO_REFERENCIA = "/referencia";
    public static final String FIND_BY_ESTUDIO = "/estudio/{id}";
    public static final String FIND_BY_CLASIFICACION = "/clasificacion/{id}";

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
