package com.example.scotiabankchallenge.repository;

import org.springframework.stereotype.Repository;

import com.example.scotiabankchallenge.model.dto.Alumno;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryAlumnoRepository implements AlumnoRepository {

    private final Map<Long, Alumno> alumnos = new ConcurrentHashMap<>();

    @Override
    public Mono<Alumno> save(Alumno alumno) {
        return Mono.fromCallable(() -> {
            alumnos.put(alumno.getId(), alumno);
            return alumno;
        });
    }

    @Override
    public Flux<Alumno> findAllActive() {
        return Flux.fromIterable(alumnos.values())
                .filter(alumno -> "activo".equalsIgnoreCase(alumno.getEstado()));
    }

    @Override
    public Mono<Alumno> findById(Long id) {
        return Mono.justOrEmpty(alumnos.get(id));
    }

    @Override
    public Mono<Long> getNextId() {
        return Mono.fromCallable(() -> {
            if (alumnos.isEmpty()) {
                return 1L;
            }
            return alumnos.keySet().stream()
                .mapToLong(Long::longValue)
                .max()
                .orElse(0L) + 1;
        });
    }
}


