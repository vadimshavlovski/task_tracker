### Application
Rest API for task management

### Technologies
- Java 8
- Spring Boot
- Spring Data REST
- Spring HATEOAS
- HSQLDB
- Lombok

### REST API
| URI                           | Method | Description           |
| ---------------------         | ----   | ------------------------|
|/tasks/                        | GET    | Display all tasks       | 
|/tasks/search/in-progress      | GET    | Display all tasks in in-progress status| 
|/tasks/{taskId}                | GET    | Get  task by id         | 
|/tasks/                        | POST   | Add new task            | 
|/tasks/{taskId}                | PUT    | Modify task by id       | 
|/tasks/{taskId}                | PATCH  | Merge task by id       | 
|/tasks/{taskId}                | DELETE | Delete task by id      | 
|/tasks/{taskId}/to-in-progress | POST | set task status to in-progress| 
|/tasks/{taskId}/implement      | POST | set task status to implement  | 
|/tasks/{taskId}/close          | POST | set task status to close      | 
|                               |      |                         |  

### Support HTTP Codes
| Code   |  Status                |
|--------|------------------------|
|200     | Ok                     |
|201     | Created                |
|304     | Not Modified           |
|400     | Bad request            |
|404     | Not Found              |
|409     | Conflict               |
|        |                        |



### Hypermedia example:

curl http://localhost:8091/tasks/1/ 

Response:
```java
{
  "name" : "Create Enum",
  "description" : "Create enum for marital status with the ability to find an instance of id",
  "status" : "NEW",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8091/tasks/1"
    },
    "task" : {
      "href" : "http://localhost:8091/tasks/1"
    },
    "update" : {
      "href" : "http://localhost:8091/tasks/1"
    },
    "delete" : {
      "href" : "http://localhost:8091/tasks/1"
    },
    "set-to-in_progress" : {
      "href" : "http://localhost:8091/tasks/1/to-in-progress"
    }
  }
}
```
