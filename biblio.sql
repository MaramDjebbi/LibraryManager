

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


--
-- Base de données: `biblio`
--
-- --------------------------------------------------------

--
-- Structure de la table `abonne`
--

CREATE TABLE IF NOT EXISTS `abonne` (
  `idab` int(11) NOT NULL,
  `nomab` varchar(100) NOT NULL,
  PRIMARY KEY (`idab`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `abonne`
--

INSERT INTO `abonne` (`idab`, `nomab`) VALUES
(1, 'MARAM DJEBBI'),
(2, 'NADINE EL ARAJNA'),
(3, 'IMEN CHERIF'),
(4, 'AHMED SNOUSSI'),
(5, 'RIADH CHERCHERI'),
(6, 'HATEM DRIDI'),
(7, 'SAFA OUERCHFANI');

-- --------------------------------------------------------
--
-- Structure de la table `livre`
--

CREATE TABLE IF NOT EXISTS `livre` (
  `idlivre` int(11) NOT NULL,
  `titre` varchar(90) NOT NULL,
  `autheur` varchar(50) DEFAULT NULL,
  `disponible` varchar(10) NOT NULL,
  `idabonne` int(11) DEFAULT NULL,
  PRIMARY KEY (`idlivre`),
  KEY `fk1` (`idabonne`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `livre`
--

INSERT INTO `livre` (`idlivre`, `titre`, `autheur`, `disponible`, `idabonne`) VALUES
(1, 'LES MISERABLES', NULL, 'OUI', NULL),
(2, 'PRIDE AND PREJUDICE', NULL, 'OUI', NULL),
(3, 'THE PILLERS OF THE EARTH', NULL, 'OUI', NULL),
(4, 'IT ENDS WITH US', NULL, 'OUI', NULL),
(5, 'IT STARTS WITH US', NULL, 'NON', 4),
(6, 'SANS FAMILLE', NULL, 'NON', 5),
(7, 'THE FAULT IN OUR STARS', NULL, 'OUI', NULL);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `pret`
--
CREATE TABLE IF NOT EXISTS `pret` (
`idlivre` int(11)
,`titre` varchar(90)
,`nomab` varchar(100)
);
-- --------------------------------------------------------

--
-- Structure de la vue `pret`
--
DROP TABLE IF EXISTS `pret`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `pret` AS select `livre`.`idlivre` AS `idlivre`,`livre`.`titre` AS `titre`,`abonne`.`nomab` AS `nomab` from (`livre` join `abonne` on((`livre`.`idabonne` = `abonne`.`idab`))) where (`livre`.`disponible` = 'NON');

--
-- Contraintes pour la table `livre`
--
ALTER TABLE `livre`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`idabonne`) REFERENCES `abonne` (`idab`);

