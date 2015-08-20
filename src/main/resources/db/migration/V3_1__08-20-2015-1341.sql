SET FOREIGN_KEY_CHECKS=0;

RENAME TABLE `users` TO `authors`;
RENAME TABLE `users_salts` TO `authors_salts`;
RENAME TABLE `comments_users_guests` TO `comments_authors_guests`;

ALTER TABLE `authors_salts` CHANGE `user_id` `author_id` MEDIUMINT NOT NULL;
ALTER TABLE `comments_authors_guests` CHANGE `user_id` `author_id` MEDIUMINT NOT NULL;
ALTER TABLE `posts` CHANGE `user_id` `author_id` MEDIUMINT NOT NULL;

SET FOREIGN_KEY_CHECKS=1;