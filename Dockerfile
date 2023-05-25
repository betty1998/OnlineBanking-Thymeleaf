FROM openjdk:17
EXPOSE 8080
ADD target/online-banking-aws.jar online-banking-aws.jar
ENTRYPOINT ["java","-jar","/online-banking-aws.jar"]