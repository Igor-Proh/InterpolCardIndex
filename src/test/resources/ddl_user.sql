Drop TABLE IF EXISTS user_entity_role cascade ;
Drop TABLE IF EXISTS role cascade ;
Drop TABLE IF EXISTS user_entity cascade ;
CREATE TABLE user_entity (
                             id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                             email VARCHAR(255) NOT NULL,
                             enabled BIT,
                             password VARCHAR(255),
                             username VARCHAR(255)
);
