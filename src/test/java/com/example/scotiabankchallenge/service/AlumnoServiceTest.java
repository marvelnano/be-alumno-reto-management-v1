package com.example.scotiabankchallenge.service;

import com.example.scotiabankchallenge.model.dto.Alumno;
import com.example.scotiabankchallenge.model.dto.AlumnoRequest;
import com.example.scotiabankchallenge.repository.AlumnoRepository;
import com.example.scotiabankchallenge.service.impl.AlumnoServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;

public class AlumnoServiceTest {

    private AlumnoServiceImpl alumnoService;
    private AlumnoRepository alumnoRepository;

    @BeforeEach
    void setUp() {
        alumnoRepository = Mockito.mock(AlumnoRepository.class);
        alumnoService = new AlumnoServiceImpl(alumnoRepository);
    }

    @Test
    void testSaveAlumnoSuccess() {
        AlumnoRequest alumnoReq = new AlumnoRequest(null, "Juan", "Perez", "activo", 25);
        Alumno alumnoEntity = new Alumno(1L, "Juan", "Perez", "activo", 25);

        Mockito.when(alumnoRepository.getNextId()).thenReturn(Mono.just(1L));
        Mockito.when(alumnoRepository.save(any(Alumno.class))).thenReturn(Mono.just(alumnoEntity));

        Mono<com.example.scotiabankchallenge.model.dto.RespuestaCreadoExito> result = alumnoService.saveAlumno(alumnoReq);

        StepVerifier.create(result)
                .expectNextMatches(resp -> resp.getEstado().contains("Alumno registrado") && resp.getDatos() != null)
                .verifyComplete();

        Mockito.verify(alumnoRepository, Mockito.times(1)).save(any(Alumno.class));
    }

    @Test
    void testSaveAlumnoDuplicateId() {
    // Ahora ignoramos el id enviado y se asigna uno nuevo. Simulamos getNextId y save.
        AlumnoRequest alumnoReq = new AlumnoRequest(999L, "Juan", "Perez", "activo", 25);
        Alumno alumnoEntity = new Alumno(5L, "Juan", "Perez", "activo", 25);

        Mockito.when(alumnoRepository.getNextId()).thenReturn(Mono.just(5L));
        Mockito.when(alumnoRepository.save(any(Alumno.class))).thenReturn(Mono.just(alumnoEntity));

        Mono<com.example.scotiabankchallenge.model.dto.RespuestaCreadoExito> result = alumnoService.saveAlumno(alumnoReq);

        StepVerifier.create(result)
                .expectNextMatches(resp -> resp.getCodigo() == 200 && resp.getEstado().contains("Alumno registrado"))
                .verifyComplete();

        Mockito.verify(alumnoRepository, Mockito.times(1)).save(any(Alumno.class));
    }

    @Test
    void testSaveAlumnoInvalidId() {
        // ID enviado se ignora; validación no necesita rechazar por id. Probaremos que si campos son válidos, se registra.
        AlumnoRequest alumnoReq = new AlumnoRequest(0L, "Juan", "Perez", "activo", 25);
        Alumno alumnoEntity = new Alumno(10L, "Juan", "Perez", "activo", 25);

        Mockito.when(alumnoRepository.getNextId()).thenReturn(Mono.just(10L));
        Mockito.when(alumnoRepository.save(any(Alumno.class))).thenReturn(Mono.just(alumnoEntity));

        Mono<com.example.scotiabankchallenge.model.dto.RespuestaCreadoExito> result = alumnoService.saveAlumno(alumnoReq);

        StepVerifier.create(result)
                .expectNextMatches(resp -> resp.getCodigo() == 200 && resp.getEstado().contains("Alumno registrado"))
                .verifyComplete();
    }

    @Test
    void testSaveAlumnoInvalidName() {
        AlumnoRequest alumnoReq = new AlumnoRequest(null, null, "Perez", "activo", 25);

        Mono<com.example.scotiabankchallenge.model.dto.RespuestaCreadoExito> result = alumnoService.saveAlumno(alumnoReq);

        StepVerifier.create(result)
                .expectNextMatches(resp -> resp.getCodigo() == 400 && resp.getEstado().contains("Error"))
                .verifyComplete();
    }

    @Test
    void testSaveAlumnoInvalidApellido() {
        AlumnoRequest alumnoReq = new AlumnoRequest(null, "Juan", null, "activo", 25);

        Mono<com.example.scotiabankchallenge.model.dto.RespuestaCreadoExito> result = alumnoService.saveAlumno(alumnoReq);

        StepVerifier.create(result)
                .expectNextMatches(resp -> resp.getCodigo() == 400 && resp.getEstado().contains("Error"))
                .verifyComplete();
    }

    @Test
    void testSaveAlumnoInvalidEstado() {
        AlumnoRequest alumnoReq = new AlumnoRequest(null, "Juan", "Perez", "invalid", 25);

        Mono<com.example.scotiabankchallenge.model.dto.RespuestaCreadoExito> result = alumnoService.saveAlumno(alumnoReq);

        StepVerifier.create(result)
                .expectNextMatches(resp -> resp.getCodigo() == 400 && resp.getEstado().contains("Error"))
                .verifyComplete();
    }

    @Test
    void testSaveAlumnoInvalidEdad() {
        AlumnoRequest alumnoReq = new AlumnoRequest(null, "Juan", "Perez", "activo", 0);

        Mono<com.example.scotiabankchallenge.model.dto.RespuestaCreadoExito> result = alumnoService.saveAlumno(alumnoReq);

        StepVerifier.create(result)
                .expectNextMatches(resp -> resp.getCodigo() == 400 && resp.getEstado().contains("Error"))
                .verifyComplete();
    }

    @Test
    void testGetActiveAlumnos() {
        Alumno alumno1 = new Alumno(1L, "Juan", "Perez", "activo", 25);
        Alumno alumno3 = new Alumno(3L, "Pedro", "Lopez", "activo", 22);

        Mockito.when(alumnoRepository.findAllActive())
                .thenReturn(Flux.just(alumno1, alumno3));

        Mono<com.example.scotiabankchallenge.model.dto.RespuestaCreadoExito> result = alumnoService.getActiveAlumnos();

        StepVerifier.create(result)
                .expectNextMatches(resp -> {
                    Object datos = resp.getDatos();
                    return datos instanceof java.util.List && ((java.util.List<?>) datos).size() == 2;
                })
                .verifyComplete();
    }
}


