package com.example.scotiabankchallenge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.scotiabankchallenge.model.dto.AlumnoRequest;
import com.example.scotiabankchallenge.model.dto.RespuestaCreadoExito;
import com.example.scotiabankchallenge.util.CommonApiResponses;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import reactor.core.publisher.Mono;

@RequestMapping("/api/v1")
public interface AlumnoApi {
    @Operation(
        summary = "Obtener Alumnos Activos",
        description = "Obtener lista de alumnos con estado activo"
    )
    @CommonApiResponses
    @GetMapping("/alumnos/activos")
    Mono<RespuestaCreadoExito> getActiveAlumnos();

    @Operation(
        summary = "Registrar Alumno",
        description = "Registrar alumno según lo requerido",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Alumno request", required = false,
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlumnoRequest.class))
        )
    )
    @CommonApiResponses
    @PostMapping("/alumnos")
    Mono<RespuestaCreadoExito> saveAlumno(@RequestBody AlumnoRequest alumnoRequest);
}
