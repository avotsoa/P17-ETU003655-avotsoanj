CREATE DATABASE Credit;
USE Credit;


CREATE TABLE Credit (
    id_credit INT PRIMARY KEY AUTO_INCREMENT,
    libele VARCHAR(100) NOT NULL,
    montant DOUBLE NOT NULL CHECK (montant >= 0)
);

CREATE TABLE Depense (
    id_depense INT PRIMARY KEY AUTO_INCREMENT,
    id_credit INT NOT NULL,
    libele VARCHAR(100) NOT NULL,
    montant DOUBLE NOT NULL CHECK (montant >= 0),
    FOREIGN KEY (id_credit) REFERENCES Credit(id_credit) ON DELETE CASCADE
);