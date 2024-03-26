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

INSERT INTO `fwrp`.`posts`
(`title`,
 `content`,
 `category`,
 `image_path`,
 `author`,
 `date`)
VALUES
    ("Secrets of the Autumn Garden",
     "Autumn is a time of blooming in the garden, and today I want to share some tips on caring for your chrysanthemums and deciduous trees. First, ensure regular watering, and second, don't forget to prune the dead leaves to keep your garden vibrant and beautiful.",
     "Gardening Enthusiasts",
     "views/forum/images/post01.jpg",
     "Emily Johnson",
     "2023-11-22");

INSERT INTO `fwrp`.`posts`
(`title`,
 `content`,
 `category`,
 `image_path`,
 `author`,
 `date`)
VALUES
    ("Quick and Easy Breakfast Recipes",
     "Busy mornings call for quick and delicious breakfasts. Today, I'm introducing a simple omelet recipe: just a few eggs, some vegetables, and your favorite spices, and in five minutes, a nutritious breakfast is ready to serve.",
     'Culinary Corner',
     "views/forum/images/post02.jpg",
     "Sarah Williams",
     "2023-11-22");

INSERT INTO `fwrp`.`posts`
(`title`,
 `content`,
 `category`,
 `image_path`,
 `author`,
 `date`)
VALUES
    ("The Future of AI: A Tech Frontier",
     "Artificial Intelligence is evolving rapidly, transforming our lives and work. From autonomous vehicles to smart home systems, AI is opening up a new world for us. In this article, I will discuss the latest trends in AI and how it's shaping our future society.",
     'Tech Trends',
     "views/forum/images/post03.jpg",
     "Michael Smith",
     "2023-11-22");

INSERT INTO `fwrp`.`posts`
(`title`,
 `content`,
 `category`,
 `image_path`,
 `author`,
 `date`)
VALUES
    ("The Enchanting Allure of Hiking in the Mountains",
     "Hiking is more than just a physical activity; it's a way to explore nature, challenge oneself, and find inner peace. In this article, I'll share some of my wonderful experiences and practical tips from mountain hiking, hoping to inspire more people to fall in love with this activity.",
     'Outdoor Adventures',
     "views/forum/images/post04.jpg",
     "David Brown",
     "2023-11-22");
