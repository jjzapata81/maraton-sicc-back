package com.tns.maraton.validators;

import org.springframework.stereotype.Service;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

@Service
public class Validate {

    ArrayList users = new ArrayList<String>();

    public boolean isNotNull(File file) {
        return null != file;
    }

    public boolean isNotNull(String user) {
        return null != user;
    }

    public boolean userExist(String user1, String user2) {
        return user1.equals(user2);
    }

    public boolean validExtention(String file){

      int tamano= file.length();
      String extension= file.substring((tamano-4),tamano);
      String extension2= file.substring((tamano-3),tamano);
      boolean retorno= false;

      if(extension.equals("jpeg")||extension2.equals("jpg")||extension2.equals("png")){
          retorno= true;
      }
      return retorno;

    }
    public boolean validUser(String user) {

        String[] usuarios = {"Yesid", "Santiago", "XXX", "65456", "Sansan"};

        for (int i = 0; i < usuarios.length; ++i) {
            if (user.equals(usuarios[i])) {
                return true;
            }
        }
        return false;
    }



}
