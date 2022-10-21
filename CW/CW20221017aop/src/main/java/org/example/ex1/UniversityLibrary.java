package org.example.ex1;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary {

    public void getBook(){
        System.out.println("getBook UniversityLibrary");
    }

    //public void getMagazine(int id){
    public boolean getMagazine(){
        System.out.println("getMagazine UniversityLibrary");
        return true;
    }

    public void addBookById(){
        System.out.println("addBookById UniversityLibrary");
    }

}
