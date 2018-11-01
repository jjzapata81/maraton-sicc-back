package com.tns.maraton.validators;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;

@Service
public class Validate {

    public boolean isNotNullFile(File file) {
        return  null != file;
    }

    public boolean isNotNullUser(String user){
        if(user != null){
            return true;
        }

        return  false;
    }

    public boolean isNotEmptyFile(File file) {
        if(file.canRead()){
            return true;
        }
        return false;
    }

    public boolean isNotEmptyUser(String user) {
       if(user.isEmpty()){
           return false;
       }
        return true;
    }

    public boolean isWithtSpaceUser(String user) {

        if(user.split(" ").length > 1){
            return true;
        }

        return false;
    }

    public boolean isWithInitNumberUser(String user) {
        char numero = user.charAt(0);
        if(Character.isDigit(numero)){
            return true;
        }
        return false;
    }

    public boolean isValidateTypeFile(String file) {
        String tipeFileJPGyPNG = file.substring(file.length()-4);
        String tipeFileJPEG = file.substring(file.length()-5);
        if(".jpg".equals(tipeFileJPGyPNG) || ".png".equals(tipeFileJPGyPNG) || ".jpeg".equals(tipeFileJPEG)){
            return true;
        }

        return false;
    }
}
