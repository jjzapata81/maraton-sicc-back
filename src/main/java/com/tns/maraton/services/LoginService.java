package com.tns.maraton.services;

import com.tns.maraton.client.MaratonClient;
import com.tns.maraton.exceptions.BusinessException;
import com.tns.maraton.model.response.RecognizeResponse;
import com.tns.maraton.validators.ValidateFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class LoginService {

    @Autowired
    private MaratonClient client;
    @Autowired
    private ValidateFile validateFile;


    public RecognizeResponse compare(File file, String user) {
        if(validateFile.isNotNull(file)){
            return client.compare(file, user);
        }
        throw new BusinessException("Archivo null");
    }

    public RecognizeResponse register(File file, String user) {
        if(validateFile.isNotNull(file)){
            return client.register(file, user);
        }

        throw new BusinessException("Archivo null");
    }
}