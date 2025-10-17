CREATE DATABASE IF NOT EXISTS controle_pendencias;

USE controle_pendencias;

CREATE TABLE IF NOT EXISTS pendencias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    data_criacao DATE NOT NULL,
    data_conclusao DATE,
    status VARCHAR(50) NOT NULL,
    prioridade VARCHAR(50) NOT NULL
);

INSERT INTO pendencias (descricao, data_criacao, status, prioridade) VALUES
('Preparar apresentação de POO', '2025-10-10', 'Pendente', 'Alta'),
('Estudar para prova de Engenharia de Software', '2025-10-05', 'Em Andamento', 'Média'),
('Comprar livros para o próximo semestre', '2025-09-20', 'Concluída', 'Baixa');

SELECT * FROM pendencias;

