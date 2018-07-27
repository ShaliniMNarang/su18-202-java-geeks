# su18-202-java-geeks

## Starbucks API - Microservices

### Components Architecture
![Alt text](/Presentation/ServiceArchitecture.png)

### Sequence Diagram
![Alt text](/UML/SequenceDiagram.png)

### Microservices
1.  [User Services](https://github.com/nguyensjsu/su18-202-java-geeks/blob/master/code/services/user/README.md)
2.  [Order Services](https://github.com/nguyensjsu/su18-202-java-geeks/blob/master/code/services/order/README.md)
3.  [Payment Services](https://github.com/nguyensjsu/su18-202-java-geeks/blob/master/code/services/payment-service/README.md)
4.  [Card Services](https://github.com/nguyensjsu/su18-202-java-geeks/blob/master/code/services/card-service/README.md)

### GetSandbox Mock Services
At the start of the project, to prevent any blockers for web and mobile application developers, we designed the API structure and provided a mock services leveraging following technologies
* [RAML - RESTful API Modeling Language](https://github.com/nguyensjsu/su18-202-java-geeks/blob/master/code/services/user/user-service/src/main/resources/users.raml)
* [Getsandbox - Organize Mock REST services](http://wispy-waterfall-9509.getsandbox.com/api/v1/users)

![Alt text](/Presentation/GetSandBox-RAML.png)

### Aspect Oriented Programming
As an architect wanted to analyse the time it takes to execute a RESTful service, at the same time I do not want to burden individual developers to log time and dirty their code. So decided to leverage Spring AOP to weave the Logging aspect.

![Alt text](/Presentation/SpringAOP.png)

