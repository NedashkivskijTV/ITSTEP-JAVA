package edu.itstep.cw20220914_analysis.comparable;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                "}";
    }

    @Override
    public int compareTo(User o) {
        // сортування по полю age
//        if (this.age > o.age) {
//            return 1;
//        } else if (this.age < o.age) {
//            return -1;
//        } else {
//            return 0;
//        }
        //return this.age - o.age; // коротший запис

        // при необхідності порівняння по текстовому полю
        // код виглядатиме наступним чином (compareTo для String вже реалізований)
        return this.name.compareTo(o.name);
    }
}
