-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Sam 19 Août 2017 à 15:02
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestiontachetp1`
--

-- --------------------------------------------------------

--
-- Structure de la table `assignation`
--

CREATE TABLE `assignation` (
  `idassignation` int(5) NOT NULL,
  `idmembre` int(5) NOT NULL,
  `idtache` int(5) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `assignation`
--

INSERT INTO `assignation` (`idassignation`, `idmembre`, `idtache`) VALUES
(1, 2, 5),
(2, 2, 1),
(3, 3, 4),
(4, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

CREATE TABLE `membre` (
  `idmembre` int(5) NOT NULL,
  `nommembre` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `membre`
--

INSERT INTO `membre` (`idmembre`, `nommembre`) VALUES
(1, 'daniel'),
(2, 'cephas'),
(3, 'eliodor');

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

CREATE TABLE `tache` (
  `idtache` int(5) UNSIGNED NOT NULL,
  `nomtache` varchar(40) NOT NULL,
  `descriptiontache` varchar(100) NOT NULL,
  `statustache` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tache`
--

INSERT INTO `tache` (`idtache`, `nomtache`, `descriptiontache`, `statustache`) VALUES
(1, 'click', 'click souris', 'nouveau'),
(2, 'volume', 'augmenter ou diminuer le volume', 'nouveau'),
(3, 'mines', 'positionner les mines', 'nouveau'),
(4, 'gameover', 'fin de la partie', 'nouveau'),
(5, 'son', 'chargement de son ', 'nouveau');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `assignation`
--
ALTER TABLE `assignation`
  ADD PRIMARY KEY (`idassignation`),
  ADD UNIQUE KEY `idtache_2` (`idtache`),
  ADD KEY `idtache` (`idtache`);

--
-- Index pour la table `membre`
--
ALTER TABLE `membre`
  ADD PRIMARY KEY (`idmembre`),
  ADD UNIQUE KEY `idmembre` (`idmembre`),
  ADD UNIQUE KEY `nom` (`nommembre`);

--
-- Index pour la table `tache`
--
ALTER TABLE `tache`
  ADD PRIMARY KEY (`idtache`),
  ADD UNIQUE KEY `nom` (`nomtache`,`descriptiontache`,`statustache`),
  ADD UNIQUE KEY `nom_2` (`nomtache`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `assignation`
--
ALTER TABLE `assignation`
  MODIFY `idassignation` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `membre`
--
ALTER TABLE `membre`
  MODIFY `idmembre` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `tache`
--
ALTER TABLE `tache`
  MODIFY `idtache` int(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
