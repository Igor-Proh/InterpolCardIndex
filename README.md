# Interpol's card index

Solution to the final task of the Java Basic Course June 2023 GFL

Interpol's card index
Data about each registered criminal: surname, name, nickname, height, hair and eye color, special features, citizenship, place and date of birth, last place of residence, language skills, criminal profession, last case, etc.
- Criminal and mafia groups (data on accomplices).
- Sampling by any criteria or even by a subset of criteria.
- Transfer of those "tied" to the archive; deletion only after death.

# To run the app 

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

