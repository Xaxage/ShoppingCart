CREATE TABLE user
(
    id                 BIGINT    NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name         VARCHAR(255),
    last_name          VARCHAR(255),
    email              VARCHAR(255) UNIQUE,
    password           VARCHAR(255),
    date_of_birth      DATE,
    created_date       TIMESTAMP NOT NULL,
    last_modified_date TIMESTAMP NOT NULL

) ENGINE = InnoDB;

CREATE TABLE token
(
    id                 BIGINT    NOT NULL AUTO_INCREMENT PRIMARY KEY,
    token              VARCHAR(255),
    user_id            BIGINT,
    created_date       TIMESTAMP NOT NULL,
    last_modified_date TIMESTAMP NOT NULL,
    CONSTRAINT user_token_pk FOREIGN KEY (user_id) REFERENCES user (id)

) ENGINE = InnoDB;

