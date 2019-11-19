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
