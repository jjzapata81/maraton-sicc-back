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

        if (!isNotNull(text)|| Character.isDigit(text.trim().charAt(0))) {

            throw  new BusinessException(Constants.TEXT_INITIATION_NUMBERS);

        }
        return false;

    }

    public boolean containsCharactersEspecial(String text) {
        if(!isNotNull(text)|| !text.trim().matches("^[a-z-A-Z0-9]+$")){
            throw  new BusinessException(Constants.TEXT_CONTAINS_CHARACTERS_ESPECIALS);
        }
        return false;
    }

    public boolean lengthMaxAndMinText(String text) {
        if (!isNotNull(text) || !(text.trim().length()>=3 && text.trim().length()<=30)) {
            throw new BusinessException(Constants.TEXT_SIZE_INVALID);
        }
        return false;
    }
    public boolean sizeFile (File file){
        if(!isNotNull(file) || file.length()>=205000){
            throw new BusinessException(Constants.FIlE_SIZE_INVALID);
        }
        return false;
    }

}

