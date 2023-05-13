package com.learn.service.serviceb.controller;


import com.learn.service.serviceb.database.InternalDatabase;
import com.learn.service.serviceb.model.Student;
import com.learn.service.serviceb.response.GetStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AdminController {


    @Autowired
    private InternalDatabase database;

    @GetMapping("/student/{rollNumber}")
    public ResponseEntity<GetStudentResponse> getStudentByRollNumber(@PathVariable int rollNumber){

        List<Student> students = database.getStudents();

        Student student = null;

        for (Student temp : students) {
            if(temp.getRollNumber() == rollNumber){
                student = temp;
            }
        }

        return student == null ?
                  ResponseEntity.ok(GetStudentResponse.builder().build())
                : ResponseEntity.ok(GetStudentResponse.builder().student(student).build());

        //   return student == null ? ResponseEntity.ok(Collections.EMPTY_LIST) : ResponseEntity.ok(List.of(student));
       // return student == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(student);
    }



    @DeleteMapping("/student/{rollNumber}")
    public ResponseEntity<String> deleteStudent(@PathVariable int rollNumber){
        boolean isDeleted = database.deleteStudent(rollNumber);
        return isDeleted ? ResponseEntity.ok("Successfully deleted") : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/student/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student studentRequestBody){
        database.addStudent(studentRequestBody);
        return ResponseEntity.ok(studentRequestBody);
    }
}
