package com.school.bs_student_management_v1.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.school.bs_student_management_v1.model.dto.RespuestaCreadoExito;
import com.school.bs_student_management_v1.model.dto.StudentDTO;
import com.school.bs_student_management_v1.service.StudentService;


@RestController
/*@RequestMapping("api")
@Tag(name = "Student", description = "Controller for Student")*/
public class StudentController implements StudentControllerApi {

    @Autowired
    StudentService studentService;

    @Override
        public reactor.core.publisher.Mono<RespuestaCreadoExito> getAllStudents() {
            return studentService.getAllStudents();
    }

    @Override
        public reactor.core.publisher.Mono<RespuestaCreadoExito> getByStudent(@PathVariable("id") Long idStudent) {        
            return studentService.getByStudent(idStudent);
    }    

    @Override
        public reactor.core.publisher.Mono<RespuestaCreadoExito> addStudent(@RequestBody StudentDTO studentDTO) {        
            return studentService.addStudent(studentDTO);
    }

    @Override
        public reactor.core.publisher.Mono<RespuestaCreadoExito> updateStudent(@PathVariable("id") Long idStudent,
            @RequestBody StudentDTO studentDTO) {        
            return studentService.updateStudent(idStudent, studentDTO);
    }

    @Override
        public reactor.core.publisher.Mono<RespuestaCreadoExito> deleteStudent(@PathVariable("id") Long idStudent) {        
            return studentService.deleteStudent(idStudent);
    }
        
}
