# bs-student-management-v1

_Repositorio de proyecto de creación de microservicio para el registro de alumnos_



## Getting Started

## Requisitos

- Java 17
- Spring Boot 3.3.0
- Maven
- Postgres

## Configuración

Para la correcta configuración del servicio, se recomienda usar la configuracione establecida en el archivo `application.properties` del proyecto.

## Ejecutando las pruebas ⚙️

_Abrir el repositorio(proyecto) en VSCode o Spring Tool Suite 4_

### Realizar las pruebas de forma local 🔩

* En la consola del proyecto en VSCode escribir:
```
mvnw spring-boot:run
```

* En la consola del proyecto en VSCode linux escribir:
```
./mvnw spring-boot:run
```

* En Spring Tool Suite 4 ir a Boot Dashboard, desglosar local, seleccionar el proyecto, click derecho y start:

### Abrir un cmd en la ubicación del Spring Tool Suite y escribir:

* para saber la versión de java que tenemos:
```
java -version
```

* Para poder usar lombok en el IDE(para eso debemos de tener el archivo lombok.jar dentro de la ruta del STS):
```
java -jar lombok.jar
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#using.devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)