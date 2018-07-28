## About
The order microservice has been written to simulate a Starbucks coffee order processing. 

## Technologies used
1. Spring Boot Web, MVC, JPA, AOP
2. Java 8
3. MySQl
4. Tomcat
5. Maven
6. Docker

## Setup Instructions
### Local Installation
1. Git clone the repository
2. Import the project as an existing maven project in eclipse/maven
3. Update applications.properties to provide the database connection details and the desired port number
4. Compile the project 
5. Run the project as Spring boot application

### Docker 
1. The docker file and maven docker plugin are already checked in
2. Run following mvn command to create docker image: <br/>
   mvn package dockerfile:build -DskipTests;
3. To run docker image: <br/>
   docker run -p 5000:5000 -t java-geeks-card-service/order-service  

## UML Diagrams
### Class Diagram
![alt text](https://github.com/nguyensjsu/su18-202-java-geeks/blob/master/UML/orders/Starbucks_orders_class_diagram.png "Class Diagram")

### Sequence Diagram
![alt text](https://github.com/nguyensjsu/su18-202-java-geeks/blob/master/UML/orders/Starbucks_orders_sequence_diagram.png "Seq Diagram")

## REST API calls 
#### RAML 
https://github.com/nguyensjsu/su18-202-java-geeks/blob/master/code/services/order/src/main/resources/orders.raml

#### Mock API 
http://sandbox-starbucks-order.getsandbox.com/api/orders

#### Sample Requests
1. Get a list of orders <br/>
http://<host>:<port>/api/orders <br/>

2. Get a specific Order  <br/>
http://<host>:<port>/api/orders/{id}
  
3. Create an order  <br/>
http://<host>:<port>/api/orders
Payload : {"customerId":"shalini","orderDate":"2018-07-23T05:36:57.124Z","productId":"P1","productName":"CaffÃ¨ Americano","amount":3.25}
