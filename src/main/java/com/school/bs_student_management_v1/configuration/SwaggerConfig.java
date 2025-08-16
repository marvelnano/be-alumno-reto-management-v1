package com.school.bs_student_management_v1.configuration;

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
        title = "API COLEGIO",
        description = "Our app provides a concise listing of football team names",
        termsOfService = "www.solucionesjv.com/terminos_y_servicios",
        version = "1.0.0",
        contact = @Contact(
            name = "Soporte",
            url = "www.solucionesjv.com",
            email = "contact@solucionesjv.com"
        ),
        license = @License(
            name = "Standard Software Use License for SolucionesJV",
            url = "www.solucionesjv.com/license"
        )
    ),
    servers = {
        @Server(
            description = "DEV SERVER",
            url = "http://localhost:8080"
        ),
        @Server(
            description = "PROD SERVER",
            url = "http://solucionesjv:8080"
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

public class SwaggerConfig {}
