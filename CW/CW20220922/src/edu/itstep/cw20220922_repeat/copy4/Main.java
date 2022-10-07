package edu.itstep.cw20220922_repeat.copy4;

public class Main {
    public static void main(String[] args) {

        // створення копії об'єкта за допомогою інструментів Object - потрібно перевизначити метод clone()
        // та імплементувати інтерфейс (маркерний ) Cloneable

        User user = new User("Ivan", "Ivanenko");
        User copy = null;
        try {
            copy = (User) user.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        user.setFirstName("Petro");
        System.out.println(copy.getFirstName()); // Ivan

    }
}
