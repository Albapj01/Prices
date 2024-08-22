# PRICES

## How to start

First of all, to prove that the project is updated and ready, you need to execute the command:

```sh
mvn clean install
```

Then, when it passes correctly, you can run the project with the command:

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

## Service

If you want to prove the service, you can do it with Postman, which is a tool to test and develop APIs. Then, you need to create a new request in which you have to select the method `GET`, introduce an url and finally send it.

For example, you can introduce localhost:8080/price/search?date=2020-06-14T10:00:00&idProduct=35455&idBrand=1 and then it is going to return the information of the price that you are looking for in a json:

```json
{
  "productId": "35455",
  "brandId": "1",
  "rate": "1",
  "dateStart": "2020-06-14-00.00.00",
  "dateEnd": "2020-12-31-23.59.59",
  "price": "35,50 EUR"
}
```
