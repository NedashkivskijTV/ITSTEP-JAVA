package edu.itstep.cw20220907;

public class Main04 {
    public static void main(String[] args) {

        /** Методи класу Object */

        Person tom = new Person("Tom");
        Person bob = new Person("Bob");
        Person tom2 = new Person("Tom");

        System.out.println(tom); // Person Tom

        System.out.println(tom.hashCode()); // 863217

        System.out.println(tom.getClass()); // class edu.itstep.cw20220907.Person
        System.out.println(tom.getClass().getSimpleName()); // Person

        System.out.println(tom.equals(bob)); // false
        System.out.println(tom.equals(tom2)); // true
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        // Оператор instanceof позволяет выяснить,
        // является ли переданный в качестве параметра
        // объект объектом определенного класса,
        // в данном случае класса Person
        if (!(obj instanceof Person)) {
            return false;
        }

        Person p = (Person) obj;
        return this.name.equals(p.name);
    }

//    @Override
//    public String toString() {
//        return "Person " + name;
//    }
//
//    @Override
//    public int hashCode() {
//        return 10 * name.hashCode() + 20477;
//    }
}
