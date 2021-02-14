# fizzbuzz spring boot solution
Application accepts a range of integer values specified by start and stop value and returns array of objects containing the input and output values. For multiples of three it returns “fizz” instead of the number and for the multiples of five returns “buzz”. For numbers which are multiples of both three and five it returns “fizzbuzz” and for all other numbers it returns the string representation of the integer.

# Command Line usage
java -jar fizzbuzz-0.0.1.jar

# Deployment
Spring boot application is dockerized. Run the following commands to build and start the application in docker container:
Execute maven command line to package the application: mvn install
docker build -t spring-boot:1.0 .
docker run -d -p 8080:8080 -t spring-boot:1.0

# Api Documentation
Swagger documentation can be accessed from the following url:
http://localhost:8080/swagger-ui.html#
