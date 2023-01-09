
CREATE DATABASE IF NOT EXISTS games_for_sale_db;






CREATE TABLE users (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       username VARCHAR(50) NOT NULL,
                       email  VARCHAR(50) NOT NULL,
                       password VARCHAR(50) NOT NULL,
                       PRIMARY KEY (id)
);



CREATE TABLE  games(
                       game_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       user_id INT UNSIGNED NOT NULL,
                       game_console VARCHAR(240) NOT NULL,
                       title VARCHAR(240) NOT NULL,
                       sale_trade VARCHAR(240) NOT NULL,
                       price VARCHAR(240) NOT NULL,
                       genre VARCHAR(240) NOT NULL,
                       description TEXT NOT NULL,
                       PRIMARY KEY (game_id),
                       FOREIGN KEY (user_id) REFERENCES users(id)
                           ON DELETE CASCADE
);

