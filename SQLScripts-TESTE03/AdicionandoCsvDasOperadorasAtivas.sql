LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Relatorio_cadop.csv'
INTO TABLE OperadorasAtivas
CHARACTER SET utf8mb4
FIELDS TERMINATED BY ';' 
OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES
(
    Registro_ANS, CNPJ, Razao_Social, Nome_Fantasia, Modalidade, 
    Logradouro, Numero, Complemento, Bairro, Cidade, UF, CEP, DDD, 
    Telefone, Fax, Endereco_Eletronico, Representante, Cargo_Representante,
    @Regiao_de_Comercializacao, @Data_Registro_ANS
)
SET 
    Regiao_de_Comercializacao = NULLIF(@Regiao_de_Comercializacao, ''),
    Data_Registro_ANS = STR_TO_DATE(@Data_Registro_ANS, '%Y-%m-%d');