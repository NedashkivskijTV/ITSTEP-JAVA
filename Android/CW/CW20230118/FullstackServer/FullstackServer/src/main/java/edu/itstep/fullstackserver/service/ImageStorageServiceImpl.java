package edu.itstep.fullstackserver.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
// спеціалізація анотації @Component (простір імен import org.springframework.stereotype.Service) – Spring @Service використовується з класами, що надають певні бізнес-функції. SpringContext автоматично визначає ці класи при використанні конфігурації на основі анотацій та сканнування шляху до класів
public class ImageStorageServiceImpl implements ImageStorageService {

    @Value("${upload.path}")
    // ініціалізує змінну певним значенням - звертається до змінної upload.path у файлі application.property - дана конструкція полегшує редагування шляху збереження файлів, у разі потреби це відбувається у конфігураційному файлі (не потрібно ходити по структурі, по java-коду у пошуках відповідних змінних - зміни вносяться в одному місці)
    private String uploadPath; // змінна класу, що зберігає шлях до папки, де зберігатимуться файли

    @Override
    public void uploadImage(MultipartFile file) {

        // Створення директорії для збереження даних
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) { // створення директорії у разі відсутності
            uploadDir.mkdir();
        }

        // Створення унікальної послідовності символів (інстументарій Java) - використовується, як частина назви отриманого файла за якою (назвою) він буде збережений при отриманні
        String uuiFile = UUID.randomUUID().toString();

        // Створення нової назви файла за якою він буде збережений при отриманні - складається з вищесформованої унікальної послідовності + ім'я файлу, яке він мав при відправці
        String resultFileName = uuiFile + "." + file.getOriginalFilename();

        System.out.println(resultFileName); // тестовий роздрук у консоль нової назви файлу

        // Запис отриманого файлу за допомогою класу FileOutputStream (з отриманого у параметрах MultipartFile file
        // витягуються байти та записуються у потік) - потребує обернення у try-catch блок
        // використовується try з ресурсами
        try (FileOutputStream outputStream = new FileOutputStream(uploadDir + "/" + resultFileName)) {
            outputStream.write(file.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
