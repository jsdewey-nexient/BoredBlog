SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE IF NOT EXISTS `users` (
  `id` MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `author_id` MEDIUMINT DEFAULT NULL,
  `guest_id` MEDIUMINT DEFAULT NULL,
  CONSTRAINT CHECK (`author_id` IS NOT NULL OR `guest_id` IS NOT NULL),
  FOREIGN KEY (`author_id`) REFERENCES `authors`(`id`),
  FOREIGN KEY (`guest_id`) REFERENCES `guests`(`id`)
);

ALTER TABLE `comments` ADD `user_id` MEDIUMINT AFTER `post_id`;

INSERT INTO `users` (`author_id`, `guest_id`)
  SELECT `author_id`, `guest_id` FROM `comments_authors_guests`;

UPDATE `comments`
  LEFT JOIN `users`
    ON `users`.`id` = `comments`.`id`
SET `comments`.`user_id` = `users`.`id`;

ALTER TABLE `comments` MODIFY `user_id` MEDIUMINT,
  ADD CONSTRAINT FOREIGN KEY(`user_id`) REFERENCES `users`(`id`);

DROP TABLE `comments_authors_guests`;

SET FOREIGN_KEY_CHECKS=1;