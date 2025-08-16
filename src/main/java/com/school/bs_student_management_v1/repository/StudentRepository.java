package com.school.bs_student_management_v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.bs_student_management_v1.model.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
