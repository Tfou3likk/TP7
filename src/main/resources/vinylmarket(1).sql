-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 02 jan. 2026 à 11:52
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `vinylmarket`
--
CREATE DATABASE IF NOT EXISTS `vinylmarket` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `vinylmarket`;

-- --------------------------------------------------------

--
-- Structure de la table `disk`
--

DROP TABLE IF EXISTS `disk`;
CREATE TABLE `disk` (
  `identification_code` varchar(255) NOT NULL,
  `album` text DEFAULT NULL,
  `artist` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `disk`
--

INSERT INTO `disk` (`identification_code`, `album`, `artist`) VALUES
('3.5.7-MUSIC', 'Insolent', 'RK'),
('GUAPO-RECORD', 'Street Quality II', 'F430'),
('HYPER-FOCAL-MUSIC', 'TOPBOY:Tome1', 'RK'),
('IGD-MUSIC', 'SOUROU', 'S-PION'),
('IGD-RECORDS', 'SOUROU 2', 'S-PION'),
('LABEL-BLUE-SKY', 'Vie d\'Enflure', 'D2L'),
('LDS-PRODUCTION', 'Réelle vie 2.0', 'Maes'),
('LES-RESCAPES', 'DLPDA', 'RK'),
('PNL-MUSICAST', 'QUE LA FAMILLE', 'PNL'),
('QLF-RECORD', 'Dans la légende', 'PNL'),
('TPLG-RECORDS', 'N\'DA', 'MMZ');

-- --------------------------------------------------------

--
-- Structure de la table `disk_to_sold`
--

DROP TABLE IF EXISTS `disk_to_sold`;
CREATE TABLE `disk_to_sold` (
  `identification_code` varchar(255) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `disk_to_sold`
--

INSERT INTO `disk_to_sold` (`identification_code`, `price`) VALUES
('HYPER-FOCAL-MUSIC', 14.99),
('IGD-MUSIC', 9.99),
('IGD-RECORDS', 9.99),
('LDS-PRODUCTION', 19.99),
('LES-RESCAPES', 19.99);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `email` varchar(255) NOT NULL,
  `firstname` text DEFAULT NULL,
  `lastname` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`email`, `firstname`, `lastname`) VALUES
('aaaa@aaa.com', 'aaaa', 'aaa'),
('fares@etu.fr', 'Farès', 'Denguiz'),
('Test2@spring2.com', 'Test2', 'Spring2'),
('Test@EJB', 'Test', 'EJB'),
('Test@spring.com', 'Test', 'Spring'),
('test@vinyl.com', 'Test', 'Vinyl');

-- --------------------------------------------------------

--
-- Structure de la table `vinyl_collection`
--

DROP TABLE IF EXISTS `vinyl_collection`;
CREATE TABLE `vinyl_collection` (
  `identification_code` varchar(255) NOT NULL,
  `user` varchar(255) NOT NULL,
  `acquisition_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `vinyl_collection`
--

INSERT INTO `vinyl_collection` (`identification_code`, `user`, `acquisition_date`) VALUES
('3.5.7-MUSIC', 'fares@etu.fr', '2026-01-01 02:00:05'),
('3.5.7-MUSIC', 'Test@spring.com', '2026-01-01 11:47:18'),
('GUAPO-RECORD', 'aaaa@aaa.com', '2026-01-01 02:00:05'),
('HYPER-FOCAL-MUSIC', 'fares@etu.fr', '2026-01-01 11:32:42'),
('LABEL-BLUE-SKY', 'test@vinyl.com', '2026-01-01 02:00:05'),
('QLF-RECORD', 'fares@etu.fr', '2026-01-01 02:00:05'),
('TPLG-RECORDS', 'fares@etu.fr', '2026-01-01 02:00:05');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `disk`
--
ALTER TABLE `disk`
  ADD PRIMARY KEY (`identification_code`);

--
-- Index pour la table `disk_to_sold`
--
ALTER TABLE `disk_to_sold`
  ADD PRIMARY KEY (`identification_code`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`email`);

--
-- Index pour la table `vinyl_collection`
--
ALTER TABLE `vinyl_collection`
  ADD PRIMARY KEY (`identification_code`,`user`),
  ADD KEY `user` (`user`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `disk_to_sold`
--
ALTER TABLE `disk_to_sold`
  ADD CONSTRAINT `disk_to_sold_ibfk_1` FOREIGN KEY (`identification_code`) REFERENCES `disk` (`identification_code`);

--
-- Contraintes pour la table `vinyl_collection`
--
ALTER TABLE `vinyl_collection`
  ADD CONSTRAINT `vinyl_collection_ibfk_1` FOREIGN KEY (`identification_code`) REFERENCES `disk` (`identification_code`),
  ADD CONSTRAINT `vinyl_collection_ibfk_2` FOREIGN KEY (`user`) REFERENCES `user` (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
