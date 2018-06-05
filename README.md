### Application
Hypermedia Rest API for task management :fire:

### Technologies
- Java 8
- Spring Boot
- Spring Data REST
- Spring HATEOAS
- HSQLDB
- Lombok

### REST API
| URI                             | Method     | Description                            |
| ---------------------           | ----       | ------------------------               |
|*/tasks/*                        | **GET**    | Display all tasks                      | 
|*/tasks/search/in-progress*      | **GET**    | Display all tasks in in-progress status| 
|*/tasks/{taskId}*                | **GET**    | Get  task by id                        | 
|*/tasks/*                        | **POST**   | Add new task                           | 
|*/tasks/{taskId}*                | **PUT**    | Modify task by id                      | 
|*/tasks/{taskId}*                | **PATCH**  | Merge task by id                       | 
|*/tasks/{taskId}*                | **DELETE** | Delete task by id                      | 
|*/tasks/{taskId}/to-in-progress* | **POST**   | Set task status to in-progress         | 
|*/tasks/{taskId}/implement*      | **POST**   | Set task status to implement           | 
|*/tasks/{taskId}/close*          | **POST**   | Set task status to close               | 
|                                 |            |                                        |  

### Support HTTP Codes
| Code       |  Status                |
|--------    |------------------------|
|**200**     | Ok                     |
|**201**     | Created                |
|**304**     | Not Modified           |
|**400**     | Bad request            |
|**404**     | Not Found              |
|**409**     | Conflict               |
|            |                        |



### Hypermedia level

The Hypermedia level is shown in "_links" field:

1. For NEW task you can modify task (PUT, PATCH), delete task (DELETE) or set task status to IN_PROGRESS

      ```java
      curl http://localhost:8091/tasks/1/ 

      Response:
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
      
2. For IN_PROGRESS task you can set task to IMPLEMENTED

      ```java
      curl -X POST http://localhost:8091/tasks/1/to-in-progress

      Response:

        {
            "name": "Create Enum",
            "description": "Create enum for marital status with the ability to find an instance of id",
            "status": "IN_PROGRESS",
            "_links": {
                "self": {
                    "href": "http://localhost:8091/tasks/1"
                },
                "task": {
                    "href": "http://localhost:8091/tasks/1"
                },
                "implement": {
                    "href": "http://localhost:8091/tasks/1/implement"
                }
            }
        }
      ```
      
3. For IMPLEMENTED task you can return task back to IN_PROGRESS or set status to CLOSED

      ```java
      curl -X POST http://localhost:8091/tasks/1/implement

      Response:
        {
            "name": "Create Enum",
            "description": "Create enum1 for marital status with the ability to find an instance of id",
            "status": "IMPLEMENTED",
            "_links": {
                "self": {
                    "href": "http://localhost:8091/tasks/1"
                },
                "task": {
                    "href": "http://localhost:8091/tasks/1"
                },
                "set-to-in_progress": {
                    "href": "http://localhost:8091/tasks/1/to-in-progress"
                },
                "close": {
                    "href": "http://localhost:8091/tasks/1/close"
                }
            }
        }
      ```
