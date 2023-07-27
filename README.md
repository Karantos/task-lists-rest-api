# TodoListsApp-Project
A simple todo application REST API developed using Spring Boot. User can add multiple lists with tasks or items that need to be done.

App made as a final project for **Web application development project** course which was part of 6-month training program [Programing and application development - PRA](https://www.fis.unm.si/studijski-programi/polletna-izobrazevanja/).

Used **Spring Data JPA** for CRUD operations on a **MySQL** database. Frontend was made with **Vue** and **Vuetify** and can be found as a separate project [here](https://github.com/Karantos/ListsApp-VueFrontend)https://github.com/Karantos/ListsApp-VueFrontend). 


**TODO**: Implement authentication & authorization with **Spring Security** using **JWT** and/or **OAuth2**


## API Endpoints
A short summary of available REST API Endpoints for the functionalities of the app that have been implemented.

| Method |   Resource               | Description                      |
| :----: | :-----------:            | -------------                    |
| `GET`  | `/lists/getAll`          | Get all lists                    |
| `GET`  | `/lists/get/{id}`        | Get specific list with that id   |
| `GET`  | `/lists/getTask/{id}`    | Get specific list by task id  |
| `POST`  | `/lists/add`            | Create new list (list object in Request Body)                   |
| `PUT`  | `/lists/update`          | Update that list (list object in Request Body)                    |
| `DELETE`  | `/lists/delete/{id}`  | Delete that list                     |
| `GET`  | `/tasks/getAll`          | Get all tasks                    |
| `GET`  | `/tasks/get/{id}`          | Get specific task with that id                 |
| `GET`  | `/tasks/getTask/{id}`          | Get specific task by list id                   |
| `POST`  | `/tasks/add`          | Create new task (task object in Request Body)                |
| `PUT`  | `/tasks/update`          | Update that task (task object in Request Body)                  |
| `DELETE`  | `/tasks/delete/{id}`  | Delete that task                     |

## Tools Used
* Spring Boot 3
* Spring Framework 6
* Spring Data JPA
* Hibernate
* Apache Maven
* MySQL database

