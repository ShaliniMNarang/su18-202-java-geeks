FROM java
EXPOSE 8080
ADD ./payment-service-0.0.1.jar payment-service-0.0.1.jar
RUN bash -c 'touch /payment-service-0.0.1.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/payment-service-0.0.1.jar"]
