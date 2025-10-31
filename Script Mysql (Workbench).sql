-- DBMS: MySQL

CREATE DATABASE IF NOT EXISTS prueba_luis_serfinsa;
USE prueba_luis_serfinsa;

CREATE TABLE merchants (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255)
);
INSERT INTO merchants (name, address) VALUES
('Comercio 1', 'Av. Las Palmas #123, San Salvador'),
('Comercio 2', 'Calle El Mirador #456, Santa Tecla'),
('Comercio 3', 'Boulevard Constitución #789, Mejicanos');

CREATE TABLE customers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(20)
);
INSERT INTO customers (name, email, phone) VALUES
('Luis Henriquez', 'luis.he@example.com', '6065-3681'),
('Carlos Méndez', 'carlos.mendez@example.com', '7890-1234'),
('Sofía Ramírez', 'sofia.ramirez@example.com', '7654-3210'),
('Diego Torres', 'diego.torres@example.com', '7123-4567'),
('María Gómez', 'maria.gomez@example.com', '7987-6543');


CREATE TABLE purchases (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    merchant_id BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,
    purchase_date DATE NOT NULL,
    payment_method ENUM('CASH', 'CARD') NOT NULL,
    location VARCHAR(255),
    total_amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (merchant_id) REFERENCES merchants(id),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);
INSERT INTO purchases (merchant_id, customer_id, purchase_date, payment_method, location, total_amount) VALUES
(1, 1, '2025-10-15', 'CARD', 'Sucursal San Salvador', 249.99),
(2, 2, '2025-10-20', 'CASH', 'Sucursal Santa Tecla', 89.50),
(3, 3, '2025-10-25', 'CARD', 'Sucursal Mejicanos', 399.00),
(1, 2, '2025-10-28', 'CARD', 'Sucursal San Salvador', 120.75),
(2, 4, '2025-10-29', 'CARD', 'Sucursal Santa Tecla', 199.99),
(3, 5, '2025-10-30', 'CASH', 'Sucursal Mejicanos', 59.90),
(1, 3, '2025-10-30', 'CARD', 'Sucursal San Salvador', 349.00),
(2, 1, '2025-10-30', 'CARD', 'Sucursal Santa Tecla', 89.99),
(3, 2, '2025-10-30', 'CASH', 'Sucursal Mejicanos', 45.00),
(1, 4, '2025-10-30', 'CARD', 'Sucursal San Salvador', 129.50),
(2, 5, '2025-10-30', 'CASH', 'Sucursal Santa Tecla', 499.99),
(3, 1, '2025-10-30', 'CARD', 'Sucursal Mejicanos', 75.25),
(1, 2, '2025-10-30', 'CASH', 'Sucursal San Salvador', 60.00),
(2, 3, '2025-10-30', 'CARD', 'Sucursal Santa Tecla', 110.10),
(3, 4, '2025-10-30', 'CASH', 'Sucursal Mejicanos', 399.99),
(1, 5, '2025-10-30', 'CARD', 'Sucursal San Salvador', 220.00),
(2, 2, '2025-10-30', 'CASH', 'Sucursal Santa Tecla', 35.75),
(3, 3, '2025-10-30', 'CARD', 'Sucursal Mejicanos', 89.00),
(1, 1, '2025-10-30', 'CASH', 'Sucursal San Salvador', 310.00),
(2, 5, '2025-10-30', 'CARD', 'Sucursal Santa Tecla', 150.00);
