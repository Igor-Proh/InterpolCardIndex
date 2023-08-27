drop database if exists finaltask;
create database finaltask;
use finaltask;

CREATE TABLE criminal_group (
                                criminal_group_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                criminal_group_group_name VARCHAR(255),
                                criminal_group_leader_name VARCHAR(255),
                                criminal_group_activities VARCHAR(1000),
                                criminal_group_is_mafia TINYINT(1),
                                UNIQUE (criminal_group_group_name)
);

CREATE TABLE criminal (
                          criminal_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          criminal_first_name VARCHAR(255),
                          criminal_last_name VARCHAR(255),
                          criminal_nickname VARCHAR(255),
                          criminal_height DOUBLE,
                          criminal_hair_color VARCHAR(255),
                          criminal_eye_color VARCHAR(255),
                          criminal_distinguishing_features VARCHAR(1000),
                          criminal_nationality VARCHAR(255),
                          criminal_birth_date DATE,
                          criminal_last_known_address VARCHAR(1000),
                          criminal_languages VARCHAR(1000),
                          criminal_criminal_profession VARCHAR(255),
                          criminal_last_crime_details VARCHAR(1000),
                          criminal_is_archived TINYINT(1),
                          criminal_is_dead TINYINT(1),
                          criminal_group_id BIGINT,
                          FOREIGN KEY (criminal_group_id) REFERENCES criminal_group(criminal_group_id)
);

INSERT INTO criminal_group (criminal_group_id, criminal_group_group_name, criminal_group_leader_name, criminal_group_activities, criminal_group_is_mafia)
VALUES
    (1, 'Red Scorpions', 'John', 'Drug trafficking, extortion', 1),
    (2, 'Black Widows', 'Lisa', 'Assassination, smuggling', 1),
    (3, 'Shadow Syndicate', 'Michael', 'Cybercrime, hacking', 1),
    (4, 'Night Serpents', 'David', 'Robbery, burglary', 0),
    (5, 'Silent Wolves', 'Anna', 'Espionage, information theft', 0);

