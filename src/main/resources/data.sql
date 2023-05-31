DROP TABLE IF EXISTS reservations;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id INT,
    CONSTRAINT pk_users_id PRIMARY KEY (id)
);
CREATE TABLE reservations
(
    id      INT,
    user_id INT NOT NULL,
    info    VARCHAR,
    CONSTRAINT fk_users_id
        FOREIGN KEY (user_id)
            REFERENCES users (id)
);
