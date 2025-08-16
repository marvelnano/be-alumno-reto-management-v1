package com.school.bs_student_management_v1.service;

import com.school.bs_student_management_v1.model.dto.RespuestaCreadoExito;
import com.school.bs_student_management_v1.model.dto.StudentDTO;

public interface StudentService {
    
    public reactor.core.publisher.Mono<RespuestaCreadoExito> getAllStudents();
    public reactor.core.publisher.Mono<RespuestaCreadoExito> getByStudent(Long idStudent);
    public reactor.core.publisher.Mono<RespuestaCreadoExito> addStudent(StudentDTO studentRequest);
    public reactor.core.publisher.Mono<RespuestaCreadoExito> updateStudent(Long idStudent, StudentDTO studentRequest);
    public reactor.core.publisher.Mono<RespuestaCreadoExito> deleteStudent(Long idStudent);

}
