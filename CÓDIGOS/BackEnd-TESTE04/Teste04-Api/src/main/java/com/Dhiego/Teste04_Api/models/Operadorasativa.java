package com.Dhiego.Teste04_Api.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "operadorasativas")
public class Operadorasativa {
    @EmbeddedId
    private OperadorasativaId id;

    @Column(name = "Razao_Social")
    private String razaoSocial;

    @Column(name = "Nome_Fantasia")
    private String nomeFantasia;

    @Column(name = "Modalidade", length = 50)
    private String modalidade;

    @Column(name = "Logradouro")
    private String logradouro;

    @Column(name = "Numero", length = 20)
    private String numero;

    @Column(name = "Complemento")
    private String complemento;

    @Column(name = "Bairro", length = 100)
    private String bairro;

    @Column(name = "Cidade", length = 100)
    private String cidade;

    @Column(name = "UF", length = 2)
    private String uf;

    @Column(name = "CEP", length = 8)
    private String cep;

    @Column(name = "DDD", length = 2)
    private String ddd;

    @Column(name = "Telefone", length = 15)
    private String telefone;

    @Column(name = "Fax", length = 15)
    private String fax;

    @Column(name = "Endereco_Eletronico", length = 100)
    private String enderecoEletronico;

    @Column(name = "Representante", length = 100)
    private String representante;

    @Column(name = "Cargo_Representante", length = 100)
    private String cargoRepresentante;

    @Column(name = "Regiao_de_Comercializacao", length = 2)
    private String regiaoDeComercializacao;

    @Column(name = "Data_Registro_ANS", nullable = false)
    private LocalDate dataRegistroAns;

    public OperadorasativaId getId() {
        return id;
    }

    public void setId(OperadorasativaId id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEnderecoEletronico() {
        return enderecoEletronico;
    }

    public void setEnderecoEletronico(String enderecoEletronico) {
        this.enderecoEletronico = enderecoEletronico;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getCargoRepresentante() {
        return cargoRepresentante;
    }

    public void setCargoRepresentante(String cargoRepresentante) {
        this.cargoRepresentante = cargoRepresentante;
    }

    public String getRegiaoDeComercializacao() {
        return regiaoDeComercializacao;
    }

    public void setRegiaoDeComercializacao(String regiaoDeComercializacao) {
        this.regiaoDeComercializacao = regiaoDeComercializacao;
    }

    public LocalDate getDataRegistroAns() {
        return dataRegistroAns;
    }

    public void setDataRegistroAns(LocalDate dataRegistroAns) {
        this.dataRegistroAns = dataRegistroAns;
    }
    public String getCnpj() {
        return id != null ? id.getCnpj() : null;
    }

    public String getRegistroAns() {
        return id != null ? id.getRegistroAns() : null;
    }
}