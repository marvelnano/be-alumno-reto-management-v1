package com.school.bs_student_management_v1.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("idCurso")
    private Long idCurso;

    @JsonProperty("nombres")
    private String nombres;

    @JsonProperty("apellidos")
    private String apellidos;

    @JsonProperty("edad")
    private Long edad;

    @JsonProperty("email")
    private String email;
    
}
