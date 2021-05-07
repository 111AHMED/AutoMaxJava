-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 18 Juin 2016 à 00:29
-- Version du serveur :  5.6.21
-- Version de PHP :  5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `auto_plus`
--

-- --------------------------------------------------------

--
-- Structure de la table `candidat_table`
--

CREATE TABLE IF NOT EXISTS `candidat_table` (
  `cin` int(11) NOT NULL,
  `nomc` varchar(50) DEFAULT NULL,
  `prenomc` varchar(50) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sexe` varchar(50) DEFAULT NULL,
  `gsm` varchar(50) DEFAULT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  `date_inscription` date DEFAULT NULL,
  `etatcd` varchar(20) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `typeiscri` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `candidat_table`
--

INSERT INTO `candidat_table` (`cin`, `nomc`, `prenomc`, `date_naissance`, `age`, `sexe`, `gsm`, `adresse`, `date_inscription`, `etatcd`, `image`, `typeiscri`) VALUES
(1, 'belmed', 'eded', '2010-08-04', 6, 'Masculin', '12', 'jjjjj', '2016-05-02', 'Actif', 'C:\\xamp\\htdocs\\img\\belmed_tn.png', 'A'),
(3, 'houcine', 'hassan', '1970-05-02', 46, 'Masculin', '5', 'tn', '2016-05-12', 'Actif', 'C:\\xamp\\htdocs\\img\\houcine_tn.jpg', 'B'),
(4, 'med ', 'mabrouk', '2010-01-30', 6, 'Masculin', '11', 'hjk', '2016-02-29', 'Archive', 'C:\\Users\\anouer\\Documents\\AutoplusJframe.png', ''),
(5, 'mouhamed', 'felhi', '2002-03-13', 14, 'Masculin', '5', 'k', '2016-03-02', 'Actif', NULL, ''),
(6, 'ali', 'benali', '2011-02-01', 5, 'Féminin', '55', 'jk', '2016-02-29', 'Actif', '', 'D1'),
(7, 'ali', 'ali2', '2010-02-01', 6, 'Masculin', '4', 'gafsa', '2016-02-29', 'Actif', '', 'C+E'),
(8, 'mariem', 'tounssi', '1994-05-02', 22, 'Féminin', '55996369', 'Gafsa', '2016-03-09', 'Actif', 'C:\\xamp\\htdocs\\img\\mariem_tn.png', 'A'),
(9, 'h1', 'h1', '1952-05-03', 64, 'Masculin', '25', 'hg', '2016-04-26', 'Actif', '', 'A'),
(10, 'azedert', 'azedzert', '2000-03-11', 16, 'Masculin', '41', 'ghjk', '2016-03-03', 'Actif', NULL, ''),
(11, 'zedsds', 'sdsdss', '2015-05-07', 1, 'Masculin', '2', 'ded', '2016-05-02', 'Actif', 'C:\\Users\\anouer\\Desktop\\Auto Plus\\steven_wells100x100.jpg', 'B'),
(12, 'afef', 'afef', '1987-05-16', 29, 'Féminin', '55555', 'maroco', '2016-05-15', 'Actif', '', 'A'),
(15, 'foufa', 'foufa', '1975-07-30', 41, 'Féminin', '155151', 'sasasasasas', '2016-05-30', 'Actif', '', 'A'),
(16, 'mech', 'mech', '2003-05-10', 13, 'Féminin', '8523', 'tn', '2016-05-31', 'Actif', 'C:\\Users\\anouer\\Desktop\\Download\\pp.png', 'B+E'),
(22, 'ahmed', 'ahmed', '2000-03-05', 16, 'Masculin', '52892', 'gafsatn', '2016-03-10', 'Actif', NULL, ''),
(45, 'anwer', 'anwer', '1984-03-30', 32, 'Masculin', '21', 'j', '2016-03-03', 'Actif', NULL, ''),
(120, 'azed', 'azed', '2012-02-04', 4, 'Féminin', '2', '5h', '2016-03-01', 'Actif', NULL, ''),
(201, 'ahmed', 'ahmed', '1993-03-12', 23, 'Masculin', '45', 'sdfghj', '2016-03-03', NULL, NULL, ''),
(250, 'aqs', 'aqs', '2016-04-02', 0, 'Masculin', '25', 'gafsa', '2016-01-04', 'Actif', NULL, ''),
(333, '7afouthi', '7afouth', '1993-04-03', 23, 'Masculin', '25566', 'sdfghj', '2016-04-28', 'Actif', '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0V\0\0\0\0\0\0@\\«•\0\0\0tEXtSoftware\0Adobe ImageReadyqÉe<\0\0qiTXtXML:com.adobe.xmp\0\0\0\0\0<?xpacket begin="ï»¿" id="W5M0MpCehiHzreSzNTczkc9d"?> <x:xmpmeta xmlns:x="adobe:ns:meta/" x:xmptk="A', ''),
(1200, 'ali', 'ajki', '2016-03-05', 2, 'Masculin', '22', 'nddvdfv', '2016-03-02', NULL, '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0Œ\0\0\0Œ\0\0\0™±\0\0\0tEXtSoftware\0Adobe ImageReadyqÉe<\0\0!iTXtXML:com.adobe.xmp\0\0\0\0\0<?xpacket begin="ï»¿" id="W5M0MpCehiHzreSzNTczkc9d"?> <x:xmpmeta xmlns:x="adobe:ns:meta/" x:xmptk="A', ''),
(1202, 'ali', 'ali', '2000-03-04', 16, 'Féminin', '52', 'tn', '2016-03-31', 'Actif', NULL, ''),
(2512, '22', 'lll', '2016-04-10', 0, 'Féminin', '5', 'lll', '2016-01-04', 'Actif', NULL, ''),
(10010, 'lol', 'l', '2016-03-12', 0, 'Masculin', '52', 'tn', '2016-03-09', 'Archive', NULL, ''),
(88888, 'akermi', 'afef', '1985-04-19', 31, 'Féminin', '5285285', 'gafsa', '2016-05-08', 'Actif', '', ''),
(125454, 'rim', 'rim', '1990-02-08', 26, 'Féminin', '555588', 'tn', '2016-06-10', 'Actif', 'C:\\Users\\anouer\\Desktop\\rim_tn.png', 'A'),
(76666666, 'sami', 'yahya', '1985-01-02', 31, 'Masculin', '56231564', 'gafsa centre', '2016-06-01', 'Actif', 'C:\\xamp\\htdocs\\img\\sami_tn.png', 'A');

-- --------------------------------------------------------

--
-- Structure de la table `contrat`
--

CREATE TABLE IF NOT EXISTS `contrat` (
`idctr` int(11) NOT NULL,
  `cinctr` int(11) NOT NULL,
  `datdbctr` date NOT NULL,
  `datfinctr` date NOT NULL,
  `montantctr` int(11) NOT NULL,
  `nbrheure` int(11) NOT NULL,
  `nbrexamen` int(11) NOT NULL,
  `catpermis` varchar(50) NOT NULL,
  `etat` varchar(50) NOT NULL,
  `typectr` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `contrat`
--

INSERT INTO `contrat` (`idctr`, `cinctr`, `datdbctr`, `datfinctr`, `montantctr`, `nbrheure`, `nbrexamen`, `catpermis`, `etat`, `typectr`) VALUES
(9, 1, '2018-05-19', '2018-05-08', 554, 552, 6, 'B', 'Archive', 'Conduite'),
(12, 3, '2016-05-01', '2016-05-08', 500, 2, 2, 'B', 'Actif', 'Conduite'),
(14, 3, '2016-05-08', '2016-05-08', 500, 1, 2, 'A', 'Actif', 'Conduite'),
(16, 3, '2016-05-08', '2016-05-14', 6000, 22, 2, 'B', 'Archive', 'Code'),
(17, 12, '2016-05-15', '2016-05-15', 650, 20, 2, 'c', 'Actif', 'Conduite'),
(18, 12, '2016-05-15', '2016-05-15', 500, 20, 2, 'A', 'Archive', 'Conduite'),
(19, 12, '2016-05-15', '2016-05-07', 230, 5, 2, 'A', 'Actif', 'Conduite'),
(20, 12, '2016-05-15', '2016-05-01', 600, 20, 2, 'A', 'Actif', 'Code'),
(21, 1, '2016-05-07', '2017-05-22', 600, 23, 1, 'A', 'Actif', 'Code'),
(22, 1, '2016-05-01', '2016-05-08', 150, 15, 12, 'B', 'Actif', 'Code'),
(23, 8, '2016-05-27', '2016-05-07', 520, 20, 4, 'A', 'Actif', 'Conduite'),
(24, 1, '2016-05-06', '2016-05-12', 500, 20, 6, 'A', 'Actif', 'Conduite'),
(25, 1, '2016-05-12', '2016-05-18', 500, 17, 3, 'B', 'Archive', 'Code'),
(26, 76666666, '2016-06-01', '2017-06-01', 500, 20, 5, 'A', 'Actif', 'Conduite'),
(27, 76666666, '2016-06-01', '2017-06-01', 500, 15, 20, 'A', 'Actif', 'Code'),
(28, 4, '2016-06-10', '2017-06-10', 650, 20, 6, '', 'Actif', 'Code'),
(29, 4, '2016-06-10', '2016-06-10', 300, 3, 2, '', 'Actif', 'Conduite');

-- --------------------------------------------------------

--
-- Structure de la table `depenses`
--

CREATE TABLE IF NOT EXISTS `depenses` (
`iddep` int(11) NOT NULL,
  `date_dep` date NOT NULL,
  `type_dep` varchar(70) NOT NULL,
  `libelle` varchar(70) DEFAULT NULL,
  `aqui` varchar(70) DEFAULT NULL,
  `montant_dep` int(11) NOT NULL,
  `description` varchar(70) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `depenses`
--

INSERT INTO `depenses` (`iddep`, `date_dep`, `type_dep`, `libelle`, `aqui`, `montant_dep`, `description`) VALUES
(2, '2013-05-30', 'Ecole', 'assurance', 'voiture dacia', 10, '5 eme vidange \n'),
(3, '2016-05-30', 'Vehicule', 'accedent', 'voiture 2', 520, '1 ere accedent'),
(6, '2016-05-31', 'Personnel', 'salaire', 'moniteur a', 500, ''),
(8, '2016-05-31', 'Personnel', 'montant', 'moniteur de code', 500, 'montant'),
(9, '2016-06-01', 'Personnel', 'salaire', 'moniteur de code', 550, 'salaire '),
(10, '2016-06-10', 'Personnel', 'salaire', 'formateur de code', 500, 'salaire');

-- --------------------------------------------------------

--
-- Structure de la table `examen`
--

CREATE TABLE IF NOT EXISTS `examen` (
`idex` int(11) NOT NULL,
  `dateex` date NOT NULL,
  `hdbex` int(11) NOT NULL,
  `hfnex` int(11) NOT NULL,
  `typeexamen` varchar(50) NOT NULL,
  `typepermis` varchar(50) NOT NULL,
  `mtex` float NOT NULL,
  `cincand` int(11) NOT NULL,
  `cinmonite` int(11) DEFAULT NULL,
  `numve` int(11) DEFAULT NULL,
  `idlec` int(11) NOT NULL,
  `etatex` varchar(50) NOT NULL,
  `comexamen` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `examen`
--

INSERT INTO `examen` (`idex`, `dateex`, `hdbex`, `hfnex`, `typeexamen`, `typepermis`, `mtex`, `cincand`, `cinmonite`, `numve`, `idlec`, `etatex`, `comexamen`) VALUES
(21, '2016-05-31', 7, 8, 'ExamenCode', 'A', 35, 1, 12345, NULL, 13, 'Admis', NULL),
(29, '2016-06-01', 7, 8, 'ExamenCode', 'A', 35, 76666666, 12345, NULL, 18, 'Admis', NULL),
(30, '2016-06-01', 7, 8, 'ExamenConduite', 'A', 70, 76666666, 1236, 122, 19, 'Admis', NULL),
(31, '2016-06-10', 15, 16, 'ExamenCode', 'A', 35, 125454, 12345, NULL, 18, 'Admis', NULL),
(32, '2016-06-10', 15, 16, 'ExamenConduite', 'A', 70, 125454, 1236, 122, 19, 'Refuser', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `lecon`
--

CREATE TABLE IF NOT EXISTS `lecon` (
`idlecon` int(11) NOT NULL,
  `Categoriepermis` varchar(50) DEFAULT NULL,
  `type_lec` varchar(50) DEFAULT NULL,
  `mt_lec` int(11) DEFAULT NULL,
  `description_lec` varchar(100) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `lecon`
--

INSERT INTO `lecon` (`idlecon`, `Categoriepermis`, `type_lec`, `mt_lec`, `description_lec`) VALUES
(1, 'A', 'Conduite', 20, 'Sans remize'),
(2, 'A', 'Code', 10, 'Sans remize'),
(3, 'A', 'Code', 0, 'Contrat '),
(4, 'A', 'Conduite', 0, 'Contrat'),
(7, 'B', 'Conduite', 20, 'Sans remise'),
(8, 'B', 'Code', 10, 'Sans remise'),
(9, 'A', 'Code', 35, 'Examen de code de \nla route'),
(10, 'A', 'Code', 360, '2'),
(11, 'c', 'Code', 80, 'sans'),
(12, 'B', 'ExamenConduite', 70, 'sansremise'),
(13, 'B', 'ExamenCode', 35, 'sans remise'),
(14, 'B', 'Code', 0, 'contrat'),
(15, 'B', 'Code', 15, 'sans remise'),
(16, 'B', 'Conduite', 0, 'contrat'),
(17, 'B', 'Conduite', 20, 'sans remise'),
(18, 'A', 'ExamenCode', 35, ''),
(19, 'A', 'ExamenConduite', 70, '');

-- --------------------------------------------------------

--
-- Structure de la table `login_table`
--

CREATE TABLE IF NOT EXISTS `login_table` (
  `login` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `sexe` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `cin` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `login_table`
--

INSERT INTO `login_table` (`login`, `password`, `nom`, `prenom`, `type`, `sexe`, `tel`, `image`, `cin`) VALUES
('', '', 'Fatema', 'Ftema', 'Secrétaire', 'Masculin', '2222', '', '888'),
('22', '22', '8', '8', 'Adminstrateur', 'Masculin', '2222', '', '888'),
('admin', 'admin', 'mouhamed', 'trabelessi', 'Adminstrateur', 'Féminin', '5252', '', '22'),
('bnnb', '', 'sdn', 'cvbn,', 'Secrétaire', 'Féminin', '', '', '886'),
('refreferf', 'refreferfer', 'refre', 'refref', 'Secrétaire', 'Féminin', 'refrefrf', '', '12121'),
('sect', 'sect', 'hayefa', 'ben ali', 'Secrétaire', 'Féminin', '2882', 'C:\\xamp\\htdocs\\pics\\amy_jones.jpg', '88'),
('sqs', 'sqsq', 'ferfref', 'referfreferf', 'Adminstrateur', 'Masculin', '52', '', '82');

-- --------------------------------------------------------

--
-- Structure de la table `moniteur`
--

CREATE TABLE IF NOT EXISTS `moniteur` (
  `cinmoni` int(11) NOT NULL,
  `nom_moni` varchar(50) DEFAULT NULL,
  `prenom_moni` varchar(50) DEFAULT NULL,
  `date_naissmoni` date DEFAULT NULL,
  `sexe` varchar(20) DEFAULT NULL,
  `adresse_moni` varchar(100) DEFAULT NULL,
  `tel1` varchar(25) DEFAULT NULL,
  `tel2` varchar(25) DEFAULT NULL,
  `poste_moni` varchar(50) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `moniteur`
--

INSERT INTO `moniteur` (`cinmoni`, `nom_moni`, `prenom_moni`, `date_naissmoni`, `sexe`, `adresse_moni`, `tel1`, `tel2`, `poste_moni`, `image`) VALUES
(1236, 'ahk', 'ahk', '2001-02-23', 'Masculin', 'gafsatn', '5212', '225522', 'Conduite', 'C:\\Users\\anouer\\Desktop\\Auto Plus\\dg.png'),
(8520, 'zed', 'zed', '2010-02-02', 'Masculin', 'fr1', '52', '852', 'Conduite', 'C:\\Users\\anouer\\Documents\\AutoplusJframe.png'),
(12345, 'med', 'ali', '1975-03-01', 'Féminin', 'tnga', '5252', '2323', 'Code', 'C:\\Users\\anouer\\Documents\\AutoplusJframe.png'),
(999999, 'mabrouk', 'mabrouk', '2016-05-04', 'Masculin', 'gafsa', '852', '', 'Conduite', '');

-- --------------------------------------------------------

--
-- Structure de la table `parametre`
--

CREATE TABLE IF NOT EXISTS `parametre` (
`idar` int(11) NOT NULL,
  `nom_auto` varchar(50) NOT NULL,
  `propretaire_auto` varchar(50) NOT NULL,
  `adresse_auto` varchar(50) NOT NULL,
  `ville_auto` varchar(50) NOT NULL,
  `codepostal` varchar(50) NOT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `telfixe` varchar(50) DEFAULT NULL,
  `telportable` varchar(50) DEFAULT NULL,
  `identifientfiscal` varchar(50) DEFAULT NULL,
  `code_auto` varchar(50) DEFAULT NULL,
  `date_ouverture` date DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `parametre`
--

INSERT INTO `parametre` (`idar`, `nom_auto`, `propretaire_auto`, `adresse_auto`, `ville_auto`, `codepostal`, `mail`, `telfixe`, `telportable`, `identifientfiscal`, `code_auto`, `date_ouverture`) VALUES
(1, 'ALEmmetiaz', 'Yahya Ramzi', 'Mawala', 'gafsa centre ', '2100', '0', '36169555', '26262626', '1212', '1255', '2009-02-01');

-- --------------------------------------------------------

--
-- Structure de la table `regelement`
--

CREATE TABLE IF NOT EXISTS `regelement` (
`idreg` int(11) NOT NULL,
  `cinct` int(11) NOT NULL,
  `datereg` date NOT NULL,
  `mtreg` int(11) NOT NULL,
  `mode` varchar(50) NOT NULL,
  `numche` varchar(50) DEFAULT NULL,
  `typesp` varchar(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `regelement`
--

INSERT INTO `regelement` (`idreg`, `cinct`, `datereg`, `mtreg`, `mode`, `numche`, `typesp`) VALUES
(2, 8, '2016-05-07', 80650, 'Espces', '', NULL),
(3, 4, '2016-05-08', 600, 'Espces', '', NULL),
(7, 9, '2016-05-31', 5000, 'Chéque', 'rdfvgbyhunj,i', NULL),
(12, 76666666, '2016-06-01', 1000, 'Espces', '', 'A'),
(13, 76666666, '2016-06-01', 105, 'Chéque', '5555555', 'A');

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

CREATE TABLE IF NOT EXISTS `seance` (
`ids` int(11) NOT NULL,
  `date_sean` date DEFAULT NULL,
  `heure_db` int(11) DEFAULT NULL,
  `heure_fin` int(11) DEFAULT NULL,
  `duree_sean` int(11) DEFAULT NULL,
  `type_sean` varchar(50) NOT NULL,
  `cinc` int(11) NOT NULL,
  `cinmoni` int(11) NOT NULL,
  `numv` int(11) DEFAULT NULL,
  `idlecon` int(11) NOT NULL,
  `typepermis` varchar(50) DEFAULT NULL,
  `mtsean` float NOT NULL,
  `parcking` varchar(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `seance`
--

INSERT INTO `seance` (`ids`, `date_sean`, `heure_db`, `heure_fin`, `duree_sean`, `type_sean`, `cinc`, `cinmoni`, `numv`, `idlecon`, `typepermis`, `mtsean`, `parcking`) VALUES
(9, '2016-05-01', 7, 8, 1, 'Conduite', 22, 1236, 122, 3, 'A', 0, ''),
(11, '2016-05-01', 7, 8, 1, 'Conduite', 5, 1236, 122, 1, 'A', 20000, ''),
(12, '2016-05-29', 7, 8, 1, 'Conduite', 5, 1236, 122, 1, 'A', 20000, ''),
(14, '2016-05-15', 7, 23, 16, 'Code', 6, 12345, NULL, 2, 'A', 160000, ''),
(15, '2016-05-15', 7, 23, 16, 'Code', 6, 12345, NULL, 2, 'A', 160000, ''),
(16, '2016-05-15', 7, 23, 16, 'Code', 6, 12345, NULL, 2, 'A', 160000, ''),
(17, '2016-05-15', 7, 23, 16, 'Code', 6, 12345, NULL, 2, 'A', 160000, ''),
(18, '2016-05-15', 7, 23, 16, 'Code', 6, 12345, NULL, 2, 'A', 160000, ''),
(20, '2016-05-01', 7, 8, 1, 'Code', 12, 12345, NULL, 8, 'A', 10, ''),
(23, '2016-05-08', 7, 8, 1, 'Code', 9, 12345, NULL, 2, 'A', 10000, ''),
(34, '2016-06-02', 11, 12, 1, 'Conduite', 8, 1236, 122, 1, 'A', 20, ''),
(35, '2016-05-08', 7, 8, 1, 'Code', 12, 12345, NULL, 2, 'B', 10000, ''),
(36, '2016-05-01', 7, 8, 1, 'Code', 3, 12345, NULL, 8, 'B', 10, ''),
(37, '2016-05-08', 7, 8, 1, 'Code', 8, 12345, NULL, 2, 'b', 10, ''),
(38, '2016-05-07', 7, 8, 1, 'Conduite', 1, 999999, 158, 1, 'A', 20, ''),
(39, '2016-05-29', 7, 13, 6, 'Conduite', 1, 999999, 158, 1, 'A', 120, ''),
(40, '2016-05-01', 7, 8, 1, 'Conduite', 1, 1236, 122, 1, 'A', 20, 'parcking'),
(42, '2016-05-30', 7, 8, 1, 'Code', 3, 12345, NULL, 8, 'B', 10, ''),
(44, '2016-05-31', 7, 8, 1, 'Code', 3, 12345, NULL, 8, 'B', 10, ''),
(45, '2016-05-29', 7, 8, 1, 'Code', 1, 12345, NULL, 2, 'A', 10, ''),
(46, '2016-06-30', 7, 8, 1, 'Code', 1, 12345, NULL, 8, 'B', 10, ''),
(49, '2016-06-01', 7, 8, 1, 'Code', 76666666, 12345, NULL, 3, 'A', 0, ''),
(50, '2016-06-01', 7, 8, 1, 'Conduite', 76666666, 1236, 122, 4, 'A', 0, ''),
(51, '2016-06-05', 7, 8, 1, 'Code', 125454, 12345, NULL, 2, 'A', 10, ''),
(52, '2016-06-10', 7, 8, 1, 'Conduite', 125454, 1236, 122, 1, 'A', 20, '');

-- --------------------------------------------------------

--
-- Structure de la table `suivivoiture`
--

CREATE TABLE IF NOT EXISTS `suivivoiture` (
`idsuivi` int(11) NOT NULL,
  `numvehicule` int(11) NOT NULL,
  `action` varchar(50) DEFAULT NULL,
  `datedebuts` date DEFAULT NULL,
  `datefins` date DEFAULT NULL,
  `datealert` date DEFAULT NULL,
  `kilometrage` varchar(50) DEFAULT NULL,
  `descriptionsuivi` varchar(200) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `suivivoiture`
--

INSERT INTO `suivivoiture` (`idsuivi`, `numvehicule`, `action`, `datedebuts`, `datefins`, `datealert`, `kilometrage`, `descriptionsuivi`) VALUES
(2, 122, 'Visite', '2016-05-01', '2016-05-08', '2016-05-29', '12', 'rdgf'),
(3, 122, 'Visite', '2016-05-01', '2016-05-01', '2016-05-01', '', ''),
(4, 122, 'Assurance', '2016-05-01', '2016-05-01', '2016-05-30', '', ''),
(7, 120, 'Assurance', '2016-05-01', '2016-05-01', '2016-05-29', '', 'Assurance Dacia'),
(8, 120, 'Assurance', '2016-05-01', '2020-05-01', '8888-02-03', '', ''),
(9, 120, 'Visite', '2016-05-01', '2020-05-01', '8888-02-03', '', ''),
(10, 120, 'Assurance', '2016-05-08', '2016-05-01', '2016-05-01', '', ''),
(13, 120, 'Assurance', '2016-05-01', '2020-05-01', '8888-02-03', '', ''),
(14, 120, 'Assurance', '2010-11-19', '2016-08-13', '2016-05-21', '', ''),
(15, 158, 'Visite', '2016-05-01', '2017-05-30', '2016-05-31', '452525', 'dcftvgbhunji,rtgy'),
(16, 120, 'Visite', '2016-06-01', '2016-09-01', '2016-08-24', '', ''),
(17, 122, 'Assurance', '2016-06-01', '2017-06-30', '2016-06-01', '5555555', '3eme assurance'),
(18, 122, 'Visite', '2016-06-10', '2016-06-10', '2016-06-10', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE IF NOT EXISTS `vehicule` (
  `numv` int(11) NOT NULL,
  `marquev` varchar(50) DEFAULT NULL,
  `modelev` varchar(50) DEFAULT NULL,
  `couleurv` varchar(50) DEFAULT NULL,
  `etatv` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `vehicule`
--

INSERT INTO `vehicule` (`numv`, `marquev`, `modelev`, `couleurv`, `etatv`) VALUES
(120, '320', '6450', '7505', 'Hors service'),
(122, 'peugeot', '206', 'bleuc', 'En service'),
(158, 'renault', 'clio', 'gris', 'En service');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `candidat_table`
--
ALTER TABLE `candidat_table`
 ADD PRIMARY KEY (`cin`);

--
-- Index pour la table `contrat`
--
ALTER TABLE `contrat`
 ADD PRIMARY KEY (`idctr`), ADD KEY `fk0l` (`cinctr`);

--
-- Index pour la table `depenses`
--
ALTER TABLE `depenses`
 ADD PRIMARY KEY (`iddep`);

--
-- Index pour la table `examen`
--
ALTER TABLE `examen`
 ADD PRIMARY KEY (`idex`), ADD KEY `fkl` (`cincand`), ADD KEY `fk22` (`cinmonite`), ADD KEY `fk31` (`numve`), ADD KEY `fk33` (`idlec`);

--
-- Index pour la table `lecon`
--
ALTER TABLE `lecon`
 ADD PRIMARY KEY (`idlecon`);

--
-- Index pour la table `login_table`
--
ALTER TABLE `login_table`
 ADD PRIMARY KEY (`login`);

--
-- Index pour la table `moniteur`
--
ALTER TABLE `moniteur`
 ADD PRIMARY KEY (`cinmoni`);

--
-- Index pour la table `parametre`
--
ALTER TABLE `parametre`
 ADD PRIMARY KEY (`idar`);

--
-- Index pour la table `regelement`
--
ALTER TABLE `regelement`
 ADD PRIMARY KEY (`idreg`), ADD KEY `fkl0` (`cinct`);

--
-- Index pour la table `seance`
--
ALTER TABLE `seance`
 ADD PRIMARY KEY (`ids`), ADD KEY `fk1` (`cinc`), ADD KEY `fk2` (`idlecon`), ADD KEY `fk3` (`cinmoni`), ADD KEY `fk4` (`numv`);

--
-- Index pour la table `suivivoiture`
--
ALTER TABLE `suivivoiture`
 ADD PRIMARY KEY (`idsuivi`), ADD KEY `f` (`numvehicule`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
 ADD PRIMARY KEY (`numv`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `contrat`
--
ALTER TABLE `contrat`
MODIFY `idctr` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT pour la table `depenses`
--
ALTER TABLE `depenses`
MODIFY `iddep` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `examen`
--
ALTER TABLE `examen`
MODIFY `idex` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT pour la table `lecon`
--
ALTER TABLE `lecon`
MODIFY `idlecon` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT pour la table `parametre`
--
ALTER TABLE `parametre`
MODIFY `idar` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `regelement`
--
ALTER TABLE `regelement`
MODIFY `idreg` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT pour la table `seance`
--
ALTER TABLE `seance`
MODIFY `ids` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=53;
--
-- AUTO_INCREMENT pour la table `suivivoiture`
--
ALTER TABLE `suivivoiture`
MODIFY `idsuivi` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `contrat`
--
ALTER TABLE `contrat`
ADD CONSTRAINT `fk0l` FOREIGN KEY (`cinctr`) REFERENCES `candidat_table` (`cin`);

--
-- Contraintes pour la table `examen`
--
ALTER TABLE `examen`
ADD CONSTRAINT `fk22` FOREIGN KEY (`cinmonite`) REFERENCES `moniteur` (`cinmoni`),
ADD CONSTRAINT `fk31` FOREIGN KEY (`numve`) REFERENCES `vehicule` (`numv`),
ADD CONSTRAINT `fk33` FOREIGN KEY (`idlec`) REFERENCES `lecon` (`idlecon`),
ADD CONSTRAINT `fkl` FOREIGN KEY (`cincand`) REFERENCES `candidat_table` (`cin`);

--
-- Contraintes pour la table `regelement`
--
ALTER TABLE `regelement`
ADD CONSTRAINT `fkl0` FOREIGN KEY (`cinct`) REFERENCES `candidat_table` (`cin`);

--
-- Contraintes pour la table `seance`
--
ALTER TABLE `seance`
ADD CONSTRAINT `fk1` FOREIGN KEY (`cinc`) REFERENCES `candidat_table` (`cin`),
ADD CONSTRAINT `fk2` FOREIGN KEY (`idlecon`) REFERENCES `lecon` (`idlecon`),
ADD CONSTRAINT `fk3` FOREIGN KEY (`cinmoni`) REFERENCES `moniteur` (`cinmoni`),
ADD CONSTRAINT `fk4` FOREIGN KEY (`numv`) REFERENCES `vehicule` (`numv`);

--
-- Contraintes pour la table `suivivoiture`
--
ALTER TABLE `suivivoiture`
ADD CONSTRAINT `f` FOREIGN KEY (`numvehicule`) REFERENCES `vehicule` (`numv`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
