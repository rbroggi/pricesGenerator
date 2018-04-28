
# Project Title

Price generator with rest endpoint for generation and insert into rabbitMq subscriber

## Getting Started

Setup RabbitMq broker - see Prerequisites
git clone <url>
mvn spring-boot:run

### Prerequisites

Setup RabbitMq broker:

docker run -p 5672:5672 -d --hostname my-rabbit --name some-rabbit rabbitmq:3

## Built With

* [Spring Boot](https://projects.spring.io/spring-boot/)
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://www.rabbitmq.com/) - Message broker

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags).

## Authors

* **Rodrigo Broggi** - *Initial work* [Rodrigo Broggi](https://github.com/rbroggi)

## Acknowledgments

* Big thanks to Josh Long [Josh Long](https://github.com/joshlong)

