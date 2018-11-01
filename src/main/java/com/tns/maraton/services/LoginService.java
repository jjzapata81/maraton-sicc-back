package com.tns.maraton.services;


import com.tns.maraton.client.MaratonClient;
import com.tns.maraton.exceptions.BusinessException;
import com.tns.maraton.model.response.RecognizeResponse;
import com.tns.maraton.validators.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;


@Service
public class LoginService {

    private ArrayList<String> baseDatosUsuarios = new ArrayList<>();

    @Autowired
    private MaratonClient client;

    @Autowired
    private Validate validate;


    public RecognizeResponse compare(File file, String user) {
        //return client.compare(file, user);

        if(register(file,user)!=null){

        }

        throw new BusinessException("");
    }

    public RecognizeResponse register(File file, String user) {

        String mensaje = "";

        if( validate.fileIsNotNull(file)){
            return client.register(file, user);
        }
        else {
            mensaje = mensaje+" Archivo nulo";
        }

        if(validate.userIsNotNull(user)) {

            if(validate.lengthName(user)){

                if(validate.encontrarUsuario(user, baseDatosUsuarios)!= null){
                    mensaje = "Ya existe el usuario";
                }
                else {
                    baseDatosUsuarios.add(user);
                }
            }else{
                mensaje = "Tamaño excedido";
            }



            return client.register(file, user);

        }else {
            mensaje = mensaje + " Usuario nulo";
        }


        throw new BusinessException(mensaje);
    }



}
