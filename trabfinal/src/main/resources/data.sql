DROP TABLE IF EXISTS subscriptions;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS apps;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE apps (
    code BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    month_cost DECIMAL(10, 2) NOT NULL
);

CREATE TABLE customers (
    code BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);


CREATE TABLE subscriptions (
    code BIGINT PRIMARY KEY,
    application_code BIGINT NOT NULL,
    customer_code BIGINT NOT NULL,
    begin_contract_period DATE NOT NULL,
    end_contract_period DATE NOT NULL,
    FOREIGN KEY (application_code) REFERENCES Apps(code),
    FOREIGN KEY (customer_code) REFERENCES Customers(code)
);

CREATE TABLE payments(
    code BIGINT PRIMARY KEY,
    subscription_code BIGINT NOT NULL,
    amount_paid DECIMAL(10, 2) NOT NULL,
    date DATE NOT NULL,
    sale VARCHAR(255) NOT NULL,
    FOREIGN KEY (subscription_code) REFERENCES Subscriptions(code)
);


INSERT INTO customers (code, name, email) VALUES
(1, 'João Silva', 'joao.silva@example.com'),
(2, 'Maria Oliveira', 'maria.oliveira@example.com'),
(3, 'Carlos Souza', 'carlos.souza@example.com'),
(4, 'Ana Pereira', 'ana.pereira@example.com'),
(5, 'Pedro Lima', 'pedro.lima@example.com'),
(6, 'Fernanda Costa', 'fernanda.costa@example.com'),
(7, 'Lucas Almeida', 'lucas.almeida@example.com'),
(8, 'Juliana Santos', 'juliana.santos@example.com'),
(9, 'Rafael Rodrigues', 'rafael.rodrigues@example.com'),
(10, 'Patrícia Fernandes', 'patricia.fernandes@example.com');

INSERT INTO apps (code, name, month_cost) VALUES
(1, 'Netflix', 29.90),
(2, 'Amazon Prime Video', 19.90),
(3, 'Disney+', 27.90),
(4, 'HBO Max', 34.90),
(5, 'Apple TV+', 14.90);


INSERT INTO subscriptions (code, application_code, customer_code, begin_contract_period, end_contract_period) VALUES
(1, 1, 1, '2024-10-15', '2024-11-15'), -- João Silva assina Netflix
(2, 3, 1, '2024-10-15', '2024-11-15'), -- João Silva assina Disney+
(3, 2, 2, '2024-10-15', '2024-11-15'), -- Maria Oliveira assina Amazon Prime Video
(4, 4, 3, '2024-10-15', '2024-11-15'), -- Carlos Souza assina HBO Max
(5, 1, 4, '2024-10-15', '2024-11-15'), -- Ana Pereira assina Netflix
(6, 5, 5, '2024-10-15', '2024-11-15'), -- Pedro Lima assina Apple TV+
(7, 2, 5, '2024-10-15', '2024-11-15'), -- Pedro Lima assina Amazon Prime Video
(8, 3, 7, '2024-10-15', '2024-11-15'), -- Lucas Almeida assina Disney+
(9, 4, 8, '2024-10-15', '2024-11-15'), -- Juliana Santos assina HBO Max
(10, 1, 9, '2024-10-15', '2024-11-15'); -- Rafael Rodrigues assina Netflix