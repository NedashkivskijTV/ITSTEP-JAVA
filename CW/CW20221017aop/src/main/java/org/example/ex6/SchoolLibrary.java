package org.example.ex6;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary {

    public void getBook(){
        System.out.println("getBook SchoolLibrary");
    }

    public void getMagazine(int id){
        System.out.println("getMagazine SchoolLibrary");
    }
    public void setBook(){
        System.out.println("setBook SchoolLibrary");
    }

    public void addBook(){
        System.out.println("addBook SchoolLibrary");
    }

    public void removeBook(){
        System.out.println("removeBook SchoolLibrary");
    }


}
