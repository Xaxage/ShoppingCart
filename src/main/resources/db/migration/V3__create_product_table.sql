CREATE TABLE product
(
    id                 BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_name       VARCHAR(255),
    description        VARCHAR(255),
    price              DOUBLE,
    category_id        BIGINT,
    count_in_stock     BIGINT CHECK ( count_in_stock >= 0 ),
    created_date       TIMESTAMP NOT NULL ,
    last_modified_date TIMESTAMP NOT NULL ,
    CONSTRAINT category_pk FOREIGN KEY (category_id) REFERENCES category (id)

) ENGINE = InnoDB;