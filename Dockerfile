FROM eclipse-temurin:11-jre-alpine as DEPLOY
# Set /app as workdir
WORKDIR /app
# Create a new user and group
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
# Copy jar file to deploy
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
# Run the JAVA application
CMD ["java","-jar","app.jar"]


# # TO enable complete build uncomment below and comment abouve
# # Use eclipse-temurin docker image as openjdk docker image is start deprecating
# FROM eclipse-temurin:11-alpine as BUILD
# # Set /app as workdir
# WORKDIR /app
# # Copy all necessory files and folder
# COPY src src 
# COPY .mvn .mvn
# COPY mvnw mvnw
# COPY pom.xml pom.xml
# COPY config/application.properties config/application.properties
# # Create a jar package
# RUN ./mvnw package -DSkipTests

# FROM eclipse-temurin:11-jre-alpine as DEPLOY
# # Set /app as workdir
# WORKDIR /app
# # Create a new user and group
# RUN addgroup -S spring && adduser -S spring -G spring
# USER spring:spring
# # Copy jar file to deploy
# COPY --chown=spring:spring --from=BUILD /app/target/amnic*.jar /app/app.jar
# # Run the JAVA application
# CMD ["java","-jar","app.jar"]