USE Teste03IntuitiveCare;

SELECT 
    oa.Registro_ANS,
    oa.Razao_Social,
    oa.Nome_Fantasia,
    oa.Modalidade,
    oa.UF,
    SUM(do.VL_SALDO_FINAL - do.VL_SALDO_INICIAL) AS Total_Despesas_2024,
    COUNT(*) AS Quantidade_Sinistros,
    ROUND(SUM(do.VL_SALDO_FINAL - do.VL_SALDO_INICIAL) / 12, 2) AS Media_Mensal,
    MIN(do.Dia) AS Primeira_Ocorrencia,
    MAX(do.Dia) AS Ultima_Ocorrencia,
    ROUND(SUM(CASE WHEN MONTH(do.Dia) BETWEEN 10 AND 12 THEN do.VL_SALDO_FINAL - do.VL_SALDO_INICIAL ELSE 0 END) / 
    NULLIF(SUM(CASE WHEN MONTH(do.Dia) BETWEEN 1 AND 9 THEN do.VL_SALDO_FINAL - do.VL_SALDO_INICIAL ELSE 0 END), 0) * 100, 2) AS Crescimento_Ultimo_Trimestre_vs_Resto_Ano
FROM 
    DespesasOperadoras do
INNER JOIN 
    OperadorasAtivas oa ON do.REG_ANS = oa.Registro_ANS
WHERE 
    do.DESCRICAO = 'EVENTOS/ SINISTROS CONHECIDOS OU AVISADOS DE ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR'
    AND do.Dia BETWEEN '2024-01-01' AND '2024-12-31'
GROUP BY 
    oa.Registro_ANS, oa.Razao_Social, oa.Nome_Fantasia, oa.Modalidade, oa.UF
ORDER BY 
    Total_Despesas_2024 DESC
LIMIT 10;