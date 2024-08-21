# PRICES

## How to start

First of all, to prove that the project is updated and ready, you need to execute the command:

```sh
mvn clean install
```

Then, when it passes correctly, you can run the this project with the command:

```sh
./mvnw spring-boot:run
```

## Database

At the same time that the application is running, you can go to the browser and put http://localhost:8080/h2-console to see the H2 database. Besides, if you want to see all the information that it has, you can write the following query:

```sh
SELECT * FROM PRICES
```

## Tests

When you do the first command, you can see if the test passes or not. However, if you update some test and you want to prove that they continue passing, you need to execute the command:

```sh
mvn test
```
