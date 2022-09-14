package edu.itstep.hw20220905;

import java.util.Arrays;

public class ArrayListUser {
    private User[] data;
    //private int size = 0;

    public ArrayListUser() {
        this.data = new User[0];
    }

    public void printArr() {
        if (this.data.length == 0) {
            System.out.println("List of users is empty");
        } else {
            for (int i = 0; i < data.length; i++) {
                //System.out.println(data[i].PrintUser());
/*
                if (data[i] == null) {
                    System.out.println("null");
                } else {
                    data[i].PrintUser();
                }
*/
                System.out.println(data[i] == null ? "null" : data[i].toString());
            }
        }
    }

    public int size() {
        return this.data.length;
    }

    public User get(int index) {
        if (this.data.length == 0) {
            System.out.println("List of users is empty");
            return null;
        }
        if (index >= 0 && index < data.length) {
            return data[index];
        }
        System.err.println("ERROR! Index out of range");
        return null;
    }

    public User getFirst() {
        //return data[0];
        return get(0);
    }

    public User getLast() {
        //return data[data.length - 1];
        return get(data.length - 1);
    }

    public void addFirst(User user) {
        User[] temp = new User[data.length + 1];
        temp[0] = user;
        for (int i = 1; i < temp.length; i++) {
            temp[i] = data[i - 1];
        }
        data = temp;
    }

    public void addLast(User user) {
        User[] temp = new User[data.length + 1];
        for (int i = 0; i < temp.length - 1; i++) {
            temp[i] = data[i];
        }
        temp[data.length] = user;
        data = temp;
    }

    public void set(int index, User user) { //(заменяет значение)
        if (index >= 0 && index < data.length) {
            data[index] = user;
        } else {
            System.err.println("ERROR! Index out of range");
        }
    }

    public void delete(int index) {
        if (index < 0 || index >= data.length) {
            System.err.println("ERROR! Index out of range");
            return;
        }
        User[] temp = new User[data.length - 1];
        for (int i = 0; i < data.length; i++) {
            if (i < index) {
                temp[i] = data[i];
            } else if (i > index) {
                temp[i - 1] = data[i];
            }
        }
        data = temp;
    }

}
