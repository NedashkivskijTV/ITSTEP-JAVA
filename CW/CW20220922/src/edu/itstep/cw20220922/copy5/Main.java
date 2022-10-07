package edu.itstep.cw20220922.copy5;

public class Main {
    public static void main(String[] args) {
        User user = new User("Ivan", "Ivanenko");
        User copy = null;
        try {
            copy = (User) user.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        user.setName("Petro");
        System.out.println(copy.getName());
    }
}
