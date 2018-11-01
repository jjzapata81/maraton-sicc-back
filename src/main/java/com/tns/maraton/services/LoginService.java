package com.tns.maraton.services;


import com.tns.maraton.client.MaratonClient;
import com.tns.maraton.exceptions.BusinessException;
import com.tns.maraton.model.response.RecognizeResponse;
import com.tns.maraton.validators.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class LoginService {

    private static final String TIPO_DE_ARCHIVO_NO_PERMITIDO = "Tipo de archivo no permitido";

	private static final String EL_NOMBRE_DEL_USUARIO_COMIENZA_CON_UN_NUMERO = "El nombre del usuario comienza con un numero";

	private static final String HAY_ESPACIO_ENTRE_LAS_2_PALABRAS = "Hay espacio entre las 2 palabras";

	private static final String EL_VALOR_ES_MAYOR_A_15_CARACTERES = "El valor es mayor a 15 caracteres";

	private static final String VALOR_VACIO = "Valor vacío";

	private static final String ARCHIVO_NULO = "Archivo nulo";

	@Autowired
    private MaratonClient client;
    
    @Autowired
    private Validator validate;

    public RecognizeResponse compare(File file, String user) {
    	if(validate.isNotNull(file)) {
    		return client.compare(file, user);
    	}
    	throw new BusinessException(ARCHIVO_NULO);
    }

    public RecognizeResponse register(File file, String user) {
    	if(!validate.isLessThan15Characters(user)) {
    		throw new BusinessException(EL_VALOR_ES_MAYOR_A_15_CARACTERES);
    	}
    	if(validate.isEmpty(user)) {
    		throw new BusinessException(VALOR_VACIO);
    	}
    	if(validate.spaceBetween2Words(user)) {
    		throw new BusinessException(HAY_ESPACIO_ENTRE_LAS_2_PALABRAS);
    	}
    	if(validate.beginWithANumber(user)) {
    		throw new BusinessException(EL_NOMBRE_DEL_USUARIO_COMIENZA_CON_UN_NUMERO);
    	}
    	if(!validate.fileFormatAllowed(file)) {
    		throw new BusinessException(TIPO_DE_ARCHIVO_NO_PERMITIDO);
    	}
    	if(validate.isNotNull(file)) {
    		return client.register(file, user);
    	}
    	throw new BusinessException(ARCHIVO_NULO);
    }
}
