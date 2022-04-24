CREATE TABLE cart
(
    id                 BIGINT    NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_id         BIGINT,
    user_id            BIGINT,
    category_id        BIGINT,
    quantity           BIGINT CHECK ( quantity >= 0 ),
    created_date       TIMESTAMP NOT NULL,
    last_modified_date TIMESTAMP NOT NULL,
    constraint product_pk foreign key (product_id) references product (id),
    constraint user_cart_pk foreign key (user_id) references user (id)

) ENGINE = InnoDB;
