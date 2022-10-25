package repeat.ex1;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary {

    public void getBook() {
        System.out.println("getBook UniversityLibrary");
    }

    public void getMagazine(int id) {
        System.out.println("getMagazine UniversityLibrary");
    }

    public boolean getNewspaper() {
        System.out.println("getNewspaper UniversityLibrary");
        return true;
    }

    public void addBookById(int id) {
        System.out.println("addBookById UniversityLibrary");
    }

    public void addBook() {
        System.out.println("addBook UniversityLibrary");
    }
}
