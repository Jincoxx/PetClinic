-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS clinica_veterinaria;

-- Seleccionar la base de datos
USE clinica_veterinaria;

-- Crear la tabla Veterinario
CREATE TABLE IF NOT EXISTS Veterinario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100),
    telefono VARCHAR(15),
    correo VARCHAR(100)
);

-- Crear la tabla Propietario
CREATE TABLE IF NOT EXISTS Propietario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(15),
    correo VARCHAR(100)
);

-- Crear la tabla Mascota
CREATE TABLE IF NOT EXISTS Mascota (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    especie VARCHAR(50),
    raza VARCHAR(50),
    edad INT,
    propietario_id INT,
    FOREIGN KEY (propietario_id) REFERENCES Propietario(id) ON DELETE CASCADE
);

-- Crear la tabla Cita
CREATE TABLE IF NOT EXISTS Cita (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_hora DATETIME NOT NULL,
    veterinario_id INT,
    mascota_id INT,
    motivo VARCHAR(255),
    FOREIGN KEY (veterinario_id) REFERENCES Veterinario(id) ON DELETE CASCADE,
    FOREIGN KEY (mascota_id) REFERENCES Mascota(id) ON DELETE CASCADE
);

-- Crear un índice para facilitar búsquedas en las citas por mascota
CREATE INDEX idx_mascota_id ON Cita (mascota_id);
