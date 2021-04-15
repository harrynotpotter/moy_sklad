## Требования
Java 11,
Maven,
PostgresSQL 

## Сборка
`mvn clean compile`

## Запуск
`mvn spring-boot:run`

## Примечания
Приложение будет доступно на порту: 8189

Swagger доступен по ссылке: http://localhost:8189/swagger-ui/#/

В application.properties задать свои параметры подключения к базе данных:

`spring.datasource.url`
`spring.datasource.username`
`spring.datasource.password`

