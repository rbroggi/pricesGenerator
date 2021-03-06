
# Spring-boot - RabbitMq producer

Prices generator:
  * REST endpoint for price generation
  * RabbitMq messages producer

## Getting Started

1. Setup RabbitMq broker - see Prerequisites
2. git clone https://github.com/rbroggi/pricesGenerator
3. mvn spring-boot:run  

### Prerequisites

Setup RabbitMq broker:

docker run -p 5672:5672 -d --hostname my-rabbit --name some-rabbit rabbitmq:3

## Built With

* [Spring Boot](https://projects.spring.io/spring-boot/)
* [Maven](https://maven.apache.org/) - Dependency Management
* [RabbitMq](https://www.rabbitmq.com/) - Message broker


## Authors

* [Rodrigo Broggi](https://github.com/rbroggi)

## Acknowledgments

* Big thanks to [Josh Long](https://github.com/joshlong)

