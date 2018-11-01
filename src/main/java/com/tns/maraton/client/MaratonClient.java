package com.tns.maraton.client;

import com.tns.maraton.model.response.RecognizeResponse;
import com.tns.maraton.util.Constants;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class MaratonClient extends ClientBase{

    public RecognizeResponse register(File imageFile, String user) {

        return consumeService(imageFile, user, Constants.REGISTER, RecognizeResponse.class);
    }

    public RecognizeResponse compare(File imageFile, String user) {
        return consumeService(imageFile, user, Constants.COMPARE, RecognizeResponse.class);
    }

}
