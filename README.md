### Read Me First


Spring Boot microservice that fetches data from external API and procces data to show the three countries with the highest standard VAT rates and the three countries with the lowest reduced VAT rates.
Technologies, libraries used: Java 17 ,Maven ,Spring Boot ,Spring Boot Starter Web,Project Lombok

## Clone the repository:

 ```shell
git clone https://github.com/ristovuk/rates.git
```

## Manual Installation

Prerequisites For manual installation:

- OpenJDK 1.17
- Maven 3.x


```bash
cd ~/rates
```

```shell
mvn clean install 
```

```shell
mvn spring-boot:run     
```


## Swagger

After successfuly installation, API design could investigate with swagger on: [SwaggerUI](http://localhost:8080/swagger-ui/index.html) http://localhost:8080/swagger-ui/index.html



## API endpoints


[Highest standard rates](http://localhost:8080/rates/higheststandardrate)

[Lowest reduced rates](http://localhost:8080/rates/lowestreducedrates)



## localhost:8080

#### Highest standard rates
####  GET | /rates/higheststandardrate 

#### Lowest reduced rates
####  GET | /rates/lowestreducedrates 
