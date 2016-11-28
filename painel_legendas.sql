-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 24-Nov-2016 às 19:20
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `painel_legendas`
--
CREATE DATABASE IF NOT EXISTS `painel_legendas` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `painel_legendas`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `permission`
--

CREATE TABLE `permission` (
  `id_perm` int(11) NOT NULL,
  `permission` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `project`
--

CREATE TABLE `project` (
  `id_proj` int(11) NOT NULL,
  `id_team` int(11) NOT NULL,
  `release_proj` varchar(50) NOT NULL,
  `link_torrent` varchar(250) NOT NULL,
  `link_subtitle` varchar(250) NOT NULL,
  `reviewer1` int(11) NOT NULL,
  `reviewer2` int(11) NOT NULL,
  `date_start` date NOT NULL,
  `date_finish` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `project_slot`
--

CREATE TABLE `project_slot` (
  `id_proj_slot` int(11) NOT NULL,
  `id_proj` int(11) NOT NULL,
  `name` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `file` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `solicitation_team`
--

CREATE TABLE `solicitation_team` (
  `id_soli_team` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `foto` varchar(250) NOT NULL,
  `id_stat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `solicitation_user`
--

CREATE TABLE `solicitation_user` (
  `id_soli_user` int(11) NOT NULL,
  `id_team` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `message` varchar(300) NOT NULL,
  `id_stat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `status`
--

CREATE TABLE `status` (
  `id_stat` int(11) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `team`
--

CREATE TABLE `team` (
  `id_team` int(11) NOT NULL,
  `name` int(11) NOT NULL,
  `photo` varchar(200) NOT NULL,
  `admim` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `team_user`
--

CREATE TABLE `team_user` (
  `id_team_user` int(11) NOT NULL,
  `id_team` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_perm` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `id_perm` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `user`
--

INSERT INTO `user` (`id_user`, `nickname`, `email`, `password`, `id_perm`) VALUES
(5, 'Clevison', 'clevison.luiz@gmail.com', '123', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`id_perm`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id_proj`),
  ADD UNIQUE KEY `un_release` (`release_proj`);

--
-- Indexes for table `project_slot`
--
ALTER TABLE `project_slot`
  ADD PRIMARY KEY (`id_proj_slot`);

--
-- Indexes for table `solicitation_team`
--
ALTER TABLE `solicitation_team`
  ADD PRIMARY KEY (`id_soli_team`),
  ADD UNIQUE KEY `un_nome` (`nickname`);

--
-- Indexes for table `solicitation_user`
--
ALTER TABLE `solicitation_user`
  ADD PRIMARY KEY (`id_soli_user`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id_stat`),
  ADD UNIQUE KEY `un_status` (`status`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`id_team`),
  ADD UNIQUE KEY `un_nome` (`name`);

--
-- Indexes for table `team_user`
--
ALTER TABLE `team_user`
  ADD PRIMARY KEY (`id_team_user`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `un_nick` (`nickname`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `permission`
--
ALTER TABLE `permission`
  MODIFY `id_perm` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `id_proj` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `project_slot`
--
ALTER TABLE `project_slot`
  MODIFY `id_proj_slot` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `solicitation_team`
--
ALTER TABLE `solicitation_team`
  MODIFY `id_soli_team` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `solicitation_user`
--
ALTER TABLE `solicitation_user`
  MODIFY `id_soli_user` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `id_stat` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `id_team` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `team_user`
--
ALTER TABLE `team_user`
  MODIFY `id_team_user` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
