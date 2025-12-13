# 1. On change légèrement la version (8.6 au lieu de 8.5) pour forcer un téléchargement neuf
FROM gradle:8.6.0-jdk17-jammy AS build

# 2. On passe explicitement en ROOT pour avoir tous les droits
# (Cela règle définitivement les problèmes de permissions et de "chown")
USER root

WORKDIR /app

# 3. Copie simple (plus besoin de chown complexe)
COPY . .

# 4. Compilation (sans tests pour aller plus vite)
RUN gradle build -x test --no-daemon

# --- Étape finale ---
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
# On récupère le jar (le chemin standard est build/libs)
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]