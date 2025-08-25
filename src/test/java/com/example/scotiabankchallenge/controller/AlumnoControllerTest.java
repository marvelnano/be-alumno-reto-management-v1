// ...existing code...
package com.example.scotiabankchallenge.controller;

import com.example.scotiabankchallenge.model.dto.Alumno;
import com.example.scotiabankchallenge.model.dto.RespuestaCreadoExito;
import com.example.scotiabankchallenge.service.AlumnoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@WebFluxTest(controllers = AlumnoController.class)
public class AlumnoControllerTest {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private AlumnoService alumnoService;

    private Alumno alumno1;
    private Alumno alumno3;

    @BeforeEach
    void setUp() {
        alumno1 = new Alumno(1L, "Juan", "Perez", "activo", 25);
        alumno3 = new Alumno(2L, "Pedro", "Lopez", "activo", 22);
    }    @Test
    @DisplayName("POST /alumnos - success")
    void testSaveAlumnoSuccess() {
        RespuestaCreadoExito respuesta = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.OK.value())
            .estado("Alumno registrado")
            .datos(alumno1)
            .build();

        Mockito.when(alumnoService.saveAlumno(any())).thenReturn(Mono.just(respuesta));

        webClient.post().uri("/api/v1/alumnos")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(alumno1)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                    .jsonPath("$.message").isEqualTo("Alumno registrado")
                    .jsonPath("$.data.nombre").isEqualTo("Juan");

        verify(alumnoService, times(1)).saveAlumno(any());
    }

    @Test
    @DisplayName("POST /alumnos - bad request when service errors")
    void testSaveAlumnoBadRequest() {
        RespuestaCreadoExito respuestaError = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.BAD_REQUEST.value())
            .estado("Error: El nombre es obligatorio")
            .datos(null)
            .build();

        Mockito.when(alumnoService.saveAlumno(any()))
                .thenReturn(Mono.just(respuestaError));

        webClient.post().uri("/api/v1/alumnos")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(alumno1)
                .exchange()
                .expectStatus().isOk() // El controlador devuelve 200 pero con código de error en el cuerpo
                .expectBody()
                    .jsonPath("$.codeStatus").isEqualTo(400);

        verify(alumnoService, times(1)).saveAlumno(any());
    }

    @Test
    @DisplayName("GET /alumnos/active - returns list de alumnos activos")
    void testGetActiveAlumnos() {
        RespuestaCreadoExito respuesta = RespuestaCreadoExito.builder()
                .codigo(HttpStatus.OK.value())
                .estado("Consulta exitosa")
                .datos(List.of(alumno1, alumno3))
                .build();

        Mockito.when(alumnoService.getActiveAlumnos())
                .thenReturn(Mono.just(respuesta));

        webClient.get().uri("/api/v1/alumnos/activos")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                    .jsonPath("$.data").isArray()
                    .jsonPath("$.data.length()").isEqualTo(2)
                    .jsonPath("$.data[0].nombre").isEqualTo("Juan");

        verify(alumnoService, times(1)).getActiveAlumnos();
    }
}
// ...existing code...