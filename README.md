# spring boot microservices with Grpc & Kafka.

this is a simple project built using spring boot, where I implement the following technologies:
- _Grpc_ for synchronous calls between microservices.
- _Kafka_ for queued messages.

### the project contains 3 subs projects:
- a user microservice to create, get and delete users.
- a post microservice to create, list, get.
- a maven project that contains the **.proto** file to generate an interface containing messages and services. this interface is used as a dependency in both microservices.

## project schema

<p align="center">
  <img width="600px" src="https://github.com/djellalmohamedaniss/grpc-spring-boot-microservice-with-istio/blob/master/grpc-spring-boot-microservice-with-k8s-istio.jpg">
</p>

### user microservice available routes are:

| url | method | description |
| --- | --- | --- |
| /users | GET | get all users |
| /users/{user} | GET | get a user by its id |
| /users/{user} | DELETE | delete a user by its id |

### post microservice available routes are:

| url | method | description |
| --- | --- | --- |
| /posts/{post} | GET | get a post by its id |
| /posts | POST | create a post |
| /users/{user}/posts/{post} | GET | get a post of a specific user |

### where i'm using Grpc?

used for synchronous call between the post microservice and the user service, where the post microservice sends a request to the user microservice to check if a user exists when the `/users/{user}/posts/{post}` route is called.

communication is occured using the generated interface.

```java
 service UserService {
  rpc getUserById(UserEntityRequest) returns (UserEntityResponse) {};
}
```

### where i'm using Kafka?

when a user is deleted, a **producer** generates a message with `user-deleted` topic that will be intercepted by a **consumer** in the post microservice. this one will delete all user's posts.


