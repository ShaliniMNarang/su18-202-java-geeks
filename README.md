# su18-202-java-geeks

# Starbucks API - Microservices

## Microservices & Web UI
1.  [User Services](https://github.com/nguyensjsu/su18-202-java-geeks/blob/master/code/services/user/README.md)
2.  [Order Services](https://github.com/nguyensjsu/su18-202-java-geeks/blob/master/code/services/order/README.md)
3.  [Payment Services](https://github.com/nguyensjsu/su18-202-java-geeks/blob/master/code/services/payment-service/README.md)
4.  [Card Services](https://github.com/nguyensjsu/su18-202-java-geeks/blob/master/code/services/card-service/README.md)
5.  [Web UI](https://github.com/nguyensjsu/su18-202-java-geeks/blob/master/code/ui/README.md)

## Microservices Architecture
![Alt text](/Presentation/MicroservicesarchitectureDiagram.png)

## Service Architecture
![Alt text](/Presentation/ServiceArchitecture.png)

## Sequence Diagram
![Alt text](/UML/SequenceDiagram.png)

## GetSandbox Mock Services
At the start of the project, to prevent any blockers for web and mobile application developers, we designed the API structure and provided a mock services leveraging following technologies
* [RAML - RESTful API Modeling Language](https://github.com/nguyensjsu/su18-202-java-geeks/blob/master/code/services/user/user-service/src/main/resources/users.raml)
* [Getsandbox - Organize Mock REST services](http://wispy-waterfall-9509.getsandbox.com/api/v1/users)

![Alt text](/Presentation/GetSandBox-RAML.png)

## Aspect Oriented Programming
As an architect wanted to analyse the time it takes to execute a RESTful service, at the same time I do not want to burden individual developers to log time and dirty their code. So decided to leverage Spring AOP to weave the Logging aspect.

![Alt text](/Presentation/SpringAOP.png)

## Docker - Image
[Instructions to Create a Docker image](https://github.com/nguyensjsu/su18-202-java-geeks/blob/master/code/services/card-service/Dockercommands)
### Steps
1. Build a docker image of the Spring Boot application
2. Push the Docker image to dockerhub

## Cloud Container Service - GKE
[GKE is Google Kubernetes Engine](https://cloud.google.com/kubernetes-engine/)
User and Order services were deployed in GKE.
### Steps
1. Create a Project Google Cloud Platform
2. Create a Kubernetes Cluster for deployment
![Alt text](/Presentation/GKE-Clusters.png)
3. Create a Workload using the docker image
![Alt text](/Presentation/GKE-Workloads.png)
4. Expose the workload to public using service of type loadbalancer
![Alt text](/Presentation/GKE-Services.png)

## Cloud Container Service - ECS
[Amazon ECS is Amazon Elastic Container Service](https://aws.amazon.com/ecs/)
Card and Payment services were deployed in ECS.
### Steps
1. Create a container
![Alt text](/Presentation/AWSECSContainerDefinition.png)
2. Create a Task
![Alt text](/Presentation/AWSECSTaskDefinition.png)
3. Create a Service
![Alt text](/Presentation/AWSECSServiceDefinition.png)
4. Create a Cluster
![Alt text](/Presentation/AWSECSClusterDefinition.png)

## Unit Testing
Automated unit testing is an integral part of agile development principles. It makes the software coding agile. Developers can add new features or refactor code without having to worry about regression issues. Unit testing improves the quality of the code and lowers the cost of software maintainance as the bugs are detected early. As a team we had decided to add unit test cases for the project. We have used JUnit test framework to write unit test cases. Mokito is used to mock database objects because database calls are expensive and setting up data for unit testing is expensive. <br/>
Following screenshot is taken from one of the unit test classes. It shows the use of Mokito framework and various test cases written.

![Alt text](/Presentation/unitTest.png)


