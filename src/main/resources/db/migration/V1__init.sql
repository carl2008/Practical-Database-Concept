/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS ISYS3414_DB_Groups54;

CREATE DATABASE ISYS3414_DB_Groups54;

USE ISYS3414_DB_Groups54;

DROP TABLE IF EXISTS `booking`;
DROP TABLE IF EXISTS `categories`;
DROP TABLE IF EXISTS `movie`;
DROP TABLE IF EXISTS `timetable`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `booking` (
    `id` int NOT NULL AUTO_INCREMENT,
    `is_checked_in` tinyint(1) NOT NULL DEFAULT '0',
    `seats` int NOT NULL,
    `timetable_id` int NOT NULL,
    `user_id` int NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKcjjayx1872fri8h389m3l26td` (`timetable_id`),
    CONSTRAINT `FKcjjayx1872fri8h389m3l26td` FOREIGN KEY (`timetable_id`) REFERENCES `timetable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `categories` (
    `id` int NOT NULL AUTO_INCREMENT,
    `categories_description` text,
    `categories_name` varchar(100) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `movie` (
    `id` int NOT NULL AUTO_INCREMENT,
    `cast` varchar(255) NOT NULL,
    `category` varchar(255) NOT NULL,
    `description` text,
    `directors` varchar(255) NOT NULL,
    `duration` int NOT NULL DEFAULT 120,
    `language` varchar(255) NOT NULL,
    `movie_name` varchar(255) NOT NULL,
    `premiere` date NOT NULL,
    `rated` int NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `timetable` (
    `id` int NOT NULL AUTO_INCREMENT,
    `seat_available` int NOT NULL,
    `time_slot` int NOT NULL,
    `movie_id` int NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKjpcdoj1icflt8hoggq75vvq1w` (`movie_id`),
    CONSTRAINT `FKjpcdoj1icflt8hoggq75vvq1w` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `username` varchar(100) NOT NULL,
    `password` varchar(255) NOT NULL,
    `roles` varchar(50) NOT NULL DEFAULT 'ROLE_USER',
    `is_active` tinyint(1) NOT NULL DEFAULT '1',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `booking` (`id`, `is_checked_in`, `seats`, `timetable_id`, `user_id`) VALUES
('1', '0', '3', '1', '2');

INSERT INTO `movie` (`id`, `cast`, `category`, `description`, `directors`, `duration`, `language`, `movie_name`, `premiere`, `rated`) VALUES
('1', 'Ryu Seung-yong, Lee Hanee, Jin Sun-kyu, Lee Dong-hwi, Gong Myoung', 'Action, Comedy', 'A team of narcotics detectives goes undercover in a fried chicken joint to stake out an organized crime gang. But things take an unexpected turn when the detectives’ chicken recipe suddenly transforms the rundown restaurant into the hottest eatery in town.', 'Lee Byeong-heon', '111', 'Korean with Vietnamese subtitles', 'EXTREME JOB', '2020-12-11', '18');

INSERT INTO `timetable` (`id`, `seat_available`, `time_slot`, `movie_id`) VALUES
('1', '50', '2000', '1'),
('2', '100', '1800', '1');

INSERT INTO `user` (`id`, `username`, `password`, `roles`, `is_active`) VALUES
('1', 'user', '$2a$10$eYZ4G3LZgsZ2mupJc9KK/.38v1LMNHB263caHBpaoI2rnbG3AGsma', 'ROLE_USER', '1'),
('2', 'admin', '$2a$10$eYZ4G3LZgsZ2mupJc9KK/.38v1LMNHB263caHBpaoI2rnbG3AGsma', 'ROLE_ADMIN', '1');


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;