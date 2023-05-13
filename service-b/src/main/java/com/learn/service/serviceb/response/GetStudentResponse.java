package com.learn.service.serviceb.response;


import com.learn.service.serviceb.model.Student;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetStudentResponse {

    private Student student;
}
