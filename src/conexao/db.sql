CREATE TABLE usuario (
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR,
    email VARCHAR,
    senha VARCHAR,
    administrador BOOLEAN
);

CREATE TABLE fornecedor (
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR,
    telefone VARCHAR,
    cnpj VARCHAR,
    rua VARCHAR,
    bairro VARCHAR,
    cep VARCHAR
);

INSERT INTO usuario(nome, email, senha, administrador) VALUES
  ('Um', 'a@b.c', '321', true);

INSERT INTO fornecedor(nome, telefone, cnpj, rua, bairro, cep) VALUES
  ('Dois', '123', '321', 'Qualquer', 'Centrão', '8');