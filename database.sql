CREATE DATABASE projeto5telas;

-- Depois de criar o banco, conecte-se a ele e execute:

CREATE TABLE IF NOT EXISTS usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(120) UNIQUE NOT NULL,
    senha VARCHAR(120) NOT NULL
);

CREATE TABLE IF NOT EXISTS produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT NOT NULL,
    preco NUMERIC(10,2) NOT NULL
);

INSERT INTO produtos (nome, descricao, preco) VALUES
('Notebook Pro', 'Notebook para estudos, programação e trabalho.', 3499.90),
('Teclado Mecânico', 'Teclado mecânico compacto para produtividade.', 299.90),
('Mouse Gamer', 'Mouse com sensor de alta precisão.', 179.90),
('Monitor 24"', 'Monitor Full HD de 24 polegadas.', 899.90),
('Headset', 'Headset com microfone para aulas e reuniões.', 249.90)
ON CONFLICT DO NOTHING;
