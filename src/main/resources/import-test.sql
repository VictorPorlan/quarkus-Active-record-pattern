DROP TABLE IF EXISTS Espada;
CREATE TABLE Espada
(
    id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
    nombre VARCHAR (255) NOT NULL,
    longitud FLOAT NOT NULL,
    PRIMARY KEY (id)
);
INSERT INTO Espada (id, nombre, longitud) VALUES (1000, 'Dragonslayer', 200.0);
INSERT INTO Espada (id, nombre, longitud) VALUES (2000, 'Frostmourne', 100.0);