package repeat.ex2;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary {

    public void getBook(){
        System.out.println("getBook SchoolLibrary");
    }

    public void getMagazine(int id){
        System.out.println("getMagazine by int SchoolLibrary");
    }

    public void getMagazine(String name){
        System.out.println("getMagazine by String SchoolLibrary");
    }
}
