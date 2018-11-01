package com.tns.maraton.services;

import com.tns.maraton.client.MaratonClient;
import com.tns.maraton.exceptions.BusinessException;
import com.tns.maraton.validators.ValidateFile;

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

    private File getFiles(){
        return new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
    }

    @InjectMocks
    private LoginService service;

    @Mock
    private ValidateFile validateFile;

    @Mock
    private MaratonClient client;

    @Test(expected = BusinessException.class)
    public void registerMustCallValidator(){
        File file = getFiles();
        service.register(file,"Juan");
        verify(validateFile).isNotNull(file);
    }
    @Test
    public  void  registerMustValidateIsNotNull(){
        File file = getFiles();
        when(validateFile.isNotNull(file)).thenReturn(true);
        service.register(file,"Juan");
        verify(client).register(file, "Juan");
    }
    @Test(expected = BusinessException.class)
    public void registerMustValidateIsNull(){
        File file =  null;
        service.register(file,"Juan");
        verify(client, times(0)).register(file, "Juan");

    }
    @Test(expected = BusinessException.class)
    public void registerMustThrowAnExceptionWhenFileIsNull(){
        service.register(null, "Juan");

    }

    @Test(expected = BusinessException.class)
    public  void compareMustCallValidator(){
        File file = getFiles();
        service.compare(file,"Juan");
        verify(validateFile).isNotNull(file);
    }

    @Test
    public void compareMustValidateIsNotNull(){
        File file = getFiles();
        when(validateFile.isNotNull(file)).thenReturn(true);
        service.compare(file,"Juan");
        verify(client).compare(file, "Juan");
    }
    @Test(expected = BusinessException.class)
    public void compareMustValidateIsNull(){
        File file =  null;
        service.compare(file,"Juan");
        verify(client, times(0)).compare(file, "Juan");

    }
    @Test(expected = BusinessException.class)
    public void compareMustThrowAnExceptionWhenFileIsNull(){
        service.compare(null, "Juan");

    }
}
