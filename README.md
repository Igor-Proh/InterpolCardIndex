# Interpol's card index

Solution to the final task of the Java Basic Course June 2023 GFL

Interpol's card index
Data about each registered criminal: surname, name, nickname, height, hair and eye color, special features, citizenship, place and date of birth, last place of residence, language skills, criminal profession, last case, etc.
- Criminal and mafia groups (data on accomplices).
- Sampling by any criteria or even by a subset of criteria.
- Transfer of those "tied" to the archive; deletion only after death.

# Used technologies

Spring Boot -  simplifies the process of building production-ready Spring-based applications.

Spring MVC - Model-View-Controller

Spring Data - interact with databases.

Spring Security - authentication and access control framework for Spring applications.

H2 Database -  in-memory database that I use for testing.

Thymeleaf - Java templates for creating html pages

Thymeleaf Extras Spring Security - Integrates Spring Security with Thymeleaf templates.

Lombok - to simplifies java code by providing annotations

MySQL - database to store data from application

Log4j - logging framework for Java.

ModelMapper - mapping Java objects between different classes, similar to DTOs

Database Rider - testing database interactions

JUnit - writing and running unit tests in Java.

Spring Boot Starter Test - testing dependencies provided by Spring Boot for writing tests.

# To run Application

You will need to:
1. create a database in MySQL using the initDb.sql script (located in the root of the project).
2. enter your data such as URL, USERNAME, PASSWORD in application.properties (location: src/main/resources/)
3. launch the application using the InterpolCardIndexApplication.java class (location: com/prokhnov/interpolCardIndex/).

4. go to http://localhost:8080/ in the browser.

The application uses Spring Security and you need to use one of the following login and password to log in with permissions:

    Username - user, Password - user (read only).
  
    Username - admin, Password - admin (full rights).

USER - read-only rights. Can view tables

ADMIN - full rights. Can delete, add, modify data in tables presented in the project.

# Project overview

Home Page 
![image](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/61d778ef-e1ef-4aa5-be3a-ab2fa8851387)
On this page, we can log in or create a new user, which is mandatory because an unauthenticated user will not be allowed to enter the lists of criminals and criminal groups.

What we see if log in like User:
![image](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/204abab4-0c3f-4445-8890-50492a7e972b)

What we see if log in like Admin:
![image](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/295d4034-e7fb-4831-82a8-006f1502d4af)

List of Criminals Page look like (for Admin):

![image](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/a1c93e49-3b3e-4b27-85db-e4ea4e696bf8)

For admins, we can create new criminal, update criminals and delete if Criminal dead. 

For users, we can only see information about Criminals and have access for Archived criminals.

Also in lists page we have search field that filter data including all fields.

List of Criminal Groups look like (for Admin):

![image](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/aa9f036a-5942-4071-b056-92f21383f424)

For admins, we can create new criminal group, update criminal group and delete. 

For users, we can only see information about Criminal group.

Also in lists page we have search field that filter data including all fields.

In page Criminal Group Details that look like(for Admin):
![image](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/3b5dc350-380e-4a3d-bcc5-aac96b79e45a)

For admins, we can add new members to group or delete from current. 

For users, we can only see information about Criminal group.

Page List of Users look like (for Admin):
![image](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/565bd8c7-031e-40cb-9bba-5c46aba812b1)

There we can add new user, update or delete current. This list open only for Admin.

User cant see it.

And when we logged out we see this page:
![image](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/94eaeeed-583e-45b5-8449-2d24c640dc5f)



