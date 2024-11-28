DROP TABLE IF EXISTS place;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS `user`;


CREATE TABLE IF NOT EXISTS `user`
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     ENUM ('USER', 'ADMIN') DEFAULT 'USER'
);

CREATE TABLE IF NOT EXISTS category
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255)                       NOT NULL,
    symbol      VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL,
    description VARCHAR(255)                       NOT NULL
) CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS place
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    category_id INT          NOT NULL,
    is_private  BOOLEAN      NOT NULL DEFAULT FALSE,
    created_at  TIMESTAMP             DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at  TIMESTAMP             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    coordinates POINT        NOT NULL,
    user_id     INT          NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category (id),
    FOREIGN KEY (user_id) REFERENCES `user` (id)
);

