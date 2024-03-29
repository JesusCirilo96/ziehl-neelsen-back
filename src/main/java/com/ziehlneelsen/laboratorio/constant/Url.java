package com.ziehlneelsen.laboratorio.constant;

public class Url {

    //constante para application/json
    public static final String APLICATION_JSON = "application/json";

    //Urls comunes
    public static final String GET_ALL = "/get/all";
    public static final String FIND_BY_ID = "/get/{id}";
    public static final String FIND_BY_NAME = "/get/name/{name}";
    public static final String SAVE = "/save";
    public static final String SAVE_MASIVO="/save/masivo";

    //Cotizacion
    public static final String COTIZACION = "/cotizacion";
    public static final String COTIZACION_EXAMENES = "/examen/{id}";
    public static final String COTIZACION_BY_FECHA = "/fecha/{fecha}";

    //Descuento
    public static final String DESCUENTO = "/descuento";
    public static final String SAVE_DESCUENTO_EXAMEN = "/examen/save";

    public static final String PAQUETE_DESCUENTO = "/paquete";
    public static final String FIND_BY_PAQUETE = "/examen/{id}";
    public static final String FIND_ALL_PAQUETE = "/all";
    public static final String SAVE_PAQUETE_EXAMEN = "/examen/save";
    public static final String FIND_EXAMEN_PAQUETE = "/examen/get/{examenId}";

    public static final String FIND_DESCUENTO_EXAMEN ="/examen/get/{id}";
    public static final String DELETE_DESCUENTO="/delete/{id}";

    //Categoria
    public static final String CATEGORIA = "/categoria";

    //Examen
    public static final String EXAMEN_GENERAL = "/examen";
    public static final String UPDATE_METODO_EXAMEN = "/metodo/update";
    public static final String EXAMEN_DESCUENTO = "/descuento/{id}";
    public static final String EXAMEN_SECCION = "/seccion/{id}";
    public static final String SAVE_EXAMEN_ESTUDIO = "/estudio/save";
    public static final String SAVE_EXAMEN_SECCION = "/seccion/save";
    public static final String UPDATE_EXAMEN_SECCION = "/seccion/update";
    public static final String EXAMEN_ESTUDIO = "/estudio/{id}";
    public static final String DELETE_EXAMEN_SECCION = "/seccion/delete/{examenId}/{seccionId}";
    public static final String DELETE_EXAMEN_ESTUDIO = "/estudio/delete/{examenId}/{estudioId}";

    //Estudio
    public static final String ESTUDIO = "/estudio";
    public static final String COMODIN = "/update/comodin/{estudioId}/{estado}";
    public static final String RES_SELECT = "/update/select";

    //Clasificacion paciente
    public static final String CLASIFICACION_PACIENTE = "/clasificacion/paciente";

    //Referencia
    public static final String ESTUDIO_REFERENCIA = "/referencia";
    public static final String DELETE_REFERENCIA = "/delete/{referenciaId}";
    public static final String FIND_BY_ESTUDIO = "/estudio/{id}";
    public static final String FIND_BY_CLASIFICACION = "/clasificacion/{id}";
    public static final String UPDATE_REFERENCIA = "/update";

    //Menu
    public static final String MENU = "/menu";
    public static final String SUB_MENU = "/menu/submenu";
    public static final String SUB_MENU_BY_MENU = "/submenu/{id}";
    public static final String MENU_SUB_MENU = "/all/menu/submenu";

    //Metodo
    public static final String METODO = "/metodo";
    public static final String METODO_BY_SECCION = "/seccion/{id}";
    public static final String METODO_BY_ESTUDIO = "/estudio/{estudioId}";
    public static final String SAVE_METODO_SECCION = "/seccion/save";
    public static final String SAVE_METODO_ESTUDIO = "/estudio/save";
    public static final String DELETE_METODO_SECCION = "/seccion/delete/{seccionId}/{metodoId}";
    public static final String DELETE_METODO_ESTUDIO = "/estudio/delete/{estudioId}/{metodoId}";

    //Persona
    public static final String USUARIO = "/usuario";
    public static final String AUTH = "/authenticate/{user}/{password}";
    public static final String FIND_ROL = "/get/rol/{id}";
    public static final String PACIENTE = "/paciente";
    public static final String MEDICO = "/medico";
    public static final String UPDATE_DATOS = "/update/datos";

    //Rol
    public static final String ROL = "/rol";
    public static final String ROL_MENU = "/menu/{id}";

    //Seccion
    public static final String SECCION = "/seccion";
    public static final String SECCION_ESTUDIO = "/estudio/{id}";
    public static final String SAVE_SECCION_ESTUDIO = "/estudio/save";
    public static final String DELETE_SECCION_ESTUDIO = "/estudio/delete/{seccionId}/{estudioId}";
    public static final String UPDATE_SECCION_ESTUDIO = "/estudio/update";

    //Recepcion
    public static final String RECEPCION = "/recepcion";
    public static final String RECEPCION_FICHA = "/get/ficha";
    public static final String RECEPCION_FECHA = "/get/fecha/{fecha}";
    public static final String RECEPCION_RESULTADO = "/resultado/{idRecepcion}";
    public static final String SAVE_RECEPCION_EXAMEN = "/examen/save";
    public static final String SAVE_RESULTADO = "/resultado/save";
    public static final String RECEPCION_HISTORIAL = "/historial/{pacienteId}";
    public static final String RECEPCION_UPDATE_BANDERAS = "/update/bandera/{recepcionId}/{opcion}/{valor}";


    /**
     * Construtor de la clase
     */
    private Url(){

    }
}
