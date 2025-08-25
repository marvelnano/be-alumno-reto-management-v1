package com.example.scotiabankchallenge.util;

import java.util.List;
import java.util.stream.Collectors;

import com.example.scotiabankchallenge.model.dto.Alumno;
import com.example.scotiabankchallenge.model.dto.AlumnoRequest;
import com.example.scotiabankchallenge.model.dto.AlumnoResponse;

public class MapearAlumnoUtil {
    MapearAlumnoUtil(){

    }

    public static List<AlumnoResponse> toListAlumnoResponse(List<Alumno> alumnos){
        return alumnos.stream().map(l -> AlumnoResponse.builder()
            .id(l.getId())
            .nombre(l.getNombre())
            .apellido(l.getApellido())
            .estado("activo".compareTo(l.getEstado()) == 0 ? true : false)
            .edad(l.getEdad()).build())
        .collect(Collectors.toList());
    }

    public static Alumno toAlumnoEntity(AlumnoRequest body) {
        Alumno alumno = new Alumno();
        alumno.setId(body.getId());
        alumno.setNombre(body.getNombres() != null ? body.getNombres() : null);
        alumno.setApellido(body.getApellidos() != null ? body.getApellidos() : null);
        alumno.setEstado(body.getEstado() != null ? body.getEstado() : "activo");
        alumno.setEdad(body.getEdad() != null ? body.getEdad() : null);
        return alumno;        
    }

    public static AlumnoResponse toAlumnoResponse(Alumno alumno) {
        AlumnoResponse response = new AlumnoResponse();
        response.setId(alumno.getId());
        response.setNombre(alumno.getNombre());
        response.setApellido(alumno.getApellido());
        response.setEstado("activo".compareTo(alumno.getEstado()) == 0 ? true : false);
        response.setEdad(alumno.getEdad());
        return response;        
    }
}
