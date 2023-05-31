DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS _user;

CREATE TABLE _user
(
    id INT,
    CONSTRAINT pk_user_id PRIMARY KEY (id)
);
CREATE TABLE reservation
(
    id      INT,
    user_id INT NOT NULL,
    info    VARCHAR,
    CONSTRAINT fk_user_id
        FOREIGN KEY (user_id)
            REFERENCES _user (id)
);
