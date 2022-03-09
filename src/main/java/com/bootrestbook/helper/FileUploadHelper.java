package com.bootrestbook.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {

    //--------------Static Path----------------
//    private final String UPLOAD_FILE = "/home/adi/Documents/Spring Boot Tutorial/bootrestapi/src/main/resources/static/image";

    //--------------Dynamic Path----------------
    private final String UPLOAD_FILE = new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public FileUploadHelper () throws IOException {

    }

    public boolean uploadFile(MultipartFile file) {
        boolean f = false;

        try {

            //----------------First Way---------------------------

//            InputStream is = file.getInputStream();
//            byte []data = new byte[is.available()];
//            is.read(data);
//
//            // Write
//            FileOutputStream fos = new FileOutputStream(UPLOAD_FILE + File.separator + file.getOriginalFilename());
//            fos.write(data);
//
//            fos.flush();
//            fos.close();
//            is.close();

            //----------------Second Way---------------------------

            Files.copy(file.getInputStream(), Paths.get(UPLOAD_FILE + File.separator + file.getOriginalFilename()),
                        StandardCopyOption.REPLACE_EXISTING);

            f = true;
        }catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
}
