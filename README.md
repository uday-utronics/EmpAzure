# Spring Boot with Azure Sql

```java
public class Employee {
    @Id
    @GeneratedValue
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private int id;
    private String name;
    private String dept;
    private long salary;
}
```
#### In this Employee class, the id field is marked with the @Id and @GeneratedValue annotations, which indicates that this field is the primary key for the Employee entity and is automatically generated by the database. The @Schema annotation is used to set the accessMode attribute to READ_ONLY, which tells the springdoc-openapi-ui library to only include this field in the response payload and to exclude it from the request payload.

#### The name, dept, and salary fields are not marked with the @Schema annotation, which means that they will be included in both the request and response payloads.

- - - -
### Custom Query
```java
    @Query("SELECT e FROM Employee e WHERE e.id = :id")
    Optional<Employee> findByEmployeeId(@Param("id") Integer id);
```
<details>
           <summary>Explanation</summary>
           <p>The @Query annotation is used to define a custom query in a Spring Data repository. In the example you provided, the query selects an Employee entity by its id field.

Here's a breakdown of what the query does:

SELECT e: This part of the query selects the Employee entity.
FROM Employee e: This part of the query specifies the entity to select from.
WHERE e.id = :id: This part of the query filters the results to only include the Employee entity with the specified id value.
The findByEmployeeId method returns an Optional<Employee> object, which represents an Employee entity with the specified id value, if it exists.

The @Param("id") annotation is used to specify the value of the id parameter in the query.

Note that in this query, Employee is the entity name, not the table name. Spring Data uses the entity name to generate the SQL query. If you want to use a custom table name, you can specify it in the @Table annotation on the Employee entity class.</p>
         </details>

- - - -
#### Request
```json
{
  "name": "John Doe",
  "dept": "IT",
  "salary": 50000
}

```
#### Response
```json
{
  "id": 1,
  "name": "John Doe",
  "dept": "IT",
  "salary": 50000
}

```