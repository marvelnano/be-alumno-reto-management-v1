package com.example.scotiabankchallenge.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    private Long id;
    private String nombre;
    private String apellido;
    private String estado; // activo, inactivo
    private Integer edad;
}


