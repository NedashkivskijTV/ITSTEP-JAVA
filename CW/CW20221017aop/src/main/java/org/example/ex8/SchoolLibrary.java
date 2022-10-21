package org.example.ex8;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary {

    public void getBook(){
        System.out.println("getBook SchoolLibrary");
    }

    public void getMagazine(int id){
        System.out.println("getMagazine int SchoolLibrary");
    }

    public void getMagazine(String name){
        System.out.println("getMagazine String SchoolLibrary");
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
