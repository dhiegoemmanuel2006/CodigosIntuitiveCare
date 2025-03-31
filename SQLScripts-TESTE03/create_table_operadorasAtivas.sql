USE Teste03IntuitiveCare;

drop table if exists operadorasativas;
CREATE TABLE OperadorasAtivas (
    Registro_ANS VARCHAR(20) NOT NULL,
    CNPJ CHAR(14) NOT NULL,
    Razao_Social VARCHAR(255)  NULL,
    Nome_Fantasia VARCHAR(255) NULL, 
    Modalidade VARCHAR(50) NULL,
    Logradouro VARCHAR(255) NULL, 
    Numero VARCHAR(20) NULL, 
    Complemento VARCHAR(255) NULL,
    Bairro VARCHAR(100)  NULL,
    Cidade VARCHAR(100) NULL,
    UF CHAR(2) NULL,
    CEP CHAR(8) NULL,
    DDD CHAR(2) NULL,
    Telefone VARCHAR(15) NULL,
    Fax VARCHAR(15) NULL, 
    Endereco_Eletronico VARCHAR(100) NULL,
    Representante VARCHAR(100) NULL,
    Cargo_Representante VARCHAR(100) NULL,
    Regiao_de_Comercializacao VARCHAR(2) NULL,
    Data_Registro_ANS DATE NOT NULL,
    PRIMARY KEY (CNPJ, Registro_ANS),
    INDEX idx_razao_social (Razao_Social),
    INDEX idx_uf_cidade (UF, Cidade),
    INDEX idx_nome_fantasia(Nome_Fantasia),
    INDEX idx_fulltext_razao_nome (Razao_Social, Nome_Fantasia)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

    