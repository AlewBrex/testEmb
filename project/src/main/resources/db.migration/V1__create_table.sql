DROP TABLE IF EXISTS `cars`;
CREATE TABLE IF NOT EXISTS `cars` (
  `id` int NOT NULL AUTO_INCREMENT,
  `car_plate` varchar(11) NOT NULL,
  `VIN` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `vehicle_category` varchar(255) NOT NULL,
  `brand` varchar(255) NOT NULL,
  `color` varchar(255) NOT NULL,
  `chassis` varchar(255) NOT NULL,
  `year` integer NOT NULL,
  `horse_power` varchar(255) NOT NULL,
  `ecological_class` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `statistics`;
CREATE TABLE IF NOT EXISTS `statistics` (
  `id` int NOT NULL AUTO_INCREMENT,
  `count_car` integer NOT NULL,
  `first_add` datetime NOT NULL,
  `second_add` datetime NOT NULL,
  PRIMARY KEY (`id`)
  KEY `count_car` (`count_car_id`),
  CONSTRAINT `count_car` FOREIGN KEY (`count_car_id`) REFERENCES `car` (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TRIGGER IF NOT EXISTS fk_first_add
   AFTER INSERT ON cars
   BEGIN
   INSERT INTO statistics (count_car, first_add)
   VALUES (new.id, datetime('now','localtime'));
   END;