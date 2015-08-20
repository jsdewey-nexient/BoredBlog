CREATE DATABASE IF NOT EXISTS `boredblog`;
USE `boredblog`;

-- Create primary tables.
CREATE TABLE IF NOT EXISTS `users` (
  `id`  MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `screenname` VARCHAR(255) NOT NULL,
  `password` VARCHAR(60) NOT NULL, -- Hashed using bcrypt.
  `created_at` DATETIME NOT NULL DEFAULT current_timestamp,
  `updated_at` DATETIME DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `guests` (
  `id` MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `screenname` VARCHAR(255) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS `salts` (
  `id` MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `salt` CHAR(36) NOT NULL
);

CREATE TABLE IF NOT EXISTS `posts` (
  `id` MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `title` VARCHAR(255) NOT NULL,
  `content` TEXT NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT current_timestamp,
  `updated_at` DATETIME DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `comments` (
  `id` MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `content` TEXT NOT NULL
);


-- Create join tables.
CREATE TABLE IF NOT EXISTS `users_salts` (
  `user_id` MEDIUMINT NOT NULL,
  `salt_id` MEDIUMINT NOT NULL,
  CONSTRAINT UNIQUE (`user_id`, `salt_id`),
  FOREIGN KEY (`user_id`) REFERENCES `users`(`id`),
  FOREIGN KEY (`salt_id`) REFERENCES `salts`(`id`)
);

CREATE TABLE IF NOT EXISTS `users_posts` (
  `user_id` MEDIUMINT NOT NULL,
  `post_id` MEDIUMINT NOT NULL,
  CONSTRAINT UNIQUE (`user_id`, `post_id`),
  FOREIGN KEY (`user_id`) REFERENCES `users`(`id`),
  FOREIGN KEY (`post_id`) REFERENCES `posts`(`id`)
);

CREATE TABLE IF NOT EXISTS `comments_users_guests` (
  `comment_id` MEDIUMINT NOT NULL,
  `user_id` MEDIUMINT,
  `guest_id` MEDIUMINT,
  CONSTRAINT UNIQUE (`comment_id`, `user_id`, `guest_id`),
  CONSTRAINT CHECK (`user_id` IS NOT NULL OR `guest_id` IS NOT NULL),
  FOREIGN KEY (`user_id`) REFERENCES `users`(`id`),
  FOREIGN KEY (`guest_id`) REFERENCES `guests`(`id`)
);