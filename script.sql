CREATE DATABASE db_videogames;
USE db_videogames;

-- Tabla 1: Categorías
CREATE TABLE categorias (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- Tabla 2: Videojuegos (Relacionada)
CREATE TABLE videojuegos (
    id_juego INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2),
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
);

-- Datos iniciales para pruebas
INSERT INTO categorias (nombre) VALUES ('Acción'), ('RPG'), ('Aventura');
INSERT INTO videojuegos (titulo, precio, id_categoria) VALUES ('Elden Ring', 59.99, 2), ('God of War', 39.99, 1);