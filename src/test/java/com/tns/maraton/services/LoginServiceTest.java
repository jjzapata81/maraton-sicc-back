package com.tns.maraton.services;

import com.tns.maraton.client.MaratonClient;
import com.tns.maraton.exceptions.BusinessException;
import com.tns.maraton.validators.Validate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    private static final String FILE_NAME = "margot.jpg";
    private static final String USER_NAME = "margot";

    @Mock
    private MaratonClient client;

    @Mock
    private  Validate validate;

    @InjectMocks
    private LoginService service;

    @Test(expected = BusinessException.class)
    public void registerMustCallValidatorFile(){
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        service.register(file, "");
        verify(validate).isNotNullFile(file);
    }

    @Test
    public void mustValidateIsNotNullFile(){
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        when(validate.isNotNullFile(file)).thenReturn(true);
        when(validate.isNotNullUser("juan")).thenReturn(true);
        service.register(file, "juan");
        verify(client).register(file, "juan");
    }

    @Test(expected = BusinessException.class)
    public void mustValidateIsNullFile(){
        File file = null;
        service.register(file, "");
        verify(client, times(0)).register(file, "");
    }

    @Test(expected = BusinessException.class)
    public void mustThrowAnExceptionWhenFileIsNull(){
            service.register(null, "");
    }

    @Test(expected = BusinessException.class)
    public void mustValidateIsEmptyFile(){
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        service.register(file, "");
        verify(validate).isNotEmptyFile(file);
    }

    @Test(expected = BusinessException.class)
    public void registerMustCallValidatorUser(){
        String user = USER_NAME;
        service.register(null, user);
        verify(validate).isNotNullUser(user);
    }

    @Test
    public void mustValidateIsNotNullUser(){
        String user = USER_NAME;
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        when(validate.isNotNullUser(user)).thenReturn(true);
        when(validate.isNotNullFile(file)).thenReturn(true);
        service.register(file,user);
        verify(client).register(file, user);
    }

    @Test(expected = BusinessException.class)
    public void mustValidateIsNullUser(){
        String user = null;
        service.register(null,user);
        verify(client, times(0)).register(null, user);
    }

    @Test(expected = BusinessException.class)
    public void mustThrowAnExceptionWhenUserIsNull(){
        service.register(null, null);
    }

    @Test(expected = BusinessException.class)
    public void mustValidateWithInitNumberUser(){
        String user = USER_NAME;
        service.register(null, user);
        verify(validate).isWithInitNumberUser(user);
    }

    @Test(expected = BusinessException.class)
    public void mustValidateWithSpacesInUser(){
        String user = USER_NAME;
        service.register(null, user);
        verify(validate).isWithtSpaceUser(user);
    }

    @Test(expected = BusinessException.class)
    public void mustValidateIsEmptyUser(){
        String user = USER_NAME;
        service.register(null, user);
        verify(validate).isNotEmptyUser(user);
    }


}
