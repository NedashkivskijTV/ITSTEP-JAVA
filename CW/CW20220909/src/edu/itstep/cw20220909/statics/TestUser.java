package edu.itstep.cw20220909.statics;

public class TestUser {
    public static void main(String[] args) {
        User user = new User();
        user.firstName = "newName";
        System.out.println(user.firstName); // newName

        System.out.println("---------------------------------------------------------");
        System.out.println(User.count); // 0 - змінна проініціалізована при створенні
        User.count = 100;
        System.out.println(User.count); // 100
        User.count = 0;

        System.out.println("---------------------------------------------------------");
        User user1 = new User();
        User user2 = new User();
        System.out.println(User.count);//2
        System.out.println(user1.count);//2 - звернення до змінної класу !!!
        System.out.println(user2.count);//2 - звернення до змінної класу !!!

        System.out.println(user1.getId());//1
        System.out.println(user2.getId());//2

        System.out.println("---------------------------------------------------------");
        System.out.println(User.getCountPrivate());
    }
}
