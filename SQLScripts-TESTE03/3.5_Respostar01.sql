USE Teste03IntuitiveCare;

SELECT 
    oa.Registro_ANS,
    oa.Razao_Social,
    oa.Nome_Fantasia,
    oa.Modalidade,
    oa.UF,
    SUM(do.VL_SALDO_FINAL - do.VL_SALDO_INICIAL) AS Total_Despesas,
    COUNT(*) AS Quantidade_Sinistros,
    ROUND(SUM(do.VL_SALDO_FINAL - do.VL_SALDO_INICIAL) / 3, 2) AS Media_Mensal,
    MIN(do.Dia) AS Primeira_Ocorrencia,
    MAX(do.Dia) AS Ultima_Ocorrencia
FROM 
    DespesasOperadoras do
INNER JOIN 
    OperadorasAtivas oa ON do.REG_ANS = oa.Registro_ANS
WHERE 
    do.DESCRICAO = 'EVENTOS/ SINISTROS CONHECIDOS OU AVISADOS DE ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR'
    AND do.Dia BETWEEN '2024-10-01' AND '2024-12-31'
GROUP BY 
    oa.Registro_ANS, oa.Razao_Social, oa.Nome_Fantasia, oa.Modalidade, oa.UF
ORDER BY 
    Total_Despesas DESC
LIMIT 10;