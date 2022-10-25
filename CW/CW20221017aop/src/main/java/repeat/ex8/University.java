package repeat.ex8;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void fillStudents(){
        students.add(new Student("Ivan Ivanenko", 18, 10.0));
        students.add(new Student("Petro Petrenko", 18, 9));
        students.add(new Student("Anton Antonenko", 22, 8));
    }

    public List<Student> getStudents() {
        System.out.println("getStudents() start");
        //System.out.println(7/0);
        System.out.println("getStudents() finish");
        return students;
    }
}
