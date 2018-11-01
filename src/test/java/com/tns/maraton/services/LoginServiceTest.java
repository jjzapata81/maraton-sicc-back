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

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {
    private static final String FILE_NAME = "julian3.jpeg";
    @InjectMocks
    private LoginService service;

    @Mock
    private MaratonClient client;
    @Mock
    private Validate validate;


    @Test(expected = BusinessException.class)
    public void registerMustCallValidator() {

        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        service.register(file, "Juan");
        verify(validate).isNotNull(file);
    }

    @Test
    public void mustValidateIsNotNull() {
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        when(validate.isNotNull(file)).thenReturn(true);
        service.register(file, "Juan");
        verify(client).register(file, "Juan");
    }

    @Test(expected = BusinessException.class)
    public void mustValidateIsNull() {
        File file = null;
        service.register(file, "Juan");

        verify(client, times(0)).register(file, "Juan");
    }

    @Test(expected = BusinessException.class)
    public void mustThrowAnExceptionWhenFileIsNull() {
        service.register(null, "Juan");

    }

   @Test(expected = BusinessException.class)
    public void compareMustCallValidator() {
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
        service.compare(file, "Juan");
        verify(validate).isNotNull(file);
    }

}
