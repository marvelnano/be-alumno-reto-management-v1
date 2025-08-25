# be-scotiabank-challenge-v1

_Repositorio de Proyecto de creación de microservicio para el registro de alumnos_


## Getting Started

## Requisitos

- Java 11
- Springboot 2.7.7
- Gradle - Groovy
- ~~H2~~ (Not Enabled)
- Colección Map<Integer, Alumno> (Enabled)

## Configuración

Para la correcta configuración del servicio, se recomienda usar la configuracione establecida en el archivo ~~`application.properties`~~ `application.yml` y `build.gradle`del proyecto.

- **`build.gradle:`** Se encarga de compilar, empaquetar y gestionar las dependencias.
- **`application.properties:`** Se encarga de la configuración de la aplicación cuando se ejecuta.

## Ejecutando las pruebas ⚙️

_Abrir el repositorio(proyecto) en VSCode, Spring Tool Suite 4 o Intellij Idea_

### Realizar las pruebas de forma local 🔩

* Para compilar todo el código, ejecutar las pruebas y generar el `.jar` en `build/libs/` en la consola del proyecto en VSCode escribir:
```
./gradlew.bat build
```

* Para correr la aplicación, en la consola del proyecto en VSCode escribir:
```
./gradlew.bat bootRun
```

* Para probar con swagger usar esto:
```
/swagger-ui.html
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

## Comandos Docker 🐳

* Para construir la imagen y levantar los servicios definidos en `docker-compose.yml`:
```
docker-compose build
docker-compose up
```

* Para ejecutar comandos dentro del contenedor (ej: gradle build):
```
docker-compose exec app bash
```

* Dentro del contenedor, puedes ejecutar:
```
gradle build
gradle bootRun
```

* Para detener los servicios:
```
docker-compose down
```

* Para ver los logs del servicio:
```
docker-compose logs
```