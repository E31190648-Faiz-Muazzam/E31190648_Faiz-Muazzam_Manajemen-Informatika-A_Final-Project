-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Jun 2020 pada 06.01
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbhamasah`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `daftar`
--

CREATE TABLE `daftar` (
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `No_Telepon` varchar(20) NOT NULL,
  `Alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `daftar`
--

INSERT INTO `daftar` (`Username`, `Password`, `Nama`, `No_Telepon`, `Alamat`) VALUES
('123', '[1, n, g, a, n, t]', 'faisx', '1234', 'akansjx'),
('Akbar12', '[1, 2, 3]', 'Jodha Akbar', '123456', 'Jember'),
('Faiz-Muazzam', '[1, n, g, a, n, t, i, 9]', 'Faiz Muazzam', '081912940523', 'Tulungagung'),
('FaizMuazzam', '[1, n, g, a, n, t, i, 9]', 'Faiz Muazzam', '081335088111', 'Tulungagung'),
('Rabu', '[1]', 'RabuKamis', '123', 'Ta');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesan`
--

CREATE TABLE `pesan` (
  `No_Loker` varchar(100) NOT NULL,
  `Nama_Pelanggan` varchar(50) NOT NULL,
  `Berat_Barang` varchar(50) NOT NULL,
  `Service` varchar(10) NOT NULL,
  `Time_Service` varchar(10) NOT NULL,
  `Jenis_Parfum` varchar(10) NOT NULL,
  `Total_Harga` varchar(255) NOT NULL,
  `Tanggal_Pesan` varchar(30) NOT NULL,
  `Tanggal_Ambil` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pesan`
--

INSERT INTO `pesan` (`No_Loker`, `Nama_Pelanggan`, `Berat_Barang`, `Service`, `Time_Service`, `Jenis_Parfum`, `Total_Harga`, `Tanggal_Pesan`, `Tanggal_Ambil`) VALUES
('1', 'Faiz-Muazzam', '5', 'Expert', 'Kilat', 'Vanila', '19.000', '2020-Jun-11', '2020-Jun-12'),
('10', 'Leonal Messi', '2.5', 'Reguler', 'Santai', 'Stawberry', '7.500', '2020-06-07', '2020-06-09'),
('11', 'G.Bale', '5', 'Expert', 'Santai', 'Orange', '17.000', '2020-06-07', '2020-06-10'),
('2', 'Jarwo', '1', 'Reguler', 'Santai', 'Stawberry', '3.000', '2020-06-07', '2020-06-09'),
('3', 'Pakde Karwo', '2', 'Reguler', 'Kilat', 'Stawberry', '8.000', '2020-06-07', '2020-06-09'),
('4', 'Moh.Salah', '2', 'Expert', 'Santai', 'Stawberry', '8.000', '2020-06-07', '2020-06-09'),
('5', 'Z.Zidane', '5', 'Expert', 'Kilat', 'Vanila', '19.000', '2020-06-07', '2020-06-08'),
('6', 'V.Rossi', '3', 'Expert', 'Santai', 'Vanila', '11.000', '2020-06-07', '2020-06-09'),
('7', 'C.Ronaldo', '5', 'Expert', 'Kilat', 'Orange', '19.000', '2020-06-07', '2020-06-08'),
('8', 'LuckyBoy', '4', 'Expert', 'Kilat', 'Vanila', '16.000', '2020-06-07', '2020-06-08'),
('9', 'Nermar.Jr', '1.5', 'Expert', 'Kilat', 'Vanila', '8.500', '2020-06-07', '2020-06-08');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbdaftar`
--

CREATE TABLE `tbdaftar` (
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Nama` varchar(30) NOT NULL,
  `No_Telepon` varchar(30) NOT NULL,
  `Alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `No_Loker` varchar(50) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Harga` varchar(50) NOT NULL,
  `Uang_Tunai` varchar(50) NOT NULL,
  `Kembalian` varchar(50) NOT NULL,
  `Tanggal_Pesan` varchar(50) NOT NULL,
  `Tanggal_Ambil` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`No_Loker`, `Nama`, `Harga`, `Uang_Tunai`, `Kembalian`, `Tanggal_Pesan`, `Tanggal_Ambil`) VALUES
('1', 'Faiz-Muazzam', '19.000', '50000', '31.000', '2020-Jun-12', '2020-Jun-12'),
('21', 'Yongki', '10.000', '10000', '.000', '2020-06-08', '2020-06-08');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `daftar`
--
ALTER TABLE `daftar`
  ADD PRIMARY KEY (`Username`,`Password`);

--
-- Indeks untuk tabel `pesan`
--
ALTER TABLE `pesan`
  ADD PRIMARY KEY (`No_Loker`);

--
-- Indeks untuk tabel `tbdaftar`
--
ALTER TABLE `tbdaftar`
  ADD PRIMARY KEY (`Username`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`No_Loker`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
