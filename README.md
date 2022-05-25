# Exchange rate API

API to manage historical exchange rate. 


## Overview  
An API project built with:

- API first development approach;
- use of API spec to auto-generate an Open-API server in java using the SpringBoot framework; 
- organize code following hexagonal architecture;
- implement code using TDD approach.

### API First 
To build API spec was used [Apicurio studio](https://www.apicur.io/studio/) a good open source tool.
You can see the generated Open API file *storico-cambi-service.yaml*


### Generate Server
This server was generated by the [OpenAPI Generator](https://openapi-generator.tech) project.
The underlying library integrating OpenAPI to SpringBoot is [springfox](https://github.com/springfox/springfox)
You can generate OpenAPI-enabled server in Java using the SpringBoot framework using *generate_src.sh*

### Hexagonal Architecture
Server create was implemented following the clean Hexagonal Architecture.

### TDD
Was followed the Test Driven Development approach.

## To learn more
Search on google there is a ton of useful link and video. :)# petstore-service
