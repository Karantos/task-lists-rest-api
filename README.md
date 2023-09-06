<<<<<<< HEAD
# Task Lists App Project
A simple todo application REST API developed using Spring Boot. User can add multiple lists with tasks or items that need to be done.

App made as a final project for **Web application development project** course which was part of 6-month training program [Programing and application development - PRA](https://www.fis.unm.si/studijski-programi/polletna-izobrazevanja/).

Used **Spring Data JPA** for CRUD operations on a **MySQL** database. Frontend was made with **Vue** and **Vuetify** and can be found as a separate project [here](https://github.com/Karantos/ListsApp-VueFrontend). 

## API Endpoints
A short summary of available REST API Endpoints for the functionalities of the app that have been implemented.

| Method |   Resource               | Description                      |
| :----: | :-----------:            | -------------                    |
| `GET`  | `api/lists/getAll`          | Get all lists                    |
| `GET`  | `api/lists/get/{id}`        | Get specific list with that id   |
| `GET`  | `api/lists/getTasks/{id}`    | Get tasks by list id  |
| `POST`  | `api/lists/add`            | Create new list (list object in Request Body)                   |
| `PUT`  | `api/lists/update`          | Update that list (list object in Request Body)                    |
| `DELETE`  | `api/lists/delete/{id}`  | Delete that list                     |
| `GET`  | `api/tasks/getAll`          | Get all tasks                    |
| `GET`  | `api/tasks/get/{id}`          | Get specific task with that id                 |
| `GET`  | `api/tasks/getList/{id}`          | Get specific list by task id                   |
| `POST`  | `api/tasks/add`          | Create new task (task object in Request Body)                |
| `PUT`  | `api/tasks/update`          | Update that task (task object in Request Body)                  |
| `DELETE`  | `api/tasks/delete/{id}`  | Delete that task                     |

## Tools Used
* Spring Boot 3
* Spring Framework 6
* Spring Data JPA
* Hibernate
* Apache Maven
* MySQL database

### TODO
* Implement authentication & authorization with **Spring Security** using **JWT** and/or **OAuth2**

=======
# ListsApp-Project
Todo lists app made while learning spring boot and vue.js 
>>>>>>> d004fe51cffe83b5cc537e91c75c530866398f00
