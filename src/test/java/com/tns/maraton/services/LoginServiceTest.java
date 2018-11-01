package com.tns.maraton.services;

import com.tns.maraton.client.MaratonClient;
import com.tns.maraton.exceptions.BusinessException;
import com.tns.maraton.validators.Validate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static  org.mockito.Mockito.*;

import java.io.File;
import java.util.ArrayList;


@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    private static final String FILE_NAME = "julian3.jpeg";
    private static final String USER = "juan";

    @Mock
    private MaratonClient client;

    @Mock
    private Validate validate;

    @InjectMocks
    private LoginService service;

    @Test(expected = BusinessException.class)
    public void registerMustCallValidate(){
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        service.register(file, USER);
        verify(validate).fileIsNotNull(file);
        verify(validate).userIsNotNull(USER);
    }

    @Test
    public void mustValidateIsNotNull(){
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        when(validate.fileIsNotNull(file)).thenReturn(true);
        service.register(file, USER);
       verify(client).register(file,USER);
    }

    @Test(expected = BusinessException.class)
    public void mustValidateIsNull(){
        File file = null;
        service.register(file, USER);
        verify(client, Mockito.times(0)).register(file, USER);
    }

    @Test(expected = BusinessException.class)
    public void mustValidateUserIsNull(){
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        service.register(file, null);
        verify(validate).userIsNotNull(null);
    }

    @Test(expected = BusinessException.class)
    public void mustValidateUserIsNotNull(){
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        service.register(file, USER);
        verify(validate).userIsNotNull(USER);
    }

    @Test(expected = BusinessException.class)
    public void compareMustCallValidate(){
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        service.compare(file, USER);
        verify(validate).fileIsNotNull(file);
        verify(validate).userIsNotNull(USER);
    }

    @Test(expected = BusinessException.class)
    public void mustValidateataIsNotNull(){
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        when(validate.userIsNotNull(USER)).thenReturn(true);
        service.compare(file, USER);
        verify(client).compare(file,USER);
    }

    @Test(expected = BusinessException.class)
    public void registerMustCallValidateMethods(){
        ArrayList<String> baseDatosUsuarios = new ArrayList<>();
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        service.register(file,USER);
        verify(validate).userIsNotNull(USER);
        verify(validate).lengthName(USER);
        verify(validate).encontrarUsuario(USER,baseDatosUsuarios);


    }




}
