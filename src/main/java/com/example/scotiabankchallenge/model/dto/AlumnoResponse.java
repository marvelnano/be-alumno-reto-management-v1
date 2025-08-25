package com.example.scotiabankchallenge.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlumnoResponse {
    @JsonProperty("idAlumno")
    private Long id;

    @JsonProperty("nombres")
    private String nombre;

    @JsonProperty("apellidos")
    private String apellido;

    @JsonProperty("estado")
    private Boolean estado;

    @JsonProperty("edad")
    private Integer edad;
}
