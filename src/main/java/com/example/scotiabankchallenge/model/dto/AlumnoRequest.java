package com.example.scotiabankchallenge.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlumnoRequest {
    private Long id;
    private String nombres;
    private String apellidos;
    private String estado;
    private Integer edad;
}
