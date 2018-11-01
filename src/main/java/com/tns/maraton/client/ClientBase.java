package com.tns.maraton.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tns.maraton.util.Constants;
import com.tns.maraton.util.UtilityClient;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.IOException;

@Component
public class ClientBase {

    protected <T> T consumeService(File imageFile, String user, String context, Class<T> valueType) {
        try {
            UtilityClient multipart = new UtilityClient(Constants.URL_SERVICE + context, Constants.CHARSET);
            multipart.addFormField(Constants.USER_PARAM, user);
            multipart.addFilePart(Constants.FILE_NAME_PARAM, imageFile);
            String response = multipart.finish();
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response, valueType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
