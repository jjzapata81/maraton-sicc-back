package com.tns.maraton.validators;

import static org.junit.Assert.*;


import org.junit.Test;
import java.io.File;
import java.util.Objects;



public class ValidatorTest {

    private static final String FILE_NAME= "julian3.jpeg";
    private static final String USER="Yesid";
    private static Validate validate=new Validate();
    private static final String USERNULL=null;

    @Test
    public void mustValidateFileIsNotNull(){

        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(FILE_NAME)).getFile());
        boolean isNotNull= validate.isNotNull(file);
        assertTrue(isNotNull);
    }

    @Test
    public void mustValidateIsNull(){
        File file= null;
        boolean isNotNull= validate.isNotNull(file);
        assertFalse(isNotNull);
    }

    @Test
    public void userIsNotNull(){
        boolean isNotNull= validate.isNotNull(USER);
        assertTrue(isNotNull);
    }

    @Test
    public void userIsNull(){
        boolean isNotNull= validate.isNotNull(USERNULL);
        assertFalse(isNotNull);
    }


    @Test
    public void userExist(){
       String user2= "Yesid";
       boolean userExist= validate.userExist(USER,user2);
        assertTrue(userExist);
    }

    @Test
    public void userNotExist(){
        String user2= "santi";
        boolean userExist= validate.userExist(USER,user2);
        assertFalse(userExist);
    }

   @Test
    public void validExtention(){

       boolean validExtention= validate.validExtention(FILE_NAME);
       assertTrue(validExtention);
   }

    @Test
    public void noValidExtention(){

        boolean validExtention= validate.validExtention("hola.parcero");
        assertFalse(validExtention);
    }

   @Test
    public void validUser(){
        String user="Yesid";
        boolean validUser = validate.validUser(user);
       assertTrue(validUser);
    }

    @Test
    public void noValidUser(){
        String user="lola";
        boolean validUser = validate.validUser(user);
        assertFalse(validUser);
    }
    

}
