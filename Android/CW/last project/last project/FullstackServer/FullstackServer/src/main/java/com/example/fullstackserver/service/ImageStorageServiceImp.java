package com.example.fullstackserver.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImageStorageServiceImp implements ImageStorageService{
    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public void uploadImage(MultipartFile file) {
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String uuiFile = UUID.randomUUID().toString();
        String resultFileName = uuiFile + "." + file.getOriginalFilename();
        System.out.println(resultFileName);
        try (FileOutputStream outputStream = new FileOutputStream(uploadDir + "/" + resultFileName)) {
            outputStream.write(file.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
