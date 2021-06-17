-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-06-2021 a las 21:45:45
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bibliotecagrupo3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE `autor` (
  `id_autor` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `fecha_nac` date NOT NULL,
  `nacionalidad` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`id_autor`, `dni`, `nombre`, `apellido`, `fecha_nac`, `nacionalidad`) VALUES
(1, 37639192, 'Rodrigo', 'Gomez', '1993-10-01', 'Argentino'),
(2, 38438261, 'David', 'Cola', '1992-11-14', 'Argentino'),
(4, 38749834, 'Romina', 'Godoy', '1995-01-13', 'Argentino'),
(5, 31234567, 'Alfredo', 'Sosa', '1990-02-13', 'Argentino'),
(6, 12312312, 'Allan', 'Poe', '1809-01-19', 'NorteAmericano'),
(7, 40123123, 'Nahuel', 'Vargas', '1998-06-10', 'Argentino'),
(8, 39999888, 'Pablo', 'Cubillos', '1995-11-08', 'Argentino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE TABLE `ejemplar` (
  `id_ejemplar` int(11) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `isbn_libro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ejemplar`
--

INSERT INTO `ejemplar` (`id_ejemplar`, `estado`, `isbn_libro`) VALUES
(6, 'retrasado', 1234),
(7, 'retrasado', 1111),
(8, 'disponible', 1010),
(9, 'reparación', 1010),
(10, 'disponible', 2020),
(11, 'prestado', 2020),
(12, 'prestado', 1111),
(13, 'disponible', 1111),
(14, 'prestado', 2222),
(15, 'disponible', 3333),
(16, 'disponible', 7777),
(17, 'disponible', 4444),
(18, 'prestado', 4444),
(19, 'prestado', 5555),
(20, 'prestado', 5555),
(21, 'prestado', 7777),
(22, 'prestado', 7777),
(23, 'disponible', 8888),
(24, 'disponible', 8888);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lector`
--

CREATE TABLE `lector` (
  `dni` int(11) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `lector`
--

INSERT INTO `lector` (`dni`, `direccion`, `nombre`, `apellido`, `estado`) VALUES
(11111111, 'pringles 1906', 'guillermo', 'scheloto', 1),
(35690000, 'Av Chorrillero 1000', 'Cristina', 'Kirchner', 1),
(35690100, 'Av Chorrillero 2000', 'Maria ', 'Vidal', 1),
(35690111, 'Av Chorrillero 3000', 'Patricia ', 'Bullrich', 1),
(35690222, 'Av Chorrillero 4000', 'Alex', 'Kicillof', 1),
(35690332, 'Av Chorrillero 5000', 'Horacio', 'Larreta', 1),
(35690888, 'Av Chorrillero 2020', 'Mauricio', 'Macri', 1),
(35779555, 'Av Chorrillero 7900', 'Javier', 'Milei', 1),
(35779890, 'Av Centenario 2000', 'Hugo', 'Morales', 1),
(38438000, 'rivadavia 1000', 'Alberto', 'Fernandez', 1),
(38438261, 'chubut 1906', 'Cola', 'Tachi', 1),
(67867890, 'rivadavia 1000', 'kevin', 'duarte', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `id_autor` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `editorial` varchar(40) NOT NULL,
  `año` int(11) NOT NULL,
  `tipo` varchar(40) NOT NULL,
  `isbn` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`id_autor`, `nombre`, `editorial`, `año`, `tipo`, `isbn`) VALUES
(5, 'La Web', 'Windows', 2020, 'Programacion', 1010),
(2, 'estoy loco', 'de la cabeza', 2020, 'psicologia', 1111),
(6, 'Gato Negro', 'New York Mirrow', 1910, 'Poesia', 1112),
(1, 'Historio argentina', 'argentinisima', 2010, 'Historia', 1234),
(5, 'Principios de JS', 'Windows', 2008, 'Programacion', 2020),
(1, 'Presidentes Argentos', 'Argentinisima', 2011, 'Historia', 2222),
(2, 'El por que de todo', 'Pensantes', 2019, 'Psicologia', 3333),
(7, 'Java Avanzado', 'Algoritmo', 2018, 'Programacion', 4444),
(7, 'c++ para principiantes', 'Algoritmo', 2017, 'Programacion', 5555),
(8, 'Matematica 1', 'Book', 2010, 'Matematicas', 7777),
(8, 'Aprendiendo Algebra', 'Urano', 2006, 'Matematicas', 8888),
(6, 'El Cuervo', 'Nueva York Mirro', 1900, 'Poesia', 9999);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `multa`
--

CREATE TABLE `multa` (
  `id_multa` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `multa`
--

INSERT INTO `multa` (`id_multa`, `fecha_inicio`, `fecha_fin`) VALUES
(5, '2021-04-13', '2021-04-15'),
(6, '2021-06-04', '2021-06-06'),
(7, '2021-04-23', '2021-04-25'),
(8, '2021-04-22', '2021-04-24'),
(9, '2021-01-08', '2021-01-10'),
(10, '2021-06-18', '2021-06-22');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `id_prestamo` int(11) NOT NULL,
  `id_multa` int(11) DEFAULT NULL,
  `id_ejemplar` int(11) NOT NULL,
  `dni_lector` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha` date NOT NULL,
  `fecha_devolucion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`id_prestamo`, `id_multa`, `id_ejemplar`, `dni_lector`, `estado`, `fecha`, `fecha_devolucion`) VALUES
(5, 8, 6, 38438261, 0, '2020-12-09', '2021-04-13'),
(6, 6, 7, 67867890, 0, '2021-04-15', '2021-06-04'),
(7, 5, 7, 11111111, 0, '2020-11-11', '2021-04-04'),
(8, 7, 6, 67867890, 0, '2020-12-01', '2021-04-22'),
(9, 9, 6, 38438261, 0, '2020-11-03', '2021-01-08'),
(10, NULL, 17, 35779555, 0, '2021-06-17', '2021-06-18'),
(11, NULL, 20, 35690888, 1, '2021-06-17', NULL),
(12, NULL, 11, 35690000, 1, '2021-06-17', NULL),
(14, NULL, 14, 35690000, 1, '2021-06-17', NULL),
(15, NULL, 18, 35690000, 1, '2021-06-17', NULL),
(16, NULL, 19, 35779890, 1, '2021-06-18', NULL),
(17, NULL, 24, 35779555, 0, '2021-06-18', '2021-06-18'),
(18, NULL, 22, 35690100, 1, '2021-06-18', NULL),
(19, NULL, 21, 35690111, 1, '2021-06-18', NULL),
(20, NULL, 23, 35779555, 0, '2021-06-18', '2021-06-18'),
(21, 10, 6, 11111111, 0, '2021-05-12', '2021-06-18'),
(22, 10, 23, 11111111, 0, '2021-05-12', '2021-06-18'),
(23, NULL, 6, 67867890, 1, '2021-01-07', NULL),
(24, NULL, 7, 67867890, 1, '2021-01-07', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`id_autor`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD PRIMARY KEY (`id_ejemplar`),
  ADD KEY `ejemplar_ibfk_1` (`isbn_libro`);

--
-- Indices de la tabla `lector`
--
ALTER TABLE `lector`
  ADD PRIMARY KEY (`dni`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`isbn`),
  ADD KEY `id_autor` (`id_autor`);

--
-- Indices de la tabla `multa`
--
ALTER TABLE `multa`
  ADD PRIMARY KEY (`id_multa`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`id_prestamo`),
  ADD KEY `id_ejemplar` (`id_ejemplar`),
  ADD KEY `dni_lector` (`dni_lector`),
  ADD KEY `id_multa` (`id_multa`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autor`
--
ALTER TABLE `autor`
  MODIFY `id_autor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  MODIFY `id_ejemplar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `multa`
--
ALTER TABLE `multa`
  MODIFY `id_multa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `id_prestamo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD CONSTRAINT `ejemplar_ibfk_1` FOREIGN KEY (`isbn_libro`) REFERENCES `libro` (`isbn`);

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`id_autor`) REFERENCES `autor` (`id_autor`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`id_ejemplar`) REFERENCES `ejemplar` (`id_ejemplar`),
  ADD CONSTRAINT `prestamo_ibfk_3` FOREIGN KEY (`dni_lector`) REFERENCES `lector` (`dni`),
  ADD CONSTRAINT `prestamo_ibfk_4` FOREIGN KEY (`id_multa`) REFERENCES `multa` (`id_multa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
