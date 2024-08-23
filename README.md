
## REST API Book Service (v0.1)

Book service REST API project based on Java Spring/React.


## Overview:

Project that work with 2 different sides:
- Frontend: writen with React;
- Backend: writen on Java with Spring Boot framework;
## Used tools/technologies

[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/) 
[![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)](https://react.dev/)
[![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)]()
[![Intellij IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)]()
[![VSCode](https://img.shields.io/badge/VSCode-0078D4?style=for-the-badge&logo=visual%20studio%20code&logoColor=white)]()
[![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white)]()
## Demo

![demo](https://github.com/user-attachments/assets/27e58486-d644-4097-bbee-cb111007c6fb)



## Endpoints

All endpoint based on one controller with RequestMapping **("/api/book/data")**

| Method  | URL | Params | Description |
| ---- | ------------- |-------------|-|
| GET  | /get-book/search  | title, page, ~~size~~ | Recive book list based on page and title params.
| GET  | /{id} | - | Receive one book based on it's ID |
| POST | ~~/add-new~~ | - | Work in progress

- title - by default "".
- page - by default 0.
- size - by default 20, (currently not implemented) 


## Dataset

For this project i use dataset from [here](https://www.kaggle.com/datasets/saurabhbagchi/books-dataset).

Original csv has **271 361** rows of data with following fields:
- isbn
- book_title
- book_author
- year_of_publication
- publisher
- image_url_s
- image_url_m
- image_url_l

I use PostgreSQL so i normalize this data (remove some critical NULL rows), so i can work with it.

So final dataset has **249 139** rows, and each object have own unique ID.
## Features

What im gonna add soon:

- Cache with Redis (Mostly searched books by ID or idk...);
- Create Docker image of this project;
- Add/Edit/Delete Book feature;
