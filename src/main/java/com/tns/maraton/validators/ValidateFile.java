package com.tns.maraton.validators;

import org.springframework.stereotype.Service;

import java.io.File;
@Service
public class ValidateFile {

    public boolean isNotNull(File file) {
        return null != file;
    }

    public boolean length(File file) {
        if(file.length()<5242880) return true;
        else return false;
    }

}
