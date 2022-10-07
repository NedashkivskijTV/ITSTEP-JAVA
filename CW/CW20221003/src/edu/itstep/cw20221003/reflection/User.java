package edu.itstep.cw20221003.reflection;

public class User {
    private String firstName;
    public String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
        System.out.println("private");
        System.out.println(test1 + test2);
    }
    public void privateMethod(){
        System.out.println("public");
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