INSERT INTO criminal (criminal_id, criminal_first_name, criminal_last_name, criminal_nickname, criminal_height, criminal_hair_color, criminal_eye_color, criminal_distinguishing_features, criminal_nationality, criminal_birth_date, criminal_last_known_address, criminal_languages, criminal_criminal_profession, criminal_last_crime_details, criminal_is_dead, criminal_is_archived, criminal_group_id)
VALUES
    (1, 'John', 'Smith', 'Scarface', 180.5, 'Black', 'Blue', 'Tattoo on left arm', 'American', '1985-05-10', '123 Main St, City', 'English, Spanish', 'Gangster', 'Bank robbery',1 , 1, 1),
    (2, 'Mary', 'Johnson', 'Snake', 160.0, 'Red', 'Green', 'Piercing on eyebrow', 'British', '1990-08-20', '456 Elm St, Town', 'English, French', 'Hacker', 'Cybercrime',0, 1, 1),
    (3, 'Michael', 'Brown', 'Big Mike', 190.2, 'Bald', 'Brown', 'Scar on right cheek', 'Canadian', '1982-03-15', '789 Oak Rd, Village', 'English, Italian', 'Enforcer', 'Assault',0, 0, 2),
    (4, 'Lisa', 'Williams', 'Venom', 170.0, 'Black', 'Blue', 'Tattoo on neck', 'American', '1995-11-02', '101 Pine Ave, City', 'English, Spanish', 'Assassin', 'Contract killing',0, 0, 4),
    (5, 'David', 'Jones', 'Ghost', 175.8, 'Brown', 'Hazel', 'Burn scar on forearm', 'Australian', '1988-06-25', '234 Maple Dr, Suburb', 'English, German', 'Con artist', 'Fraud',0, 0, 5),
    (6, 'Anna', 'Martinez', 'Viper', 165.5, 'Blonde', 'Blue', 'Tattoo on back', 'Mexican', '1993-09-17', '567 Oak Rd, Town', 'Spanish, English', 'Drug dealer', 'Narcotics trafficking',0, 0, 3),
    (7, 'James', 'Taylor', 'Joker', 180.0, 'Green', 'Brown', 'Smile tattoo on hand', 'American', '1987-02-08', '345 Pine Ave, City', 'English, French', 'Prankster', 'Public disturbance',0, 0, null),
    (8, 'Emily', 'Anderson', 'Shadow', 155.6, 'Black', 'Brown', 'Mole on left cheek', 'Canadian', '1991-07-14', '678 Elm St, Village', 'English, Spanish', 'Burglar', 'Theft',0, 0, 2),
    (9, 'Daniel', 'Thomas', 'Reaper', 192.0, 'Bald', 'Blue', 'Scythe tattoo on forearm', 'British', '1980-12-30', '890 Oak Rd, City', 'English, French', 'Hitman', 'Targeted killings',0, 0, 2),
    (10, 'Olivia', 'Jackson', 'Siren', 170.2, 'Red', 'Green', 'Birthmark on neck', 'American', '1989-04-05', '111 Maple Dr, Town', 'English, Spanish', 'Smuggler', 'Contraband trafficking',0, 0, null),
    (11, 'Liam', 'White', 'Falcon', 178.9, 'Blonde', 'Blue', 'Tattoo on chest', 'Australian', '1994-10-18', '222 Pine Ave, Suburb', 'English, German', 'Robber', 'Bank heist',0, 0, 3),
    (12, 'Sophia', 'Harris', 'Banshee', 160.7, 'Brown', 'Brown', 'Scar across left eyebrow', 'Irish', '1997-01-28', '333 Elm St, City', 'English, French', 'Extortionist', 'Threats and coercion',0, 0, 4),
    (13, 'Ethan', 'Martin', 'Vortex', 183.4, 'Black', 'Green', 'Piercing on lip', 'American', '1984-08-09', '444 Oak Rd, Village', 'English, Spanish', 'Drug lord', 'Organized crime',0, 0 ,5),
    (14, 'Ava', 'Thompson', 'Raven', 165.0, 'Red', 'Blue', 'Tattoo on wrist', 'Canadian', '1998-03-21', '555 Maple Dr, City', 'English, French', 'Kidnapper', 'Ransom',0, 0, 4),
    (15, 'Noah', 'Garcia', 'Phantom', 175.2, 'Brown', 'Brown', 'Scar on chin', 'Mexican', '1983-11-11', '666 Elm St, Town', 'Spanish, English', 'Drug trafficker', 'Narcotics distribution',0, 0 ,5);

CREATE TABLE role (
                      id BIGINT NOT NULL PRIMARY KEY,
                      role VARCHAR(255) UNIQUE
);

CREATE TABLE user_entity (
                             id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                             email VARCHAR(255) NOT NULL,
                             enabled BIT,
                             password VARCHAR(255),
                             username VARCHAR(255)
);

CREATE TABLE user_entity_roles (
                                   user_id BIGINT NOT NULL,
                                   role_id BIGINT NOT NULL,
                                   PRIMARY KEY (user_id, role_id),
                                   CONSTRAINT FK_user_roles_user FOREIGN KEY (user_id) REFERENCES user_entity (id),
                                   CONSTRAINT FK_user_roles_role FOREIGN KEY (role_id) REFERENCES role (id)
);

INSERT INTO role (id, role) VALUES (1, 'USER');
INSERT INTO role (id, role) VALUES (2, 'ADMIN');

INSERT INTO user_entity (id, email, enabled, password, username) VALUES (1, 'user@example.com', 1, '$2a$12$kL/La5twIZtZcV1yurgpR.vqANn9HAVYuYWu36mTqKofn72PQi4XW', 'user');
INSERT INTO user_entity (id, email, enabled, password, username) VALUES (2, 'admin@example.com', 1, '$2a$12$A.xG.K6.6Ee6eoNS6MS.Buwf9R7uvQZNqSEXQE8yddReIpXuhjEmK', 'admin');

INSERT INTO user_entity_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_entity_roles (user_id, role_id) VALUES (2, 2);

