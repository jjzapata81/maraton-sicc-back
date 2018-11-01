package com.tns.maraton.validators;

import com.tns.maraton.exceptions.BusinessException;
import com.tns.maraton.util.Constants;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class Validate {

    public <T> boolean isNotNull(T object) {
        return null != object;

    }

    public boolean isVoidChain(String text) {
        return !isNotNull(text) || text.isEmpty();
    }

    public boolean containsSpaces(String text) {
        if (!isNotNull(text) || text.trim().contains(" ")) {
            throw new BusinessException(Constants.TEXT_CONTAINS_SPACES);
        }
        return false;
    }

    public boolean initiationInNumber(String text) {

       if(text.trim().indexOf(0)==
        return true;

    }

}

