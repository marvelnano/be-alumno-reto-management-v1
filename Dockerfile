# Usamos una imagen con JDK 11 y Gradle instalado
FROM gradle:7.6.1-jdk11

# Creamos un usuario no root para seguridad
RUN useradd -m gradleuser
WORKDIR /home/gradleuser/app
USER gradleuser

# Copiamos el proyecto (solo los archivos necesarios para la build)
COPY --chown=gradleuser:gradleuser build.gradle settings.gradle gradle/ ./

# Copiamos el código fuente (en una capa separada para aprovechar el cache)
COPY --chown=gradleuser:gradleuser src/ ./src/

# Exponemos el puerto de Spring Boot
EXPOSE 8088

# Comando para compilar y ejecutar
CMD ["gradle", "bootRun"]
