# Utilizar una imagen de Maven para construir el proyecto
FROM maven:3.9.3-eclipse-temurin-17 AS build

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias sin construir la aplicación
COPY pom.xml /app/
RUN mvn dependency:go-offline

# Copiar todo el código fuente de la aplicación
COPY src /app/src

# Compilar la aplicación
RUN mvn clean package -DskipTests

# Utilizar una imagen de JDK 17 para correr la aplicación
FROM eclipse-temurin:17-alpine

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo .jar desde la etapa de construcción
COPY --from=build /app/target/tasks-0.0.1-SNAPSHOT.jar /app/tasks.jar

# Exponer el puerto en el que corre la aplicación
EXPOSE 8080

# Configurar el comando para ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "tasks.jar"]
