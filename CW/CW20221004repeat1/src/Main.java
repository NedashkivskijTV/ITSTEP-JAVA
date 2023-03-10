import java.util.List;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        /** Метод створення таблиці у відповідній БД */
        Db.createUsersTable();


        /** Створення об'єкта User */
        User user = new User("Ivan", "Franko");
        User userLesya = new User("Lesya", "Ukrainka");
        User userTest = new User("test", "test-test");

        /** Метод Додавання/вставки даних (об'єкта User) до БД */
        // Рядок закоментовано після додавання об'єкта user до БД щоб не створювались аналогічні об'єкти при послідуючих запусках програми
        //Db.insertUser(user);
        //Db.insertUser(userLesya);
        //Db.insertUser(userTest);


        /** Метод видалення з БД елемента за id */
        // Рядок закоментовано після тестування методу видалення елементів
        //Db.deleteUserById(3);


        /** Метод отримання даних (колекція елементів) з БД */
        List<User> users = Db.getAllUsers();

        // Виведення отриманх даних
        users.forEach(System.out::println);


        /** Тестування алгоритму оновлення даних у БД */
        User userUpdate = users.get(0);
        //userUpdate.setFirstName("Ivan");
        userUpdate.setLastName("Kotliarevsky");
        Db.updateUser(userUpdate);

        // отримання даних з БД та виведення результату після внесення змін
        users = Db.getAllUsers();
        users.forEach(System.out::println);
    }
}
