package com.school.bs_student_management_v1.controller;

import org.springframework.web.bind.annotation.*;

import com.school.bs_student_management_v1.model.dto.RespuestaCreadoExito;
import reactor.core.publisher.Mono;
import com.school.bs_student_management_v1.model.dto.StudentDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping(path = "/api")
@Tag(name = "Student", description = "Controller for Student")
public interface StudentControllerApi {

    @GetMapping("/v1/students")
    @Operation(
        summary = "Listar Alumnos",
        description = "Listar todos los alumnos registrados",
        //tags = {"student-controller"},
        responses = {
            @ApiResponse(
                responseCode = "200", description = "Solicitud / Operación Exitosa",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "400", description = "La solicitud posee una sintaxis o falta de parámetros",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "401", description = "Problema de Autenticación",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "403", description = "Permisos incorrectos o el servidor está deshabilitado",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "404", description = "Recurso de destino inexistente. Servicio no encontrado",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "408", description = "Servidor no recibe la solicitud dentro del tiempo esperado",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "500", description = "Servidor presenta una condición inesperada que impide completar la solicitud",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            )
        }
    )
    Mono<RespuestaCreadoExito> getAllStudents();

    @GetMapping("/v1/students/{id}")
    @Operation(
        summary = "Buscar Alumno",
        description = "Buscar alumno por ID",
        //tags = {"student-controller"},
        responses = {
            @ApiResponse(
                responseCode = "200", description = "Solicitud / Operación Exitosa",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "400", description = "La solicitud posee una sintaxis o falta de parámetros",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "401", description = "Problema de Autenticación",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "403", description = "Permisos incorrectos o el servidor está deshabilitado",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "404", description = "Recurso de destino inexistente. Servicio no encontrado",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "408", description = "Servidor no recibe la solicitud dentro del tiempo esperado",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "500", description = "Servidor presenta una condición inesperada que impide completar la solicitud",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            )
        }
    )
    Mono<RespuestaCreadoExito> getByStudent(@PathVariable("id") Long idStudent);

    @PostMapping("/v1/students")
    @Operation(
        summary = "Registrar Alumno",
        description = "Registrar alumno según lo requerido",
        //tags = {"student-controller"},
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Student request", required = false,
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentDTO.class))
        ),
        responses = {
            @ApiResponse(
                responseCode = "200", description = "Solicitud / Operación Exitosa",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "400", description = "La solicitud posee una sintaxis o falta de parámetros",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "401", description = "Problema de Autenticación",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "403", description = "Permisos incorrectos o el servidor está deshabilitado",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "404", description = "Recurso de destino inexistente. Servicio no encontrado",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "408", description = "Servidor no recibe la solicitud dentro del tiempo esperado",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "500", description = "Servidor presenta una condición inesperada que impide completar la solicitud",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            )
        }
    )
    Mono<RespuestaCreadoExito> addStudent(@RequestBody StudentDTO studentRequest);

    @PutMapping("/v1/students/{id}")
    @Operation(
        summary = "Actualizar Alumno",
        description = "Actualizar alumno según ID",
        //tags = {"student-controller"},
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Student request", required = false,
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentDTO.class))
        ),
        responses = {
            @ApiResponse(
                responseCode = "200", description = "Solicitud / Operación Exitosa",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "400", description = "La solicitud posee una sintaxis o falta de parámetros",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "401", description = "Problema de Autenticación",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "403", description = "Permisos incorrectos o el servidor está deshabilitado",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "404", description = "Recurso de destino inexistente. Servicio no encontrado",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "408", description = "Servidor no recibe la solicitud dentro del tiempo esperado",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "500", description = "Servidor presenta una condición inesperada que impide completar la solicitud",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            )
        }
    )
    Mono<RespuestaCreadoExito> updateStudent(@PathVariable("id") Long idStudent,
    @RequestBody StudentDTO studentRequest);

    @DeleteMapping("/v1/students/{id}")
    @Operation(
        summary = "Eliminar Alumno",
        description = "Eliminar alumno según ID",
        //tags = {"student-controller"},
        responses = {
            @ApiResponse(
                responseCode = "200", description = "Solicitud / Operación Exitosa",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "400", description = "La solicitud posee una sintaxis o falta de parámetros",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "401", description = "Problema de Autenticación",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "403", description = "Permisos incorrectos o el servidor está deshabilitado",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "404", description = "Recurso de destino inexistente. Servicio no encontrado",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "408", description = "Servidor no recibe la solicitud dentro del tiempo esperado",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            ),
            @ApiResponse(
                responseCode = "500", description = "Servidor presenta una condición inesperada que impide completar la solicitud",
                content = @Content(
                    mediaType = "application/json", schema = @Schema(implementation = RespuestaCreadoExito.class)
                )
            )
        }
    )
    Mono<RespuestaCreadoExito> deleteStudent(@PathVariable("id") Long idStudent);

}
