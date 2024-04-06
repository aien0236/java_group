USE`fwrp`;

DROP TABLE IF EXISTS `FWRP`.`comments` ;
DROP TABLE IF EXISTS `FWRP`.`posts` ;

CREATE TABLE `posts` (
                              `id` int(11) NOT NULL AUTO_INCREMENT,
                              `title` varchar(100) DEFAULT NULL,
                              `content` longtext DEFAULT NULL,
                              `category` varchar(50) DEFAULT NULL,
                              `image_path` varchar(100) DEFAULT NULL,
                              `author` varchar(50) DEFAULT NULL,
                              `date` datetime DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `comments` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `comment` varchar(100) DEFAULT NULL,
                           `author` varchar(30) DEFAULT NULL,
                           `post_id` int(11) NOT NULL,
                           PRIMARY KEY (`id`),
                           KEY `post_id` (`post_id`),
                           CONSTRAINT `post_id` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

# Data
INSERT INTO `fwrp`.`posts`
(`title`,
 `content`,
 `category`,
 `image_path`,
 `author`,
 `date`)
VALUES
    ("Feast Your Eyes on Savings! Delicious Deals Await!",
     "Dive into our special weekend sale and savor the flavors of savings! With up to 50% off on a wide selection of fresh fruits, baked delights, and savory dishes, it’s the perfect time to stock up on your favorites. Visit us now and don’t miss out on these irresistible offers. Limited time only!",
     "Grocery & Market Deals",
     "views/forum/images/post05.jpg",
     "Emily Johnson",
     "2024-03-26");