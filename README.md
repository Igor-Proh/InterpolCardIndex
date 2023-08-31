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
![home page](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/0632024b-1435-43e8-9ade-fb0e206f48f6)

On this page, we can log in or create a new user, which is mandatory because an unauthenticated user will not be allowed to enter the lists of criminals and criminal groups.

If you want to register. You can do it on Sign Up page. This page use google reCaptcha and look like:

![registration page](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/6e152fdb-0410-47b4-ba23-305b777bb49b)

What we see if log in like User:
![user home page](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/f8156464-33a6-4cd5-8306-247a47f405dd)

What we see if log in like Admin:
![admin home page](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/73e2c5a0-ab76-4573-b415-7df6590fb03d)

List of Criminals Page look like (for Admin):
![admin list criminals](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/711a6826-f9e5-4c05-8f50-c8b6979bc64a)

For admins, we can create new criminal, update criminals and delete if Criminal dead. 

For users, we can only see information about Criminals and have access for Archived criminals.

Also in lists page we have search field that filter data including all fields.

List of Criminal Groups look like (for Admin):

![admin criminal group list](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/f10a3f08-3aa1-462f-9659-2de6ca17d27a)

For admins, we can create new criminal group, update criminal group and delete. 

For users, we can only see information about Criminal group.

Also in lists page we have search field that filter data including all fields.

In page Criminal Group Details that look like(for Admin):
![criminal group info](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/2b0542a0-5f6c-412f-887c-7e40a9043380)


For admins, we can add new members to group or delete from current. 

For users, we can only see information about Criminal group.

Page List of Users look like (for Admin):
![userlist](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/542e5bc1-55d6-4cea-8720-cca6c35d017e)


There we can add new user, update or delete current. Admin cant delete himself. This list open only for Admin.

User cant see it.

And when we logged out we see this page:
![image](https://github.com/Igor-Proh/InterpolCardIndex/assets/71402291/94eaeeed-583e-45b5-8449-2d24c640dc5f)



