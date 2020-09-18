-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 08. Mrz 2020 um 03:18
-- Server-Version: 10.1.36-MariaDB
-- PHP-Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `users`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `categorieName` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `categorie`
--

INSERT INTO `categorie` (`id`, `categorieName`) VALUES
(1, 'Administrativ');


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `task`
--

CREATE TABLE `task` (
  `id` int(11) NOT NULL,
  `titel` varchar(50) DEFAULT NULL,
  `beschreibung` varchar(255) NOT NULL,
  `date_anfang` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_ende` date DEFAULT NULL,
  `prioritaet` int(5) DEFAULT NULL,
  `id_kategorie` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(50) NOT NULL,
  `rechte` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`id`, `firstname`, `lastname`, `username`, `password`, `email`, `rechte`) VALUES
(1, 'Emin', 'Boz', 'EminBoz', '$2y$10$04rK.zPcfNtEH7q/eJvnW.MKkFdNgtKhDgUMBMs6WTlN32r1WIAKC', 'eminboz@gmail.com', 'Admin'),


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user_has_categorie`
--

CREATE TABLE `user_has_categorie` (
  `id_user` int(11) NOT NULL,
  `id_categorie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `user_has_categorie`
--

INSERT INTO `user_has_categorie` (`id_user`, `id_categorie`) VALUES
(1, 1);


--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`id`),
  ADD KEY `task_fk_categorie` (`id_kategorie`),
  ADD KEY `task_fk_user` (`id_user`);

--
-- Indizes für die Tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `user_has_categorie`
--
ALTER TABLE `user_has_categorie`
  ADD KEY `uhc_fk_user` (`id_user`),
  ADD KEY `uhc_fk_categorie` (`id_categorie`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT für Tabelle `task`
--
ALTER TABLE `task`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT für Tabelle `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `task_fk_categorie` FOREIGN KEY (`id_kategorie`) REFERENCES `categorie` (`id`),
  ADD CONSTRAINT `task_fk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Constraints der Tabelle `user_has_categorie`
--
ALTER TABLE `user_has_categorie`
  ADD CONSTRAINT `uhc_fk_categorie` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`),
  ADD CONSTRAINT `uhc_fk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
