package edu.itstep.cw20221003_repeat.reflection;

public class User {
    private String firstName;
    public String lastName;
    private static int staticField;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private User(String firstName) {
        this.firstName = firstName;
    }

//    public String getFirstName() {
//        return firstName;
//    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void privateMethod(String test1, int test2){
        System.out.println("private method");
        System.out.println(test1 + test2);
    }
    private void privateMethod(){
        System.out.println("private method");
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
