drop table IF EXISTS `cars`;
create TABLE IF NOT EXISTS `cars` (
  `id` int NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL,
  `car_plate` varchar(255) NOT NULL,
  `VIN` varchar(255) NOT NULL,
  `model_car` varchar(255) NOT NULL,
  `type_car` varchar(255) NOT NULL,
  `vehicle_category` varchar(255) NOT NULL,
  `brand` varchar(255) NOT NULL,
  `color` varchar(255) NOT NULL,
  `chassis` varchar(255) NOT NULL,
  `year_car` int NOT NULL,
  `horse_power` int NOT NULL,
  `ecological_class` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;