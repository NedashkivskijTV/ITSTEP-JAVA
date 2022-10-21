package org.example.ex7;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {

    private List<Student> students = new ArrayList<>();

    public void fillStudents(){
        students.add(new Student("Ivanenko", 18, 4.5));
        students.add(new Student("Petrenko", 17, 5.0));
        students.add(new Student("Sidorenko", 18, 4.0));
    }

    public List<Student> getStudents() {
        //System.out.println("getStudents()");
        return students;
    }
}
