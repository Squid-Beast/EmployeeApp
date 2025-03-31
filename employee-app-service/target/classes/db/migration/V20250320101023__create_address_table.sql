CREATE TABLE address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    street_address VARCHAR(255) NOT NULL,
    city VARCHAR(30) NOT NULL,
    state_province VARCHAR(20) NOT NULL,
    country VARCHAR(30) NOT NULL,
    zip_code VARCHAR(10) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);