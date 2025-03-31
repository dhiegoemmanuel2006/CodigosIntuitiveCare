use Teste03IntuitiveCare;

drop table if exists despesasoperadoras;
CREATE TABLE DespesasOperadoras(
	Dia DATE not null,
    REG_ANS char(9) not null,
    CD_CONTA_CONTABIL varchar(20) null,
    DESCRICAO varchar(200) null,
    VL_SALDO_INICIAL DECIMAL(15, 4) null,
    VL_SALDO_FINAL DECIMAL(15, 4) null,
    INDEX dia_ocorrido (dia) COMMENT 'Melhora a busca pelo dia',
    INDEX reg_ans(REG_ANS) COMMENT 'Melhora a busca pelo Registro da ANS'
)ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;