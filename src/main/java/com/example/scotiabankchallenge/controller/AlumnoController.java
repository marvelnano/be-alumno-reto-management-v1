package com.example.scotiabankchallenge.controller;

import com.example.scotiabankchallenge.model.dto.AlumnoRequest;
import com.example.scotiabankchallenge.model.dto.RespuestaCreadoExito;
import com.example.scotiabankchallenge.service.AlumnoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AlumnoController implements AlumnoApi {

    @Autowired
    private AlumnoService alumnoService;

    @Override
    public Mono<RespuestaCreadoExito> getActiveAlumnos() {
        return alumnoService.getActiveAlumnos();
    }

    @Override
    public Mono<RespuestaCreadoExito> saveAlumno(@RequestBody AlumnoRequest alumnoRequest) {
        return alumnoService.saveAlumno(alumnoRequest);
    }
}


