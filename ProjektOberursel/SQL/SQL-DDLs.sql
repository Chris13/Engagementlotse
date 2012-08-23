-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 23. Aug 2012 um 07:09
-- Server Version: 5.5.16
-- PHP-Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `oberursel`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `aufgabe`
--

CREATE TABLE IF NOT EXISTS `aufgabe` (
  `Aufgabe_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `beschreibung` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`Aufgabe_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Daten für Tabelle `aufgabe`
--

INSERT INTO `aufgabe` (`Aufgabe_id`, `name`, `beschreibung`) VALUES
(1, 'Kinder betreuen', 'Kleine Kinder zwischen 6-10 Jahren');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `einsatz`
--

CREATE TABLE IF NOT EXISTS `einsatz` (
  `Einsatz_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Projekt_Aufgabe_Zuordnung_Aufgabe_id` int(10) unsigned NOT NULL,
  `Projekt_Aufgabe_Zuordnung_Projekt_idProjekt` int(10) unsigned NOT NULL,
  `Helfer_natPerson_Person_person_id` int(10) unsigned NOT NULL,
  `EinsatzBeginn` date DEFAULT NULL,
  `EinsatzEnde` date DEFAULT NULL,
  `EinsatzZeitraum` varchar(255) DEFAULT NULL,
  `EinsatzBeschreibung` longtext,
  `Uhrzeit` datetime DEFAULT NULL,
  PRIMARY KEY (`Einsatz_id`,`Projekt_Aufgabe_Zuordnung_Aufgabe_id`,`Projekt_Aufgabe_Zuordnung_Projekt_idProjekt`),
  KEY `Einsatz_FKIndex1` (`Projekt_Aufgabe_Zuordnung_Projekt_idProjekt`,`Projekt_Aufgabe_Zuordnung_Aufgabe_id`),
  KEY `Einsatz_FKIndex2` (`Helfer_natPerson_Person_person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `faehigkeit`
--

CREATE TABLE IF NOT EXISTS `faehigkeit` (
  `faehigkeit_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bezeichnung` varchar(255) DEFAULT NULL,
  `beschreibung` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`faehigkeit_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Daten für Tabelle `faehigkeit`
--

INSERT INTO `faehigkeit` (`faehigkeit_id`, `bezeichnung`, `beschreibung`) VALUES
(1, 'Polizeiliches Führungszeugnis', 'unbedingt erforderlich!');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `faehigkeit_aufgabe_zuordnung`
--

CREATE TABLE IF NOT EXISTS `faehigkeit_aufgabe_zuordnung` (
  `faehigkeit_id` int(10) unsigned NOT NULL,
  `Aufgabe_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`faehigkeit_id`,`Aufgabe_id`),
  KEY `faehigkeit_has_aufgabe_FKIndex1` (`faehigkeit_id`),
  KEY `faehigkeit_has_aufgabe_FKIndex2` (`Aufgabe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `faehigkeit_aufgabe_zuordnung`
--

INSERT INTO `faehigkeit_aufgabe_zuordnung` (`faehigkeit_id`, `Aufgabe_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `helfer`
--

CREATE TABLE IF NOT EXISTS `helfer` (
  `natPerson_Person_person_id` int(10) unsigned NOT NULL,
  `eintrittsdatum` date NOT NULL,
  PRIMARY KEY (`natPerson_Person_person_id`),
  KEY `Helfer_FKIndex1` (`natPerson_Person_person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `helfer`
--

INSERT INTO `helfer` (`natPerson_Person_person_id`, `eintrittsdatum`) VALUES
(1, '2012-04-11');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `helfer_faehigkeit_zuordnung`
--

CREATE TABLE IF NOT EXISTS `helfer_faehigkeit_zuordnung` (
  `faehigkeit_id` int(10) unsigned NOT NULL,
  `Helfer_natPerson_Person_person_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`faehigkeit_id`,`Helfer_natPerson_Person_person_id`),
  KEY `helfer_has_faehigkeit_FKIndex2` (`faehigkeit_id`),
  KEY `helfer_faehigkeit_zuordnung_FKIndex2` (`Helfer_natPerson_Person_person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `helfer_faehigkeit_zuordnung`
--

INSERT INTO `helfer_faehigkeit_zuordnung` (`faehigkeit_id`, `Helfer_natPerson_Person_person_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `kontaktperson`
--

CREATE TABLE IF NOT EXISTS `kontaktperson` (
  `natPerson_Person_person_id` int(10) unsigned NOT NULL,
  `Traeger_Person_person_id` int(10) unsigned NOT NULL,
  `rolle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`natPerson_Person_person_id`,`Traeger_Person_person_id`),
  KEY `Kontaktperson_FKIndex1` (`natPerson_Person_person_id`),
  KEY `Kontaktperson_FKIndex2` (`Traeger_Person_person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `kontaktperson`
--

INSERT INTO `kontaktperson` (`natPerson_Person_person_id`, `Traeger_Person_person_id`, `rolle`) VALUES
(3, 1, 'Sekretärin');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `Passwort` varchar(255) NOT NULL,
  `admin` varchar(1) NOT NULL,
  `Lotse_natPerson_Person_person_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Passwort`,`admin`,`Lotse_natPerson_Person_person_id`),
  KEY `Login_FKIndex1` (`Lotse_natPerson_Person_person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `login`
--

INSERT INTO `login` (`Passwort`, `admin`, `Lotse_natPerson_Person_person_id`) VALUES
('33151cd9c04223d2f5ed27635e9785bb', 't', 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `lotse`
--

CREATE TABLE IF NOT EXISTS `lotse` (
  `natPerson_Person_person_id` int(10) unsigned NOT NULL,
  `eintrittsdatum` date NOT NULL,
  PRIMARY KEY (`natPerson_Person_person_id`),
  KEY `Lotse_FKIndex1` (`natPerson_Person_person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `lotse`
--

INSERT INTO `lotse` (`natPerson_Person_person_id`, `eintrittsdatum`) VALUES
(1, '2012-01-04');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `natperson`
--

CREATE TABLE IF NOT EXISTS `natperson` (
  `Person_person_id` int(10) unsigned NOT NULL,
  `vname` varchar(255) DEFAULT NULL,
  `nachname` varchar(255) DEFAULT NULL,
  `geburtsdatum` date DEFAULT NULL,
  `geschlecht` varchar(1) DEFAULT NULL,
  `titel` varchar(20) DEFAULT NULL,
  `notizen` longtext,
  PRIMARY KEY (`Person_person_id`),
  KEY `natPerson_FKIndex1` (`Person_person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `natperson`
--

INSERT INTO `natperson` (`Person_person_id`, `vname`, `nachname`, `geburtsdatum`, `geschlecht`, `titel`, `notizen`) VALUES
(1, 'Max', 'mustermann', '1984-03-10', 'm', 'Professor', 'Notizfeld:');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `person_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `telefonnr` varchar(45) DEFAULT NULL,
  `strasse` varchar(255) DEFAULT NULL,
  `handyNr` varchar(45) DEFAULT NULL,
  `eMailAdresse` varchar(255) DEFAULT NULL,
  `Ort` varchar(255) DEFAULT NULL,
  `PLZ` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Daten für Tabelle `person`
--

INSERT INTO `person` (`person_id`, `telefonnr`, `strasse`, `handyNr`, `eMailAdresse`, `Ort`, `PLZ`) VALUES
(1, '654521/44444', 'Teststraße 3', '45466/526', 'Testuser@web.de', 'Musterstadt', 63521),
(2, '55555/55-66', 'Traegerstraße 3', '0172/85654', 'Traeger@stadt.de', 'Musterstadt', 63521),
(3, '55555/55-60', 'Traegerstraße 3', '0172/8523413', 'kontaktperson@rotesKreuz.de', 'Musterstadt', 63521);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `projekt`
--

CREATE TABLE IF NOT EXISTS `projekt` (
  `idProjekt` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `projektname` varchar(255) DEFAULT NULL,
  `DummyBeginn` date DEFAULT NULL,
  `DummyEnde` date DEFAULT NULL,
  `EinsatzAnlegen` tinyint(1) DEFAULT NULL,
  `DummyZeitraum` varchar(255) DEFAULT NULL,
  `DummyEinsatzText` longtext,
  `DummyUhrzeit` datetime DEFAULT NULL,
  PRIMARY KEY (`idProjekt`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Daten für Tabelle `projekt`
--

INSERT INTO `projekt` (`idProjekt`, `projektname`, `DummyBeginn`, `DummyEnde`, `EinsatzAnlegen`, `DummyZeitraum`, `DummyEinsatzText`, `DummyUhrzeit`) VALUES
(1, 'Sommerfest', NULL, NULL, NULL, NULL, '', NULL);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `projekt_aufgabe_zuordnung`
--

CREATE TABLE IF NOT EXISTS `projekt_aufgabe_zuordnung` (
  `Projekt_idProjekt` int(10) unsigned NOT NULL,
  `Aufgabe_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Projekt_idProjekt`,`Aufgabe_id`),
  KEY `Projekt_has_Aufgabe_FKIndex1` (`Projekt_idProjekt`),
  KEY `Projekt_has_Aufgabe_FKIndex2` (`Aufgabe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `projekt_aufgabe_zuordnung`
--

INSERT INTO `projekt_aufgabe_zuordnung` (`Projekt_idProjekt`, `Aufgabe_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `traeger`
--

CREATE TABLE IF NOT EXISTS `traeger` (
  `Person_person_id` int(10) unsigned NOT NULL,
  `rechtsform` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `beschreibung` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`Person_person_id`),
  KEY `Traeger_FKIndex1` (`Person_person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `traeger`
--

INSERT INTO `traeger` (`Person_person_id`, `rechtsform`, `name`, `beschreibung`) VALUES
(2, 'GmBH', 'Rotes Kreuz', 'charitative Einrichtung');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `traeger_projekt_zuordnung`
--

CREATE TABLE IF NOT EXISTS `traeger_projekt_zuordnung` (
  `Traeger_Person_person_id` int(10) unsigned NOT NULL,
  `Projekt_idProjekt` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Traeger_Person_person_id`,`Projekt_idProjekt`),
  KEY `Traeger_Aufgabe_Zuordnung_FKIndex2` (`Traeger_Person_person_id`),
  KEY `Traeger_Projekt_Zuordnung_FKIndex2` (`Projekt_idProjekt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `traeger_projekt_zuordnung`
--

INSERT INTO `traeger_projekt_zuordnung` (`Traeger_Person_person_id`, `Projekt_idProjekt`) VALUES
(2, 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
