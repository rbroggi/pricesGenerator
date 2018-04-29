
# Spring-boot - RabbitMq producer

Price generator with rest endpoint for generation and insert into rabbitMq subscriber

## Getting Started

Setup RabbitMq broker - see Prerequisites
git clone https://github.com/rbroggi/pricesGenerator
mvn spring-boot:run

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

