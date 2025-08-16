package com.school.bs_student_management_v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.school.bs_student_management_v1.model.dto.RespuestaCreadoExito;
import com.school.bs_student_management_v1.model.dto.StudentDTO;
import com.school.bs_student_management_v1.model.dto.StudentResponse;
import com.school.bs_student_management_v1.model.entity.StudentEntity;
import com.school.bs_student_management_v1.repository.StudentRepository;
import com.school.bs_student_management_v1.service.StudentService;
import com.school.bs_student_management_v1.util.MapearStudentUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    //private static String msgError = "Error";

    @Autowired
    StudentRepository studentRepository;

    @Override
    public RespuestaCreadoExito getAllStudents(){
        RespuestaCreadoExito response = null;

        var students = studentRepository.findAll();
        List<StudentResponse> data =  MapearStudentUtil.toListStudentResponse(students);

        response = RespuestaCreadoExito.builder()
				.codigo(HttpStatus.OK.value())
				.estado("OK")
				.datos(data)
                .build();
		
		return response;

    }

    @Override
    public RespuestaCreadoExito getByStudent(Long idStudent){
        RespuestaCreadoExito response = null;      

        var datosStudent = studentRepository.findById(idStudent).orElse(null);

        if(datosStudent != null){
            response = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.OK.value())
            .estado("Ok")
            .datos(studentRepository.save(datosStudent))
            .build();
        }else{
            response = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.OK.value())
            .estado("No se pudo encontrar el alumno con el código: "+idStudent)
            .datos(null)
            .build();
        }

        log.info("Student finded: {}"+datosStudent);        

        return response;

    }

    @Override
    public RespuestaCreadoExito addStudent(StudentDTO body){
        RespuestaCreadoExito response = null;
        StudentEntity student = null;

        student = MapearStudentUtil.toStudentEntity(body);

        log.info("Student added: {}"+student);

        response = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.OK.value())
            .estado("Ok")
            .datos(studentRepository.save(student))
            .build();

        return response;
    }

    @Override
    public RespuestaCreadoExito updateStudent(Long idStudent, StudentDTO body){
        RespuestaCreadoExito response = null;
        StudentEntity student = null;        

        var datosStudent = studentRepository.findById(idStudent).orElse(null);

        if(datosStudent != null){
            student = MapearStudentUtil.toStudentEntity(body);
            student.setId(datosStudent.getId());

            response = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.OK.value())
            .estado("Ok")
            .datos(studentRepository.save(student))
            .build();
        }else{
            response = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.OK.value())
            .estado("No se pudo encontrar el alumno con el código: "+idStudent)
            .datos(null)
            .build();
        }

        log.info("Student updated: {}"+student);        

        return response;
    }

    @Override
    public RespuestaCreadoExito deleteStudent(Long idStudent){
        RespuestaCreadoExito response = null;
        StudentEntity student = studentRepository.findById(idStudent).orElse(null);

        if(student != null){
            studentRepository.delete(student);

            response = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.OK.value())
            .estado("Alumno eliminado")
            .datos(student)
            .build();
        }else{
            response = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.OK.value())
            .estado("No se pudo encontrar el alumno con el código: "+idStudent)
            .datos(null)
            .build();
        }

        log.info("Student deleted: {}"+student);        

        return response;
    }

}
