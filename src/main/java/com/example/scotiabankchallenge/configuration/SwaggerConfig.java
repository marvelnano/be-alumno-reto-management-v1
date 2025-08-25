package com.example.scotiabankchallenge.configuration;

import org.springframework.http.HttpHeaders;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "API ALUMNOS",
                description = "Our app provides a concise listing of students names",
                termsOfService = "www.jmvr.com/terminos_y_servicios",
                version = "1.0.0",
                contact = @Contact(
                        name = "Soporte",
                        url = "www.jmvr.com",
                        email = "contact@jmvr.com"
                ),
                license = @License(
                        name = "Standard Software Use License for JMVR",
                        url = "www.jmvr.com/license"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:8088"
                ),
                @Server(
                        description = "PROD SERVER",
                        url = "http://jmvr:8080"
                )
        }
)

@SecurityScheme(
        name = "Security Token",
        description = "Access Token For My API",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)

public class SwaggerConfig {
}
