package com.tns.maraton.util;

import com.tns.maraton.exceptions.BusinessException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class FileUtil {

    private FileUtil(){super();}

    public static File convert(MultipartFile file) {
        try{
            File convertFile = new File(file.getOriginalFilename());
            convertFile.createNewFile();
            try(FileOutputStream fos = new FileOutputStream(convertFile)) {
                fos.write(file.getBytes());

                return convertFile;
            }
        }catch (IOException e){
            throw new BusinessException(Constants.FILE_ERROR, e);
        }
    }
}
