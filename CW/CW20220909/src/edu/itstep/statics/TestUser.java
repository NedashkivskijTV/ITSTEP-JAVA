package edu.itstep.statics;

public class TestUser {
    public static void main(String[] args) {
       // User.count = 1;
        //System.out.println(User.count);
        System.out.println(User.getCount());
        User user1 = new User();
        User user2 = new User();
        //System.out.println(User.count);
        System.out.println(User.getCount());

        //User.count = 5;
        System.out.println(user1.getId());
        System.out.println(user2.getId());
    }
}
