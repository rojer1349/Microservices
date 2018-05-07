# container-example
Sample Project with three Spring-Boot services. Talking to each other.


## Requirements
* Java JDK 1.8.0
* Maven 3.5
* Docker
* docker-compose


## Build

```
$ mvn clean package

$ docker-compose build
```

## Run

```
$ docker-compose up
```
*Try it out*:

```
$ curl localhost:8080 

HTTP/1.1 200
Content-Type: application/json;charset=UTF-8
Date: Mon, 07 May 2018 14:16:57 GMT
Transfer-Encoding: chunked

{
    "stateful": "true",
    "stateless": "Hello World"
}

```
