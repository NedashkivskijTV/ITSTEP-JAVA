package org.example.ex5;

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

    public void setBook(){
        System.out.println("setBook UniversityLibrary");
    }
    public void addBook(){
        System.out.println("addBook UniversityLibrary");
    }
    public void removeBook(){
        System.out.println("removeBook UniversityLibrary");
    }
}
