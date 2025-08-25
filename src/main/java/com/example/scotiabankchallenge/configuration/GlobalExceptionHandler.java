package com.example.scotiabankchallenge.configuration;

import com.example.scotiabankchallenge.model.dto.RespuestaCreadoExito;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidFormatException.class)
    public Mono<ResponseEntity<RespuestaCreadoExito>> handleInvalidFormat(InvalidFormatException ex) {
        String fieldName = getFieldName(ex);
        String message = createValidationMessage(fieldName, ex.getValue());
        
        RespuestaCreadoExito respuesta = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.BAD_REQUEST.value())
            .estado("Error: " + message)
            .datos(null)
            .build();
            
        return Mono.just(ResponseEntity.badRequest().body(respuesta));
    }

    @ExceptionHandler(JsonMappingException.class)
    public Mono<ResponseEntity<RespuestaCreadoExito>> handleJsonMapping(JsonMappingException ex) {
        String message = "Error en el formato de los datos enviados";
        
        if (ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException cause = (InvalidFormatException) ex.getCause();
            String fieldName = getFieldName(cause);
            message = createValidationMessage(fieldName, cause.getValue());
        }
        
        RespuestaCreadoExito respuesta = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.BAD_REQUEST.value())
            .estado("Error: " + message)
            .datos(null)
            .build();
            
        return Mono.just(ResponseEntity.badRequest().body(respuesta));
    }

    @ExceptionHandler(JsonProcessingException.class)
    public Mono<ResponseEntity<RespuestaCreadoExito>> handleJsonProcessing(JsonProcessingException ex) {
        RespuestaCreadoExito respuesta = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.BAD_REQUEST.value())
            .estado("Error: Formato JSON inválido")
            .datos(null)
            .build();
            
        return Mono.just(ResponseEntity.badRequest().body(respuesta));
    }

    private String getFieldName(InvalidFormatException ex) {
        if (ex.getPath() != null && !ex.getPath().isEmpty()) {
            return ex.getPath().get(ex.getPath().size() - 1).getFieldName();
        }
        return "campo";
    }

    private String createValidationMessage(String fieldName, Object value) {
        if ("edad".equals(fieldName)) {
            return "Solo se permiten números en el campo edad";
        }
        if ("id".equals(fieldName)) {
            return "Solo se permiten números en el campo id";
        }
        return String.format("Valor inválido '%s' para el campo %s", value, fieldName);
    }
}
