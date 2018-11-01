package com.tns.maraton.validators;

import static org.junit.Assert.*;

import com.tns.maraton.exceptions.BusinessException;
import org.junit.Test;
import org.springframework.test.context.TestExecutionListeners;


import java.io.File;

public class ValidateTest {

    private static final String FILE_NAME = "julian3.jpeg";
    private static final String FILE_TIGER = "tiger.jpg";

    private Validate validate = new Validate();

    @Test
    public void mustValidateFileIsNotNull() {
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        boolean isNotNull = validate.isNotNull(file);
        assertTrue(isNotNull);
    }

    @Test
    public void mustValidateFileIsNull() {

        File file = null;
        boolean isNotNull = validate.isNotNull(file);
        assertFalse(isNotNull);

    }

    @Test
    public void mustValidateUserNameUserIsVoid() {
        String chain = "";
        boolean isChainVoid = validate.isVoidChain(chain);
        assertTrue(isChainVoid);
    }
    @Test
    public void mustValidateUserNameIsNull() {

        String nameUser = null;
        boolean isNotNull = validate.isNotNull(nameUser);
        assertFalse(isNotNull);
    }
    @Test()
    public void mustValidateUserNameNotContainsSpace() {

        String nameUser= "DuverCarmona";
        boolean containsSpaces = validate.containsSpaces(nameUser);
        assertFalse(containsSpaces);
    }
    @Test(expected = BusinessException.class)
    public void mustValidateUserNameContainsSpace() {

        String nameUser= "Duver Carmona";
        boolean containsSpaces = validate.containsSpaces(nameUser);
        assertTrue(containsSpaces);
    }
    @Test(expected = BusinessException.class)
    public void mustValidateUserNameInitiationInNumbers()
    {
        String nameUser = "4Andres";
        boolean initiationInNumber = validate.initiationInNumber(nameUser);
        assertTrue(initiationInNumber);
    }
    @Test
    public void mustValidateUserNameNotInitiationInNumbers()
    {
        String nameUser = "Andres";
        boolean initiationInNumber = validate.initiationInNumber(nameUser);
        assertFalse(initiationInNumber);
    }
    @Test(expected = BusinessException.class)
    public void mustValidateContainsCharacterEspecial()
    {
        String nameUser = "Duv*erC$rmona";
        boolean containsCharactersEspecial =validate.containsCharactersEspecial(nameUser);
        assertTrue(containsCharactersEspecial);
    }
    @Test
    public void mustValidateNoContainsCharacterEspecial()
    {
        String nameUser = "DuverCarmona";
        boolean containsCharactersEspecial =validate.containsCharactersEspecial(nameUser);
        assertFalse(containsCharactersEspecial);
    }
    @Test(expected = BusinessException.class)
    public void mustValidatesNotSizeText(){
        String nameUser = "Du";
        boolean lenghtMaxAndMinText =validate.lengthMaxAndMinText(nameUser);
        assertTrue(lenghtMaxAndMinText);
    }
    @Test
    public void mustValidatesSizeText(){
        String nameUser = "ElBrayan";
        boolean lengthMaxAndMinText =validate.lengthMaxAndMinText(nameUser);
        assertFalse(lengthMaxAndMinText);
    }
    @Test (expected = BusinessException.class)
    public void mustValidatesUpSizeFile(){
        File file = new File(getClass().getClassLoader().getResource(FILE_TIGER).getFile());
        boolean sizeFile = validate.sizeFile(file);
        assertTrue(sizeFile);
    }
    @Test
    public void mustValidatesSizeFile(){
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        boolean sizeFile = validate.sizeFile(file);
        assertFalse(sizeFile);
    }
    }
