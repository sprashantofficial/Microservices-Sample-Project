CREATE TABLE `movie` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `year` int NOT NULL,
  `genre_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
)
