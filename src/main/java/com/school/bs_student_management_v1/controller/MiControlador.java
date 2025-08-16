package com.school.bs_student_management_v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Bienvenida", description = "Controlador mensaje de bienvenida")
public class MiControlador {

    @GetMapping("/saludo")
    @Operation(
        summary = "Saludo",
        description = "Mensaje de bienvenida que puede ser usando en el FrontEnd",
        tags = {"Bienvenida"},
        requestBody = @RequestBody(
            description = "Saludo de Bienvenidad",
            required = false,
            content = @Content(
                mediaType = "application/json"
            )
        ),
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Successful message",
                content = @Content(
                    mediaType = "application/json"
                )
            )
        }
    )
    public String saludo() {
        return "Hola, mundo!!";
    }
}