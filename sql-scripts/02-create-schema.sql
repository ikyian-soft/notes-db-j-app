USE `notes_db`;
DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `notes`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `authority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnotesDbUniqueUsername` (`username`),
  CONSTRAINT `FKnotesDbUniqueUsername` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- DROP TABLE IF EXISTS `notes`;
CREATE TABLE `notes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnotesDBNoteUsername` (`username`),
  CONSTRAINT `FKnotesDBNoteUsername` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `users`
VALUES
('user1','$2a$12$6krHvX0ywtdzAI6QC3LcAuvizHh84TXyNBVOA0W4wyzZiRCDQSjXO',1),
('user2','$2a$12$UbCTOxhs3f/gkUW0p5XqS.yhaIUbYeSO7/BWeke.dEECrV04X8P46',1);

INSERT INTO `authorities`
VALUES
(1,'user1','user'),
(2,'user2','user');

INSERT INTO `notes`
VALUES
(1,'user1','note-1','content of note 1'),
(2,'user1','note-2','content of note 2');
