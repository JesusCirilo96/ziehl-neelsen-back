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

    public static final String PAQUETE_DESCUENTO = "/paquete/descuento";
    public static final String FIND_BY_PAQUETE = "/examen/{id}";
    public static final String FIND_ALL_PAQUETE = "/all";

    //Categoria
    public static final String CATEGORIA = "/categoria";

    //Examen
    public static final String EXAMEN_GENERAL = "/examen";
    public static final String EXAMEN_DESCUENTO = "/descuento/{id}";
    public static final String EXAMEN_SECCION = "/seccion/{id}";
    public static final String SAVE_EXAMEN_ESTUDIO = "/estudio/save";
    public static final String SAVE_EXAMEN_SECCION = "/seccion/save";
    public static final String EXAMEN_ESTUDIO = "/estudio/{id}";

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
    public static final String SUB_MENU_BY_MENU = "/submenu/{id}";
    public static final String MENU_SUB_MENU = "/all/menu/submenu";

    //Metodo
    public static final String METODO = "/metodo";
    public static final String METODO_BY_SECCION = "/seccion/{id}";
    public static final String SAVE_METODO_SECCION = "/seccion/save";

    //Persona
    public static final String USUARIO = "/usuario";
    public static final String AUTH = "/authenticate/{user}/{password}";
    public static final String FIND_ROL = "/get/rol/{id}";
    public static final String PACIENTE = "/paciente";
    public static final String MEDICO = "/medico";

    //Rol
    public static final String ROL = "/rol";
    public static final String ROL_MENU = "/menu/{id}";

    //Seccion
    public static final String SECCION = "/seccion";
    public static final String SECCION_ESTUDIO = "/estudio/{id}";


    /**
     * Construtor de la clase
     */
    private Url(){

    }
}
