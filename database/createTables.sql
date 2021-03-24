DROP DATABASE epamweb;

CREATE DATABASE IF NOT EXISTS epamweb;

USE epamweb;

CREATE TABLE IF NOT EXISTS menu
(
    id           INT AUTO_INCREMENT,
    name         VARCHAR(50) NOT NULL,
    price        VARCHAR(50) NOT NULL,
    photo        varchar(100) NOT NULL,
    is_active    tinyint default 1,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS bucket
(
    id             INT AUTO_INCREMENT,
    dish_id        INT NOT NULL,
    order_id       INT NOT NULL,
    count          INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (dish_id) REFERENCES menu (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id        INT AUTO_INCREMENT,
    login     VARCHAR(20) NOT NULL UNIQUE,
    password  VARCHAR(50) NOT NULL,
    name      VARCHAR(20) NOT NULL,
    points    VARCHAR(20) NOT NULL,
    cardnumber VARCHAR(20) NOT NULL,
    role      varchar(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS orders
(
    id          INT AUTO_INCREMENT,
    price       INT NOT NULL,
    type        varchar(45) NOT NULL,
    state      	varchar(45) NOT NULL,
    time       	datetime NOT NULL,
    user_id     INT  NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS rating
(
    id          INT AUTO_INCREMENT,
    order_id    INT NOT NULL,
    stars       INT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES orders (id)
);