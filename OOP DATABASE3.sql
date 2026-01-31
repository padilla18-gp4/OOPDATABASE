-- Inventory System Database
CREATE DATABASE IF NOT EXISTS inventory_system;
USE inventory_system;

-- USERS TABLE
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('admin','staff') NOT NULL
);

-- PRODUCTS TABLE
CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL
);

-- SALES TABLE
CREATE TABLE sales (
    sale_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    sale_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- RESTOCKS TABLE
CREATE TABLE restocks (
    restock_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    restock_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- SAMPLE USERS
INSERT INTO users (username, password, role) VALUES
('admin1', 'admin123', 'admin'),
('staff1', 'staff123', 'staff');

-- SAMPLE PRODUCTS
INSERT INTO products (product_name, price, stock) VALUES
('Notebook', 45.00, 100),
('Ballpen', 10.00, 200),
('Pencil', 8.00, 150);

-- SAMPLE SALES
INSERT INTO sales (product_id, quantity)
VALUES (1, 5);

-- SAMPLE RESTOCKS
UPDATE products
SET stock = stock - 5
WHERE product_id = 1;


INSERT INTO restocks (product_id, quantity)
VALUES (2, 20);

UPDATE products
SET stock = stock + 20
WHERE product_id = 2;

-- View products
SELECT * FROM products;

-- View sales records
SELECT p.product_name, s.quantity, s.sale_date
FROM sales s
JOIN products p ON s.product_id = p.product_id;

-- View restock records
SELECT p.product_name, r.quantity, r.restock_date
FROM restocks r
JOIN products p ON r.product_id = p.product_id;

