CREATE DATABASE ReviewsDB;

CREATE TABLE Reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    review_text TEXT,
    review_type ENUM('positive', 'negative')
);