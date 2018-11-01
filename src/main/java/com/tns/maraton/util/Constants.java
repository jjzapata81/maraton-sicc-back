package com.tns.maraton.util;

import java.util.HashMap;
import java.util.Map;

public final class Constants {

    public static final String CHARSET = "UTF-8";
    public static final String USER_PARAM = "user";
    public static final String FILE_NAME_PARAM = "file";
    public static final String URL_SERVICE = "http://hackaton.techandsolve.com:5001/";
    public static final String REGISTER = "register";
    public static final String COMPARE = "compare-face";
    public static final String CONECTION_ERROR = "Falló la conexión con el servicio";
    public static final String UNDER_CONSTRUCTION = "En conctrucción!!";
    public static final String FILE_ERROR = "Error en la creación del archivo.";
    public static final String FILE_NULL = "El archivo es nulo";
    public static final String TEXT_CONTAINS_SPACES = "El texto ingresado contiene espacios";
    public static final String TEXT_NULL = "El texto ingresado es nulo";
    public static final String TEXT_INITIATION_NUMBERS = "El texto ingresado inicia con numeros";
    private static final Integer CODE_410 = 410;
    private static final Integer CODE_411 = 411;
    private static final Integer CODE_412 = 412;
    private static final Integer CODE_413 = 413;

    private static Map<Integer, String> errorMap;

    private static String _410 = "410: Extensión de imagen no permitida";
    private static String _411 = "411: Método no permitido";
    private static String _412 = "412: Usuario no registrado";
    private static String _413 = "413: No se detecta un solo rostro";
    private static String _400 = "400: Bad request";

    private Constants(){
        super();
    }

    public static String getError(int status) {
        createMap();
        return errorMap.containsKey(status) ? errorMap.get(status) : _400;
    }

    private static void createMap() {
        errorMap = new HashMap<Integer, String>();
        errorMap.put(CODE_410, _410);
        errorMap.put(CODE_411, _411);
        errorMap.put(CODE_412, _412);
        errorMap.put(CODE_413, _413);
    }

}
