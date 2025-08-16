package com.school.bs_student_management_v1.model.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class StudentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student", nullable = false)
    private Long id;

    @Column(name = "id_course", nullable = false)
    private Long idCurso;

    private String nombres;
    private String apellidos;
    private Long edad;
    private String email;

    private static final long serialVersionUID = 6690689988058914671L;
    
}
