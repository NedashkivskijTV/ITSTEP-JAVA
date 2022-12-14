package edu.itstep.cw20220905;

public class User {
    private String firstName;
    private String lastName;
    public int age;
    protected String phone; // доступ отримує наслідник або в поточному пекеджі
    String email; // default / package private

    /*
public: публичный, общедоступный класс или член класса. Поля и методы, объявленные с
модификатором public, видны другим классам из текущего пакета и из внешних пакетов.

private: закрытый класс или член класса, противоположность модификатору public.
Закрытый класс или член класса доступен только из кода в том же классе.

protected: такой класс или член класса доступен из любого места в текущем классе или
пакете или в производных классах, даже если они находятся в других пакетах

Модификатор по умолчанию (package private). Отсутствие модификатора у поля или метода класса
предполагает применение к нему модификатора по умолчанию. Такие поля или методы
видны всем классам в текущем пакете.
https://metanit.com/java/tutorial/3.3.php#:~:text=%D0%92%20Java%20%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D1%83%D1%8E%D1%82%D1%81%D1%8F%20%D1%81%D0%BB%D0%B5%D0%B4%D1%83%D1%8E%D1%89%D0%B8%D0%B5%20%D0%BC%D0%BE%D0%B4%D0%B8%D1%84%D0%B8%D0%BA%D0%B0%D1%82%D0%BE%D1%80%D1%8B,%D1%87%D0%BB%D0%B5%D0%BD%20%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%B0%2C%20%D0%BF%D1%80%D0%BE%D1%82%D0%B8%D0%B2%D0%BE%D0%BF%D0%BE%D0%BB%D0%BE%D0%B6%D0%BD%D0%BE%D1%81%D1%82%D1%8C%20%D0%BC%D0%BE%D0%B4%D0%B8%D1%84%D0%B8%D0%BA%D0%B0%D1%82%D0%BE%D1%80%D1%83%20public.
     */

    /*
    Инкапсуляция
Казалось бы, почему бы не объявить все переменные и методы с модификатором public,
чтобы они были доступны в любой точке программы вне зависимости от пакета или класса?
Возьмем, например, поле age, которое представляет возраст. Если другой класс имеет прямой
 доступ к этому полю, то есть вероятность, что в процессе работы программы ему будет передано
 некорректное значение, например, отрицательное число. Подобное изменение данных не является
 желательным. Либо же мы хотим, чтобы некоторые данные были достуны напрямую, чтобы их можно
 было вывести на консоль или просто узнать их значение. В этой связи рекомендуется как
 можно больше ограничивать доступ к данным, чтобы защитить их от нежелательного доступа
 извне (как для получения значения, так и для его изменения). Использование различных
 модификаторов гарантирует, что данные не будут искажены или изменены не надлежащим
 образом. Подобное сокрытие данных внутри некоторой области видимости называется инкапсуляцией.
https://metanit.com/java/tutorial/3.3.php#:~:text=%D0%92%20Java%20%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D1%83%D1%8E%D1%82%D1%81%D1%8F%20%D1%81%D0%BB%D0%B5%D0%B4%D1%83%D1%8E%D1%89%D0%B8%D0%B5%20%D0%BC%D0%BE%D0%B4%D0%B8%D1%84%D0%B8%D0%BA%D0%B0%D1%82%D0%BE%D1%80%D1%8B,%D1%87%D0%BB%D0%B5%D0%BD%20%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%B0%2C%20%D0%BF%D1%80%D0%BE%D1%82%D0%B8%D0%B2%D0%BE%D0%BF%D0%BE%D0%BB%D0%BE%D0%B6%D0%BD%D0%BE%D1%81%D1%82%D1%8C%20%D0%BC%D0%BE%D0%B4%D0%B8%D1%84%D0%B8%D0%BA%D0%B0%D1%82%D0%BE%D1%80%D1%83%20public.
     */
}
