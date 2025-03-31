USE teste03intuitivecare;
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/DespesasPorTrimestre/3T2024.csv' 
INTO TABLE DespesasOperadoras 
CHARACTER SET utf8mb4 
FIELDS TERMINATED BY ';'  
OPTIONALLY ENCLOSED BY '"' 
LINES TERMINATED BY '\r\n' 
IGNORE 1 ROWS 
(@data, REG_ANS, CD_CONTA_CONTABIL, DESCRICAO, @vl_saldo_inicial, @vl_saldo_final)
SET 
  Dia = STR_TO_DATE(@data, '%Y-%m-%d'),
  VL_SALDO_INICIAL = REPLACE(NULLIF(@vl_saldo_inicial, ''), ',', '.'),  
  VL_SALDO_FINAL = REPLACE(NULLIF(@vl_saldo_final, ''), ',', '.');      
SELECT ROW_COUNT();  