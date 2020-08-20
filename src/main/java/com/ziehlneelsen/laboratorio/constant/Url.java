package com.ziehlneelsen.laboratorio.constant;

import java.awt.*;

public class Url {

    //constante para application/json
    public static final String APLICATION_JSON = "application/json";

    //Urls comunes
    public static final String GET_ALL = "/get/all";
    public static final String FIND_BY_ID = "/get/id/{id}";
    public static final String SAVE = "/save";

    //Descuento
    public static final String DESCUENTO = "/descuento";

    //Estudio
    public static final String ESTUDIO = "/estudio";

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
