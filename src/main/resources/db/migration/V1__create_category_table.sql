DROP TABLE IF EXISTS category;

CREATE TABLE category
(
    id            BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    category_name VARCHAR(255),
    description   VARCHAR(255)

) ENGINE = InnoDB;