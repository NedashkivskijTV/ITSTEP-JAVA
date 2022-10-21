package org.example.ex5;

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

}
