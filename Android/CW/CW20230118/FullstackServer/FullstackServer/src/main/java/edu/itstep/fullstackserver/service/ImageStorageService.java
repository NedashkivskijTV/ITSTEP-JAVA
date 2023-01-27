package edu.itstep.fullstackserver.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageStorageService {

    void uploadImage(MultipartFile file); // завантаження файлу на сервер - в параметри приймає MultipartFile тип даних, який потрібен для отримання зображення

}
