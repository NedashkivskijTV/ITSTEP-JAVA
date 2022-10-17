package edu.itstep.cw20221003_repeat.practice;

// Практичне завдання - спільне використанні Анотацій та Рефлексії
// - створити метод, який буде друкувати інф про об'єкт, але що саме
// друкуватиметься визначатиме власноруч створена анотація

public class User {
    @AllowPrint
    private String firstName;
    @AllowPrint(true)
    private String lastName;

    @AllowPrint(false)
    private String phone;

    private String mail;

    public User(String firstName, String lastName, String phone, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.mail = mail;
    }

}
