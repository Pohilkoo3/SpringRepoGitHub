DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

CREATE TABLE authors (id INT AUTO_INCREMENT,
                      first_name varchar(255),
                      last_name varchar(255),
                      PRIMARY KEY (id));

CREATE TABLE books
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    author    VARCHAR(250) NOT NULL,
    title     VARCHAR(250) NOT NULL,
    priceOld  VARCHAR(250) DEFAULT NULL,
    price     VARCHAR(250) DEFAULT NULL,
    authorId INT
);
