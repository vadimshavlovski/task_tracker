### Application
Rest API for task management

### Technologies
- Java 8
- Spring Boot
- Spring Data REST
- Spring HATEOAS
- HSQLDB
- Lombok

Todo Rest Api table:
### REST API
| URI                           | Method | Description           | Richardson Maturity Model Level |
| ---------------------         | ----   | ------------------------|---------------------------------|
|/tasks/                        | GET    | Display all tasks       | level 1 - Resources             |
|/tasks/search/in-progress      | GET    | Display all tasks in in-progress status| level 1 - Resources             |
|/tasks/{taskId}                | GET    | Get  task by id         | level 1 - Resources             |
|/tasks/                        | POST   | Add new task            | level 2 - HTTP verbs            |
|/tasks/{taskId}                | PUT    | Modify task by id       | level 2 - HTTP verbs            |
|/tasks/{taskId}                | DELETE  | Delete task by id      | level 2 - HTTP verbs            |
|/tasks/{taskId}/to-in-progress | POST | set task status to in-progress| level 3 - Hypermedia controls|
|/tasks/{taskId}/implement      | POST | set task status to implement  | level 3 - Hypermedia controls|
|/tasks/{taskId}/close          | POST | set task status to close      | level 3 - Hypermedia controls|
|                               |      |                         |  |

### Hypermedia level example:

curl http://localhost:8091/tasks/1/ 

Response:
```json
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
