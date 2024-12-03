CREATE DATABASE CertificationDB;

CREATE TABLE Candidates (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    score INT,
    rank INT
);