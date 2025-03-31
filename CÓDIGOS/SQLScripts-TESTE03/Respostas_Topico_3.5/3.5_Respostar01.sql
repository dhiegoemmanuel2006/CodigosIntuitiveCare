use teste03intuitivecare;
SELECT 
    oa.CNPJ,
    oa.Razao_Social,
    SUM(do.VL_SALDO_FINAL - do.VL_SALDO_INICIAL) AS Total_Despesas
FROM 
    DespesasOperadoras do
JOIN 
    OperadorasAtivas oa ON do.REG_ANS = oa.Registro_ANS
WHERE 
    do.Dia BETWEEN '2024-01-01' AND '2024-12-31'
GROUP BY 
    oa.CNPJ, oa.Razao_Social
ORDER BY 
    Total_Despesas DESC
LIMIT 10;