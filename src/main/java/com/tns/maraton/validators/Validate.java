package com.tns.maraton.validators;



import com.tns.maraton.exceptions.BusinessException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;

@Service
public class Validate {



    public boolean fileIsNotNull(File file) {
        return null!=file;
    }

    public boolean userIsNotNull(String user) {
        return null!=user;
    }

    public String encontrarUsuario(String user, ArrayList<String> usuarios){
        String usuarioEncontrado=null;

        for (String usuario: usuarios) {
            if(usuario == user){
                usuarioEncontrado = user;

            }
        }

        if(usuarioEncontrado!= null){
            return usuarioEncontrado;
        }

        throw new BusinessException("Usuario no encontrado");



    }


    public Boolean digitInit(String user) {
        boolean flag = true;
        for(int index=0; index<user.length(); index++){
            if(Character.isDigit(user.charAt(index))){
                flag=false;
                break;
            }

        }
        return flag;

    }


    public boolean lengthName(String user) {
        return (user.length()<=10);
    }


}
