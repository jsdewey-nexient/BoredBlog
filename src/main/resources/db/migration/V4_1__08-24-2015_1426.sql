-- A comment next to a hash is the plain text representation of the password.
INSERT INTO `authors` (
    `first_name`,
    `last_name`,
    `screen_name`,
    `password`
) VALUES (
    'Thomas',
    'Trainengine',
    'bluetrain',
    '$2a$10$Nt9WgUzx6D2o/hDcxWFqFemxTMfUyA1wdfXQhn3wj0nbvdDC9Kley' -- wootwoot
), (
    'Joel',
    'Dewey',
    'jdewey',
    '$2a$10$ZMzsS3elA2P8sbIPnGq/DOxbrmU/Uk2XT0Bmw74rc8zs9Iw0IPA6u' -- password
);