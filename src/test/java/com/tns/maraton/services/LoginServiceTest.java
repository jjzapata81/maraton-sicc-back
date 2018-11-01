package com.tns.maraton.services;

import com.tns.maraton.client.MaratonClient;
import com.tns.maraton.exceptions.BusinessException;
import com.tns.maraton.validators.Validate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.util.Objects;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    @InjectMocks
    private LoginService service;

    @Mock
    private MaratonClient client;

    @Mock
    private  Validate validate;

    private static final String FILE_NAME= "julian3.jpeg";
    private static final String USER="YESID";

    @Test(expected = BusinessException.class)
    public void registerMustCallValidator(){
        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(FILE_NAME)).getFile());
        service.register(file, "Juan");
        verify(validate).isNotNull(file);
    }

    @Test(expected = BusinessException.class)
    public void mustValidateIsNotNull(){
        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(FILE_NAME)).getFile());
        when(validate.isNotNull(file)).thenReturn(true);
        service.register(file, "juan");
        verify(client).register(file, "juan");
    }

    @Test(expected = BusinessException.class)
    public void mustValidateIsNull(){
        File file = null;
        service.register(file, "juan");
        verify(client,times(0)).register(file, "juan");
    }

    @Test(expected = BusinessException.class)
    public void mustThrowAnExceptionWhenFileIsNull(){
        service.register(null,"juan");
    }




}
