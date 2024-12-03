CREATE DATABASE RecruitmentDB;

CREATE TABLE ExamResults (
    id INT AUTO_INCREMENT PRIMARY KEY,
    candidate_name VARCHAR(100),
    score INT,
    is_selected BOOLEAN
);