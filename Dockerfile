FROM eclipse-temurin:17-jdk
docker tag consumo_apis:latest isaelfatamadev/consumo_apis:latest
# Define el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR a la imagen
ARG JAR_FILE=target/consumo_apis-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Expone el puerto de la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
