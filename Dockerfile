FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/YOUR-PROJECT-NAME-1.0.jar app.jar  
# CHANGE above: all lowercase e.g. shoppingcart-1.0.jar

# tail -f /dev/null keeps the container alive so Kubernetes shows "Running" status
CMD ["sh", "-c", "java -jar app.jar; tail -f /dev/null"]
