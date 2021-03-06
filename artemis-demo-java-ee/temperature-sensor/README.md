# temperature-sensor

A Java EE application using Hazelcast and MongoDB with Java EE 7 technology.

![MongoDB Project](https://github.com/JNOSQL/jnosql-site/blob/master/assets/img/logos/mongodb.png)


**Mongodb**: MongoDB is a free and open-source cross-platform document-oriented database program. Classified as a NoSQL database program, MongoDB uses JSON-like documents with schemas.


To run this project a MongoDB instance is required, so you can use either a local instalation or using Docker.


## Manual instalation

Follow the instructions in: http://cassandra.apache.org/doc/latest/getting_started/installing.html


## Using Docker

![Docker](https://www.docker.com/sites/default/files/horizontal_large.png)


1. Install docker: https://www.docker.com/
1. https://store.docker.com/images/mongo
1. Run docker command
1. `docker run -d --name mongodb-instance -p 27017:27017 mongodb`



## Run the code

To run the code you can either get the war and put in any Java EE8 server.


### Run the code

* http://localhost:8080/ check the screen with JSF primefaces
* GET http://localhost:8080/resource/api/v1/sensors/
* GET http://localhost:8080/resource/api/v1/sensors/ids                      
* GET http://localhost:8080/resource/api/v1/sensors/{id}
* POST http://localhost:8080/resource/api/v1/sensors/ ->      void save(SensorRepresentation)      