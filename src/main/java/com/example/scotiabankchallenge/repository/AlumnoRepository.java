package com.example.scotiabankchallenge.repository;

import com.example.scotiabankchallenge.model.dto.Alumno;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlumnoRepository {
    Mono<Alumno> save(Alumno alumno);
    Flux<Alumno> findAllActive();
    Mono<Alumno> findById(Long id);
    Mono<Long> getNextId();
}


