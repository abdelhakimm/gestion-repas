# Étape 1 : Utiliser une image officielle Java 17 comme base
FROM openjdk:17-jdk-slim

# Étape 2 : Définir le répertoire de travail
WORKDIR /app

# Étape 3 : Copier le fichier JAR généré dans le conteneur
COPY target/*.jar app.jar

# Étape 4 : Lancer l'application en lisant les variables d'environnement
ENTRYPOINT ["java", "-Dspring.datasource.url=${SPRING_DATASOURCE_URL}", "-Dspring.datasource.username=${SPRING_DATASOURCE_USERNAME}", "-Dspring.datasource.password=${SPRING_DATASOURCE_PASSWORD}", "-jar", "app.jar"]
