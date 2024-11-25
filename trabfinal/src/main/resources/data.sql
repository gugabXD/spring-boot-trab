INSERT INTO
    customers (code, name, email)
VALUES
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

INSERT INTO
    apps (code, name, month_cost)
VALUES
    (1, 'Netflix', 29.90),
    (2, 'Amazon Prime Video', 19.90),
    (3, 'Disney+', 27.90),
    (4, 'HBO Max', 34.90),
    (5, 'Apple TV+', 14.90);

INSERT INTO
    subscriptions (
        code,
        application_code,
        customer_code,
        begin_contract_period,
        end_contract_period
    )
VALUES
    (1, 1, 1, '2024-10-15', '2024-11-15'),
    (2, 3, 1, '2024-10-15', '2024-11-15'),
    (3, 2, 2, '2024-10-15', '2024-11-15'),
    (4, 4, 3, '2024-10-15', '2024-11-15'),
    (5, 1, 4, '2024-10-15', '2024-11-15'),
    (6, 5, 5, '2024-10-15', '2024-11-15'),
    (7, 2, 5, '2024-10-15', '2024-11-15'),
    (8, 3, 7, '2024-10-15', '2024-11-15'),
    (9, 4, 8, '2024-10-15', '2024-11-15'),
    (10, 1, 9, '2024-10-15', '2024-11-15');

INSERT INTO
    "user" (user_name, password)
VALUES
    ('admin', 'admin');
