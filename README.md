# spring boot microservices with Grpc & Kafka.

this is a simple project built using spring boot, where I implement the following technologies:
- _Grpc_ for synchronous calls between microservices.
- _Kafka_ for queued messages.

### the project contains 3 subs projects:
- a user service to create, get and delete users.
- a post service to create, list, get.
- an interface that contains the **.proto** file to generate messages and services classes. this interface is used as a dependency in both microservices.

### user service available routes are:

url | method | description
--- | --- | ---
/users | GET | get all users
--- | --- | ---
/users/{id} | GET | get a user
--- | --- | ---
/users/{id} | DELETE | delete a user
--- | --- | ---