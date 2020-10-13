# Pre-assignment for ASSA Abloy
Pre-assignment for Assa Abloy as a interview test

MoviesAPI is a REST API which return the list of movies according to the genre preference of the user. The API is build using following tools and technologies.

1. Maven
2. Spring Boot
3. Junit
3. Spring Tool Suite

Some answers and ellaboration related to the questions and tips asked in pre-assignment email are as follows.

This application is a maven based project. Currently, there is no access to other external services e.g., netflix, and Imdb, etc. So, in the Movies Data Access Object (MoviesDAOImpl.java) class I have pre-populated the data so that the endpoint can filter the data according to the genre and return to the user. In the future If we have access to the external services then we can add NetFlix and Imbd api dependencies into the pom.xml file and can comsume them.

Question: What kind of architecture would you use to achieve this?

Answer : I have used Spring to build this application which gives dependency injection functionality and makes the applicaiton loosely coupled. In spring have used Spring Boot
framework. I have developed multiple layers in the application i.e., Services, and Data Access Object layers and separate controller (MoviesController.java) for endpoints.

Question: How would you design your application for testability?

Answer : As mentioned in point 2, there are multiple layers introduced in the application, Integration tests are developed java/src/tests folder. There is no persistence implemented in 
this applicaiton so I didn't test the DAO layer, the good thing is that the layers are separate so each layer can be tested.

Question: There is no need to implement persistence, but how would you take that into account?

Answer : In the application we can implement persistence by adding dependencies in the pom.xml file and writing the functions in the Data Access Object layer and defining the connection
properties in the application.properties file. E.g., If we decide to use mysql and Hibernate, then we can add mysql connector and hibernate dependencies in the pom.xml file, 
functions that interact with the database in the Data Access Object Layer, and defining connection properties in the application.properties file.

Question: If you later decide to migrate to a microservice architecture, what kind of patterns would you use for this?

Answer : If later I decide to migrate to a microservice architecture, the first thing I would do is to identify the code that can be separated. For example in the future we develop another service which deals with Movies Purchase (sort of a shopping cart service), and another service which handles the payment system, etc. Those separate microservices should be as loosely coupled as possible and should interact with each other thorugh well defined apis. Containers e.g., Docker, Container Orchestration e.g., Kubernetes and cloud service e.g., AWS, Azure, etc. also play a key role for a monolithic applicaiton to be migrated to a microservice architectured application.	
