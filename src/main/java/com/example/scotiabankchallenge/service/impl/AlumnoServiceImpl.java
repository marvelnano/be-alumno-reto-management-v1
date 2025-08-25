package com.example.scotiabankchallenge.service.impl;

import com.example.scotiabankchallenge.model.dto.Alumno;
import com.example.scotiabankchallenge.model.dto.AlumnoRequest;
import com.example.scotiabankchallenge.model.dto.AlumnoResponse;
import com.example.scotiabankchallenge.model.dto.RespuestaCreadoExito;
import com.example.scotiabankchallenge.repository.AlumnoRepository;
import com.example.scotiabankchallenge.service.AlumnoService;
import com.example.scotiabankchallenge.util.MapearAlumnoUtil;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public Mono<RespuestaCreadoExito> getActiveAlumnos() {
        return alumnoRepository.findAllActive()
            .filter(alumno -> "activo".equalsIgnoreCase(alumno.getEstado()))
            .collectList()
            .map(MapearAlumnoUtil::toListAlumnoResponse)
            .map(this::createSuccessResponse);
    }

    private RespuestaCreadoExito createSuccessResponse(List<AlumnoResponse> alumnos) {
        return RespuestaCreadoExito.builder()
            .codigo(HttpStatus.OK.value())
            .estado("Consulta exitosa")
            .datos(alumnos)
            .build();
    }

    @Override
    public Mono<RespuestaCreadoExito> saveAlumno(AlumnoRequest body) {
        return Mono.fromCallable(() -> MapearAlumnoUtil.toAlumnoEntity(body))
            .flatMap(this::validarAlumno)
            .flatMap(this::asignarId)
            .flatMap(alumnoRepository::save)
            .map(this::crearRespuestaExito)
            .onErrorResume(this::crearRespuestaError);
    }

    private Mono<Alumno> validarAlumno(Alumno alumno) {
        String error = obtenerErrorValidacion(alumno);
        if (error != null) {
            return Mono.error(new IllegalArgumentException(error));
        }
        return Mono.just(alumno);
    }

    private String obtenerErrorValidacion(Alumno alumno) {
        if (esVacio(alumno.getNombre())) return "El nombre es obligatorio";
        if (esVacio(alumno.getApellido())) return "El apellido es obligatorio";
        if (!esEstadoValido(alumno.getEstado())) return "El estado debe ser 'activo' o 'inactivo'";
        if (!esEdadValida(alumno.getEdad())) return "La edad debe ser un número entero entre 1 y 150";
        return null;
    }

    private boolean esVacio(String valor) {
        return valor == null || valor.trim().isEmpty();
    }

    private boolean esEstadoValido(String estado) {
        return estado != null && 
            (estado.equalsIgnoreCase("activo") || estado.equalsIgnoreCase("inactivo"));
    }

    private boolean esEdadValida(Integer edad) {
        return edad != null && edad > 0 && edad <= 150;
    }

    private Mono<Alumno> asignarId(Alumno alumno) {
        // Siempre asignamos el siguiente id correlativo sin importar el id recibido
        return alumnoRepository.getNextId().map(id -> {
            alumno.setId(id);
            return alumno;
        });
    }

    private RespuestaCreadoExito crearRespuestaExito(Alumno alumno) {
        return RespuestaCreadoExito.builder()
            .codigo(HttpStatus.OK.value())
            .estado("Alumno registrado")
            .datos(MapearAlumnoUtil.toAlumnoResponse(alumno))
            .build();
    }

    private Mono<RespuestaCreadoExito> crearRespuestaError(Throwable error) {
        return Mono.just(RespuestaCreadoExito.builder()
            .codigo(HttpStatus.BAD_REQUEST.value())
            .estado("Error: " + error.getMessage())
            .datos(null)
            .build());
    }
}