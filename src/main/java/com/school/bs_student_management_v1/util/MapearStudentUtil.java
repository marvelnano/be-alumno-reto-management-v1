package com.school.bs_student_management_v1.util;

import java.util.List;

import com.school.bs_student_management_v1.model.dto.StudentDTO;
import com.school.bs_student_management_v1.model.dto.StudentResponse;
import com.school.bs_student_management_v1.model.entity.StudentEntity;

public class MapearStudentUtil {

    MapearStudentUtil(){

    }

    public static List<StudentResponse> toListStudentResponse(List<StudentEntity> users){
        
        return users.stream().map(l -> StudentResponse.builder()
            .id(l.getId())
            .idCurso(l.getIdCurso())
            .nombres(l.getNombres())
            .apellidos(l.getApellidos())
            .edad(l.getEdad())
            .email(l.getEmail()).build())
        .toList();

    }

    public static StudentEntity toStudentEntity(StudentDTO body) {

		return StudentEntity.builder()
        .idCurso(body.getIdCurso() != null ? body.getIdCurso() : null)
        .nombres(body.getNombres() != null ? body.getNombres() : null)
        .apellidos(body.getApellidos() != null ? body.getApellidos() : null)
        .edad(body.getEdad() != null ? body.getEdad() : null)
        .email(body.getEmail() != null ? body.getEmail() : null)
        .build();
        
	}

}
