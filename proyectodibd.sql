CREATE database IF NOT exists proyectodibd;
use proyectodibd;
-- Crear base de datos

-- Tabla de clientes
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    fecha_registro DATE
);

-- Tabla de productos
CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    precio DECIMAL(10,2),
    stock INT
);

-- Tabla de pedidos
CREATE TABLE pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    fecha DATE,
    total DECIMAL(10,2),
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);
//-------------------------------------------------
-- Insertar clientes
INSERT INTO clientes (nombre, email, fecha_registro) VALUES
('Ana López', 'ana.lopez@example.com', '2025-01-10'),
('Carlos Ruiz', 'carlos.ruiz@example.com', '2025-01-12'),
('María Torres', 'maria.torres@example.com', '2025-01-15');

-- Insertar productos
INSERT INTO productos (nombre, precio, stock) VALUES
('Teclado Mecánico', 59.99, 20),
('Ratón Inalámbrico', 24.50, 35),
('Monitor 24 pulgadas', 149.90, 10);

-- Insertar pedidos
INSERT INTO pedidos (cliente_id, fecha, total) VALUES
(1, '2025-01-20', 59.99),
(2, '2025-01-21', 174.40),
(3, '2025-01-22', 24.50);
