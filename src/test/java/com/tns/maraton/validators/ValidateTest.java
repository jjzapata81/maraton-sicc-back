package com.tns.maraton.validators;

import static org.junit.Assert.*;

import com.tns.maraton.exceptions.BusinessException;
import org.junit.Test;
import org.mockito.Mock;

import java.io.File;

public class ValidateTest {

    private static final String FILE_NAME = "julian3.jpeg";

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
    @Test
    public void mustValidateUserNameInitiationInNumbers()
    {
        String nameUser = "4ndres";
        boolean initiationInNumber = validate.initiationInNumber(nameUser);
        assertTrue(initiationInNumber);
    }

    }
