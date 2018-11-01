package com.tns.maraton.validators;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.*;

public class ValidatorTest {

    private static final String FILE_NAME = "margot.jpg";
    private static final String USER_NAME = "margot";

    @Test
    public void mustValidateIsNotNullFile() {
        Validate validate = new Validate();
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        boolean isNotNullFile = validate.isNotNullFile(file);
        assertTrue(isNotNullFile);
    }

    @Test
    public void mustValidateIsNullFile(){
        Validate validate = new Validate();
        File file = null;
        boolean isNullFile = validate.isNotNullFile(file);
        assertFalse(isNullFile);
    }

    @Test
    public void mustValidateIsEmptyFile(){
        Validate validate = new Validate();
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        boolean isNotEmptyFile = validate.isNotEmptyFile(file);
        assertTrue(isNotEmptyFile);
    }

    @Test
    public void mustValidateIsNotNullUser() {
        Validate validate = new Validate();
        String user = USER_NAME;
        boolean isNotNullUser = validate.isNotNullUser(user);
        assertTrue(isNotNullUser);
    }

    @Test
    public void mustValidateIsNullUser(){
        Validate validate = new Validate();
        String user = null;
        boolean isNullUser = validate.isNotNullUser(user);
        assertFalse(isNullUser);
    }

    @Test
    public void mustValidateIsEmptyUser(){
        Validate validate = new Validate();
        String user = USER_NAME;
        boolean isNotEmptyUser = validate.isNotEmptyUser(user);
        assertTrue(isNotEmptyUser);
    }

    @Test
    public void mustValidateWithSpacesInUser(){
        Validate validate = new Validate();
        String user = USER_NAME;
        boolean isWithSpacesUser = validate.isWithtSpaceUser(user);
        assertFalse(isWithSpacesUser);
    }

    @Test
    public void mustValidateWithInitNumberUser(){
        Validate validate = new Validate();
        String user = USER_NAME;
        boolean isWithInitNumberUser = validate.isWithInitNumberUser(user);
        assertFalse(isWithInitNumberUser);
    }

    @Test
    public void mustValidateTypeFile(){
        Validate validate = new Validate();
        String file = FILE_NAME;
        boolean isValidateTypeFile = validate.isValidateTypeFile(file);
        assertTrue(isValidateTypeFile);
    }

}