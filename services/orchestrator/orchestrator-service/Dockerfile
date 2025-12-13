# Utiliser l'image corrigée
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /workspace

# 1. Copier et installer la dépendance Emergency gRPC
# Notez l'ajout de "services/" dans les chemins
COPY services/emergency-grpc/pom.xml services/emergency-grpc/pom.xml
COPY services/emergency-grpc/src services/emergency-grpc/src
RUN mvn -f services/emergency-grpc/pom.xml install -DskipTests

# 2. Copier et compiler l'Orchestrateur
COPY services/orchestrator/orchestrator-service/pom.xml services/orchestrator/orchestrator-service/pom.xml
COPY services/orchestrator/orchestrator-service/src services/orchestrator/orchestrator-service/src
# On lance le build
RUN mvn -f services/orchestrator/orchestrator-service/pom.xml clean package -DskipTests

# Étape d'exécution
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
# On récupère le jar généré
COPY --from=build /workspace/services/orchestrator/orchestrator-service/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]