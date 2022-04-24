ALTER TABLE shopping_cart.category
    ADD COLUMN created_date TIMESTAMP NOT NULL;

ALTER TABLE shopping_cart.category
    ADD COLUMN last_modified_date TIMESTAMP NOT NULL;