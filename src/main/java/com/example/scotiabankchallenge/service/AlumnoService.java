package com.example.scotiabankchallenge.service;

import com.example.scotiabankchallenge.model.dto.AlumnoRequest;
import com.example.scotiabankchallenge.model.dto.RespuestaCreadoExito;

import reactor.core.publisher.Mono;

public interface AlumnoService {
    Mono<RespuestaCreadoExito> getActiveAlumnos();
    Mono<RespuestaCreadoExito> saveAlumno(AlumnoRequest alumnoRequest);
}


