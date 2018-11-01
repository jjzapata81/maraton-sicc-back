package com.tns.maraton.services;


import com.tns.maraton.client.MaratonClient;
import com.tns.maraton.exceptions.BusinessException;
import com.tns.maraton.model.response.RecognizeResponse;
import com.tns.maraton.util.Constants;
import com.tns.maraton.validators.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class LoginService {

    @Autowired
    private MaratonClient client;

    @Autowired
    private Validate validate;

    public RecognizeResponse compare(File file, String user) {
        if (validate.isNotNull(file)) {
            return client.compare(file, user);
        }
        throw new BusinessException(Constants.FILE_NULL);
    }

    public RecognizeResponse register(File file, String user) {
        if (validate.isNotNull(file) || validate.isVoidChain(user)) {
            return client.register(file, user);
        }
        else{
            throw new BusinessException(Constants.TEXT_CONTAINS_SPACES);
        }
    }


}
