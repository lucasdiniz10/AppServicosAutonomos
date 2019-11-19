package com.example.servicosautonomos.classesbasicas;

public class Profissional {
    public String nome;
    public String telefone ;
    public String cpf;
    public String dataNasc;
    public String email;
    public String senha;
    public String descricao;
    public Boolean dinheiro;
    public Boolean cartaoDebito;
    public Boolean cartaoCredito;
    public String endereco;

    public Profissional() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Boolean dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Boolean getCartaoDebito() {
        return cartaoDebito;
    }

    public void setCartaoDebito(Boolean cartaoDebito) {
        this.cartaoDebito = cartaoDebito;
    }

    public Boolean getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(Boolean cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
