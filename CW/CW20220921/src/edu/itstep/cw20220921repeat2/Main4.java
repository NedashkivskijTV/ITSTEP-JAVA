//package edu.itstep.cw20220921repeat2;
//
//import java.util.HashSet;
//import java.util.Objects;
//import java.util.Set;
//
//public class Main4 {
//
//    public static void main(String[] args) {
//        //Hash
//        User user1 = new User("Ivan", "Ivanenko");
//        User user2 = new User("Semen", "Semenenko");
//        User user3 = new User("Ivan", "Ivanenko");
//
//        Set<User> userSet = new HashSet<>();
//        userSet.add(user1);
//        userSet.add(user2);
//        userSet.add(user3);
//
//        /** Хеш-коди першого та останнього елементів бідуть різні, хоча вмість об'єктів однаковий
//         * Це відбувається через те, що на даний момент хеш-код дефакто генерується рандомним чином
//         * для кожного елемента та не залежить від його вмісту
//         * - для виправлення такого становища - щоб хеш-коди генерувались на основі даних - потрібно
//         * перевизначити методи equals() and hashCode() - можна через контекстне меню Generate */
//        System.out.println(user1.hashCode()); // 488970385 - до виправлення  ; 1319849522 - після перевизначення equals() and hashCode()
//        System.out.println(user2.hashCode()); // 1209271652 - до виправлення ; 636900850 - після перевизначення equals() and hashCode()
//        System.out.println(user3.hashCode()); // 93122545 - до виправлення   ; 1319849522 - після перевизначення equals() and hashCode()
//
//        System.out.println(userSet);
//
//        /** Некоректна поведінка, також спостерігається при порівнянні об'єктів */
//        // == порівнює об'єкти за посиланням
//        System.out.println(user1 == user3); // false (різні об'єкти - різні посилання) ; false - після перевизначення equals() and hashCode()
//
//        // equals() має порівнювати об'єкти за значенням, але за замовчуванням порівнює посилання
//        // equals() - метод батьківського класу Object,
//        // на даний час не значе про існування створеного нами класу User та
//        // не вміє порівнювати його екземпляри - клас User потребує перевизначення методу equals()
//        System.out.println(user1.equals(user3)); // false (працює некоректно - значення/вміст об'єктів однаковий) ; true - після перевизначення equals() and hashCode()
//
//        /** В результаті внесених змін, у колекції збереглись лише два уніукальних об’єкти,
//         * а застосованих метод equals() повернув true, оскільки порівнюються різні,
//         * але однакові за вмістом об’єкти */
//    }
//}
//
//class User {
//    private String firstName;
//    private String lastName;
//
//    public User(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                '}';
//    }
//
//
//    /** Перевизначені методи для порівняння об'єктів, генерування hash-коду */
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(firstName, lastName);
//    }
//}
