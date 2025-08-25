package com.example.scotiabankchallenge.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString   
public class RespuestaCreadoExito {

    @JsonProperty("codeStatus")
    private Integer codigo;

    @JsonProperty("message")
    private String estado;

    @JsonProperty("data")
    private Object datos;
    
}
