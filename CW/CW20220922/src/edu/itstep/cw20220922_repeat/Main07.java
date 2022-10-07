package edu.itstep.cw20220922_repeat;

import java.io.*;

public class Main07 {
    public static void main(String[] args) {
        // Запис / зчитування об'єктів - класи ObjectOutputStream, ObjectInputStream
        // Використвується для : створення глибокої копії об'єкта (без створення файлу)
        // повертає помилку IOException
        // потребує обгорання (по Alt + Enter) у блок try/catch (Surround with try/catch),
        // або передачі помилки на вищий рівень (Add exception to method signature)

        User user = new User("Petro--", "Petrenko");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // запис у файл ------------------------------------------------------------------------------------------------
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
            outputStream.writeObject(user); // ObjectOutputStream - здійснює серіалізацію - дані з об'єкта переводить у байтовий поток при цьому об'єкт має
                                            // імплементувати інтерфейс Serializable (маркерний інтерфейс) та зберігає дані у об'єкт byteArrayOutputStream
                                            // дані зберігаються в оперативній памяті, а не у файлі
        } catch (IOException e) {
            e.printStackTrace();
        }

        // читання з файлу ---------------------------------------------------------------------------------------------
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())); // метод toByteArray() - переводить байтовий потік у масив байтів
            User newUser = (User) objectInputStream.readObject(); // отримується Object та приводиться до User
            System.out.println(user.getFirstName());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // передавання масиву байтів у інший потік через метод writeTo()
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String text = "Hello Wolrd!";
        byte[] buffer = text.getBytes();
        try{
            baos.write(buffer);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        try(FileOutputStream fos = new FileOutputStream("hello.txt")){

            baos.writeTo(fos);
        }
        catch(IOException e){

            System.out.println(e.getMessage());
        }

    }
}
