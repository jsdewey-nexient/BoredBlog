ALTER TABLE `comments_authors_guests` MODIFY `author_id` MEDIUMINT DEFAULT NULL;
ALTER TABLE `comments_authors_guests` MODIFY `guest_id` MEDIUMINT DEFAULT NULL;

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

INSERT INTO `guests` (
    `screen_name`
) VALUES (
    'nexient'
), (
    'caithe2'
);

INSERT INTO `posts` (
    `author_id`,
    `title`,
    `content`
) VALUES (
    1,
    'Nullam aliquam odio quis elementum.',
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus placerat ante ut dapibus elementum. Cras auctor volutpat leo eu eleifend. Cras mattis nulla vitae quam pulvinar, ac lacinia metus condimentum. Fusce in quam elementum, cursus libero sit amet, vestibulum risus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus et sodales augue. Morbi dictum accumsan consequat. Mauris volutpat posuere felis a gravida.

Sed vel lectus commodo, rhoncus eros vel, finibus diam. Vestibulum feugiat metus vitae nunc mollis elementum. Praesent in turpis mauris. Pellentesque mattis dictum nibh, in hendrerit nibh rhoncus non. Donec volutpat consectetur orci non pulvinar. Duis laoreet mauris vitae tortor rhoncus suscipit. Phasellus sodales lacus vel est sollicitudin ullamcorper. Donec vel odio orci. Donec finibus neque in nisl aliquet congue. Mauris rhoncus, sapien et iaculis pellentesque, risus tortor gravida lorem, a lacinia sapien ligula id mi. Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut dignissim tempor leo. Donec turpis quam, interdum ut odio auctor, venenatis tempus mauris. Proin molestie, massa sed tincidunt accumsan, odio diam maximus urna, sed condimentum leo arcu ac ligula. Duis eget felis purus.

Nam vehicula suscipit mi, et fermentum mi tincidunt sed. Nullam in mi vitae augue egestas fringilla. Sed ac ipsum non ligula pretium sagittis sit amet sed lorem. Nullam hendrerit tellus eu nibh ultrices lobortis. Vestibulum dapibus, diam sit amet semper vulputate, lectus ligula tempor nisl, id ultrices sapien arcu sit amet tortor. Maecenas sit amet tortor turpis. Nulla fermentum egestas egestas. Integer enim ex, gravida placerat erat a, sagittis sagittis neque. Maecenas libero mauris, molestie sit amet mattis nec, faucibus eget dolor.

Mauris at tincidunt erat, quis convallis libero. Duis eget blandit urna, sed dignissim risus. Sed laoreet ultricies lacus, sed mollis elit commodo ac. Aliquam erat volutpat. Nunc blandit auctor sem, in congue metus scelerisque sit amet. Duis erat nisl, rutrum non eros eget, mollis faucibus nisl. Vivamus molestie posuere erat eget mollis. Sed hendrerit nulla vel elit mollis imperdiet. Cras lobortis, velit et suscipit suscipit, augue augue scelerisque odio, vitae pretium sem metus vel nunc. Nulla at condimentum mi, vitae pharetra lacus. In et ligula id justo laoreet scelerisque vel pellentesque felis. Quisque ut imperdiet sapien. Sed ut accumsan diam, in iaculis nunc. Duis eu feugiat velit, sed ullamcorper ipsum. Sed in sem tortor. Vivamus nunc urna, ornare sed dui et, luctus mollis orci.

Mauris ipsum lorem, iaculis at iaculis id, euismod sed felis. Pellentesque in mauris gravida, euismod lorem ut, mattis lectus. Nulla facilisi. Nunc pretium ac arcu eget hendrerit. Praesent eget nibh nec dui euismod malesuada. Donec dignissim elit non mi ullamcorper tristique. In nec ex at massa vehicula tincidunt sit amet quis arcu. Integer non bibendum lacus, sit amet lobortis augue. Ut lacinia nulla sit amet ullamcorper fringilla. Donec et mi aliquet, dictum dolor nec, congue ex.'
), (
    1,
    'Nisi kielbasa in, fugiat tenderloin venison non.',
    'Bacon ipsum dolor amet tail capicola sausage, pork chuck cow bacon turkey tri-tip hamburger sirloin. Pork belly sirloin filet mignon ribeye. Spare ribs alcatra pork, landjaeger tri-tip cow beef ribs ball tip kielbasa swine kevin boudin bresaola beef shankle. Prosciutto t-bone flank, tri-tip ribeye jerky beef ribs beef corned beef tongue salami fatback alcatra venison. Jowl bacon tongue tenderloin, cupim ribeye salami doner sausage. Tail jerky chuck capicola brisket pork loin spare ribs swine cow porchetta alcatra. Ham chicken strip steak, turkey picanha turducken shank tongue tri-tip cow prosciutto.

Prosciutto alcatra pork loin ham hock porchetta. Chicken t-bone beef ribs, pork jerky prosciutto rump pork belly cupim drumstick picanha short loin. Tri-tip sausage shankle boudin ball tip. Cupim venison boudin leberkas flank, kielbasa filet mignon.

Shankle jerky boudin kielbasa t-bone. Tenderloin leberkas bresaola corned beef rump sausage swine porchetta andouille sirloin. Salami tongue kevin shankle, ground round leberkas strip steak alcatra meatloaf capicola pastrami short loin. Sausage ham hock filet mignon, ham tri-tip pork belly ball tip salami venison meatloaf drumstick. Turkey strip steak ball tip jerky beef shoulder porchetta leberkas bresaola cow pastrami kielbasa. Prosciutto alcatra filet mignon tongue frankfurter brisket ball tip kielbasa fatback kevin capicola chicken pastrami biltong. Swine jerky ribeye frankfurter capicola spare ribs porchetta kielbasa pork belly beef ribs pork chop ball tip tenderloin chicken.

Jerky leberkas drumstick shoulder pancetta ribeye, turkey salami bacon flank corned beef beef kielbasa pork landjaeger. Corned beef prosciutto ham bresaola biltong ball tip pork, drumstick turducken flank meatloaf fatback picanha tongue andouille. Shank leberkas ham swine bresaola porchetta. Biltong cow kevin meatball ball tip drumstick hamburger leberkas tail. Short ribs drumstick boudin, shoulder pancetta tongue turducken andouille swine meatloaf pastrami tenderloin porchetta ham short loin. Leberkas sirloin flank ham hock corned beef drumstick pancetta meatball ribeye venison bacon shank.

Brisket jowl pig, short ribs cow leberkas tail kevin biltong. Capicola cow pancetta, bresaola fatback hamburger meatball swine shankle cupim sausage frankfurter. Tail salami pork loin, ham hock corned beef cupim swine porchetta chicken andouille t-bone pork chop. Spare ribs landjaeger kevin pork chop, beef meatloaf pork rump cupim. Meatball shoulder pork loin shankle kevin, ball tip ground round pig meatloaf.'
), (
    2,
    'One morning, when Gregor Samsa woke from troubled dreams, he found himself transformed in his bed into a horrible vermin.',
    'The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs vex! Fox nymphs grab quick-jived waltz. Brick quiz whangs jumpy veldt fox. Bright vixens jump; dozy fowl quack. Quick wafting zephyrs vex bold Jim. Quick zephyrs blow, vexing daft Jim. Sex-charged fop blew my junk TV quiz. How quickly daft jumping zebras vex. Two driven jocks help fax my big quiz. Quick, Baz, get my woven flax jodhpurs! "Now fax quiz Jack!" my brave ghost pled. Five quacking zephyrs jolt my wax bed. Flummoxed by job, kvetching W. zaps Iraq. Cozy sphinx waves quart jug of bad milk. A very bad quack might jinx zippy fowls. Few quips galvanized the mock jury box. Quick brown dogs jump over the lazy fox. The jay, pig, fox, zebra, and my wolves quack! Blowzy red vixens fight for a quick jump. Joaquin Phoenix was gazed by MTV for luck. A wizard’s job is to vex chumps quickly in fog. Watch "Jeopardy!", Alex Trebek''s fun TV quiz game. Woven silk pyjamas exchanged for blue quartz. '
);

INSERT INTO `comments` (
    `post_id`,
    `content`
) VALUES (
    1,
    'Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.'
), (
    1,
    'The European languages are members of the same family. Their separate existence is a myth. For science, music, sport, etc, Europe uses the same vocabulary.'
), (
    2,
    'The languages only differ in their grammar, their pronunciation and their most common words. Everyone realizes why a new common language would be desirable: one could refuse to pay expensive translators.'
), (
    1,
    'One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.'
), (
    2,
    'It showed a lady fitted out with a fur hat and fur boa who sat upright, raising a heavy fur muff that covered the whole of her lower arm towards the viewer. Gregor then turned to look out the window at the dull weather.'
);

INSERT INTO `comments_authors_guests` (
    `comment_id`,
    `author_id`,
    `guest_id`
) VALUES (
    1,
    2,
    NULL
), (
    2,
    1,
    NULL
), (
    3,
    NULL,
    1
), (
    4,
    NULL,
    2
), (
    5,
    NULL,
    2
);