package com.tns.maraton.validators;

import static org.junit.Assert.*;
import org.junit.Test;


public class ValidateUserTest {
    private ValidateUser validateUser= new ValidateUser();
    @Test
    public void mustValidateUserIsNotNull(){
        String user = "juan";
        boolean isNotNull = validateUser.isNotNull(user);
        assertTrue(isNotNull);
    }

    @Test
    public void mustValidateUserIsNull(){
        String user = null;
        boolean isNotNull = validateUser.isNotNull(user);
        assertFalse(isNotNull);
    }

    @Test
    public void sizeMustHaveLeastThreeCharacters(){
        String user = "Ni";
        boolean haveMinimum = validateUser.size(user);
        assertFalse(haveMinimum);
    }
    @Test
    public void sizeMustHaveMaximunFifteenCharacters(){
        String user = "supercalifragilisticoespialidoso";
        boolean haveMaximum = validateUser.size(user);
        assertFalse(haveMaximum);
    }
    @Test
    public void sizeIsValidate(){
        String user = "Maria";
        boolean isValidate=validateUser.size(user);
        assertTrue(isValidate);
    }
    @Test
    public void userExist(){
        String user = "Maria";
        String[] users = {"Jose", "Jesus", "Maria"};
        boolean userExist=validateUser.existUser(user,users);
        assertTrue(userExist);
    }
    @Test
    public void userNotExist(){
        String user = "Maria";
        String[] users = {"Jose", "Jesus", "David"};
        boolean userExist=validateUser.existUser(user,users);
        assertFalse(userExist);
    }
    @Test
    public void haveNotNumber(){
        String user = "Diego";
        boolean number = validateUser.haveNumber(user);
        assertFalse(number);
    }
    @Test
    public void haveNumber(){
        String user = "5ebas";
        boolean number = validateUser.haveNumber(user);
        assertTrue(number);
    }
    @Test
    public void mustNotSpacing(){
        String user = "Susana";
        boolean spacing = validateUser.haveSpacing(user);
        assertFalse(spacing);
    }
    @Test
    public void mustSpacing(){
        String user = "Susana Oria";
        boolean spacing = validateUser.haveSpacing(user);
        assertTrue(spacing);
    }

}