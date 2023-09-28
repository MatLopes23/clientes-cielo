DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS pessoa_fisica;
DROP TABLE IF EXISTS pessoa_juridica;

CREATE TABLE cliente (
                  id INT AUTO_INCREMENT PRIMARY KEY,
                  tipo_cliente ENUM('PESSOA_FISICA', 'PESSOA_JURIDICA') NOT NULL,
                  data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                  data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                  mcc VARCHAR(4),
                  email_contato VARCHAR(255) NOT NULL
);

CREATE TABLE pessoa_fisica (
                  id INT PRIMARY KEY,
                  cpf CHAR(11) NOT NULL,
                  nome VARCHAR(50) NOT NULL,
                  FOREIGN KEY (id) REFERENCES cliente(id)
);

CREATE TABLE pessoa_juridica (
                  id INT PRIMARY KEY,
                  cnpj CHAR(14) NOT NULL,
                  razao_social VARCHAR(50) NOT NULL,
                  cpf_contato CHAR(11) NOT NULL,
                  nome_contato VARCHAR(50) NOT NULL,
                  FOREIGN KEY (id) REFERENCES cliente(id)
);
