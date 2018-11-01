package com.tns.maraton.validators;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;

public class ValidateFileTest {

    private static final String FILE_NAME = "julian3.jpeg";
    private ValidateFile validateFile = new ValidateFile();
    private File file;

    private File getFiles(String name){
        return new File(getClass().getClassLoader().getResource(name).getFile());
    }

   @Test
   public void mustValidateFileIsNotNull(){
       file = getFiles(FILE_NAME);
       boolean isNotNull = validateFile.isNotNull(file);
       assertTrue(isNotNull);
   }
    @Test
    public void mustValidateFileIsNull(){
        file = null;
        boolean isNotNull = validateFile.isNotNull(file);
        assertFalse(isNotNull);
    }
    @Test
    public void mustBeMinusThanFiveMG(){
       file = getFiles(FILE_NAME);
       boolean size = validateFile.length(file);
       assertTrue(size);
    }
    @Test
    public void mustNotBeMinusThanFiveMG(){
        file = getFiles("space.jpeg");
        boolean size = validateFile.length(file);
        assertFalse(size);
    }
}
