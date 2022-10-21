package edu.itstep.cw20221003_repeat.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE}) // @Target - вказує до яких об'єктів може застосовуватись анотація,
                                    // у якості параметрів приймає один або декілька елементів-ENUM ElementType
                                    // ANNOTATION_TYPE - другая аннотация
                                    // CONSTRUCTOR - конструктор класса
                                    // FIELD - поле класса
                                    // LOCAL_VARIABLE - локальная переменная
                                    // METHOD - метод класса
                                    // PACKAGE - описание пакета
                                    // PARAMETER - параметр метода (public void hello(@Annontation String param){})
                                    // TYPE - указывается над классом
                                    // якщо параметр не вказати - застосуються усі наявні варіанти ElementType

@Retention(RetentionPolicy.RUNTIME) // задає час життя анотації - приймає оий екземпляр ENUM  RetentionPolicy
                                    // SOURCE - анотація існує лише в ісходному коді (після компіляції у байт-код не піде)
                                    // CLASS - у байт-коді існуватиме, після запуску програми - ні
                                    // RUNTIME - анотація буде існувати під час робота віртуальної машини
                                    // - можна звернутись до неї програмним чином та отримати інф
@Inherited // налаштування - забезпечує передачу анотації у спадщину - при настлідуванні від даного класа іншим
public @interface FirstAnnotation {
    // Анотація може містити
    public static final int KEY = 7; // статичні змінні - константи
    @Deprecated(since = "v1.5", forRemoval = true) int KEY0 = 77;
    // Щоб помітити метод застарілим потрібно вказати анноиацію @Deprecated
    // – при виклику такого метода у списку доступних методів він відображатиметься перекресленим
    // параметри: since - версія з якої параметр буде відображатись застарілим,
    // forRemoval - з вищих версій за вказану у since параметр видалятиметься

    // Створення параметрів анотації
    // після вказання параметрів, їх потрібно прописувати при кожному випадку використання анотації
    int key1(); // int - тип даних, що зберігатиметься у значенні key1
    int key2()  default KEY; // default - значення параметра за замовчуванням
    // - при використання анотації параметр можна не прописувати (@FirstAnnotation(key1 = 7) ; @FirstAnnotation(key1 = 7, key2 = 77))

}