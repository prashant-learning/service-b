package com.learn.service.serviceb.database;

import com.learn.service.serviceb.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InternalDatabase {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, 10, 'A', "Ram", "Shayam", "Hyderabad", "24323423423"),
            new Student(2, 10, 'A', "Jack", "Jenifer", "Hyderabad", "24323423423"),
            new Student(3, 10, 'A', "Mack", "Messi", "Hyderabad", "24323423423")

    ));

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public boolean deleteStudent(int rollNumber){

        int index = -1;
        int i = 0;
        for (Student temp: students) {

            if(temp.getRollNumber() == rollNumber){
                index = i;
            }
            i++;
        }
        if(index == -1){
            return false;
        } else {
            students.remove(index);
            return true;
        }
    }
}
