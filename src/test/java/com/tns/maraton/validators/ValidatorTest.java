package com.tns.maraton.validators;

import com.tns.maraton.exceptions.BusinessException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.io.File;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ValidatorTest {

   private static final String FILE_NAME = "julian3.jpeg";
    private static final String USER = "juan";

    @InjectMocks
    private Validate validate;


    @Test
    public void mustValidateIfFileIsNull() {
        Validate validate = new Validate();
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        boolean isNotNull = validate.fileIsNotNull(file);
        Assert.assertTrue(isNotNull);
    }


    @Test(expected = BusinessException.class)
    public void mustValidateIfUserDoesNotExists(){
        Validate validate = new Validate();

        ArrayList<String> baseDatosUsuarios = new ArrayList<>();

        Assert.assertEquals(null,validate.encontrarUsuario(USER, baseDatosUsuarios));

    }

    @Test(expected = Exception.class)
    public void mustValidateIfUserExists(){

        //Validate validate = new Validate();

        ArrayList<String> baseDatosUsuarios = new ArrayList<>();
        baseDatosUsuarios.add("ramiro");
        baseDatosUsuarios.add("juan");
        baseDatosUsuarios.add("excsle");

        String usuario = validate.encontrarUsuario(USER, baseDatosUsuarios);
        Assert.assertEquals(USER,usuario);

    }

    @Test
    public void cannotContainNumericDigit(){
        Validate validate = new Validate();

        boolean nameWithNumbers= validate.digitInit("Javier12");
        Assert.assertFalse(nameWithNumbers);
    }

    @Test
    public void userLengthCannotOverPassTenCharacters(){
        Validate validate = new Validate();

        boolean lengthOfName = validate.lengthName(USER);

        Assert.assertEquals(true, lengthOfName);
    }





}
