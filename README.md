# Spring-boot-API-in-Memory-Database-with-Spring-Data

This is a Spring boot web Application with in memory database h2 and the spring-data library, there are a set of endpoints with different behaviors, the code base was built using java 8.


The definitions and requirements are listed as follow:

Each event data is a JSON entry with the following keys:

• id: This is the item unique ID.

• name: This is the item name.

• description: This is the item description.

• price: This is the price for the item.

The REST service should implement the following functionalities:


1.Adding new item: The service should be able to add a new item by the POST request.The item JSON is sent in the request body.Before inserting into table implemented validation for the given input JSON.
...
Request Url:
	POST http://localhost:8080/item
Request Body:
 	{
    "id": null,
    "name": "MarkerPen",
    "details":"A marker pen consists of a container (glass, aluminum or plastic) and a core of an absorbent material that holds the ink.",
    "price": 50
    }
 ...





2.Adding List of new item : The service should be able to add a list of item by the POST request.The item JSON is sent in the request body.Before inserting into table implemented validation for the given input JSON.
...
Request Url:
	POST http://localhost:8080/item/postAll
Request Body:
 	[{
    "id": null,
    "name": "MarkerPen",
    "details":"A marker pen consists of a container (glass, aluminum or plastic) and a core of an absorbent material that holds the ink.",
    "price": 50
    }]
...




3.Returning all the item: The service should be able to return the JSON array of all the item by the GET request at /events. The HTTP response code should be 200.
...
Request Url:
	GET http://localhost:8080/item
...




4.Returning the item: The service should be able to return the detail of a specific item.
...
Request Url:
	GET http://localhost:8080/item/1
...




## TO_DO

Implement Swagger documentation in each Endpoint.
