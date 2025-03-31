package com.Dhiego.Teste04_Api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;


@Embeddable
public class OperadorasativaId implements java.io.Serializable {
    private static final long serialVersionUID = -8267605700172632096L;
    @Column(name = "CNPJ", nullable = false, length = 14)
    private String cnpj;

    @Column(name = "Registro_ANS", nullable = false, length = 20)
    private String registroAns;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OperadorasativaId entity = (OperadorasativaId) o;
        return Objects.equals(this.cnpj, entity.cnpj) &&
                Objects.equals(this.registroAns, entity.registroAns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj, registroAns);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRegistroAns() {
        return registroAns;
    }

    public void setRegistroAns(String registroAns) {
        this.registroAns = registroAns;
    }
}