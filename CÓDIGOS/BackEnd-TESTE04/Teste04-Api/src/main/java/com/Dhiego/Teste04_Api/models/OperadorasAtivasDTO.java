package com.Dhiego.Teste04_Api.models;


public class OperadorasAtivasDTO {
    private String nome;
    private String registroANS;
    private String cnpj;
    private String cidade;
    private String UF;

    public OperadorasAtivasDTO(Operadorasativa oa) {
        this.nome = oa.getRazaoSocial();
        this.cnpj = String.valueOf(oa.getCnpj());
        this.registroANS = String.valueOf(oa.getRegistroAns());
        this.cidade = oa.getCidade();
        this.UF = oa.getUf();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getRegistroANS() {
        return registroANS;
    }

    public void setRegistroANS(String registroANS) {
        this.registroANS = registroANS;
    }
}
