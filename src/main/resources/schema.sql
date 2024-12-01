DROP TABLE IF EXISTS place;
DROP TABLE IF EXISTS category;



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
    coordinates GEOMETRY       NOT NULL SRID 4326,
    user_id     VARCHAR(255)          NOT NULL,
    deleted    BOOLEAN               NOT NULL DEFAULT FALSE,
    FOREIGN KEY (category_id) REFERENCES category (id)
);

