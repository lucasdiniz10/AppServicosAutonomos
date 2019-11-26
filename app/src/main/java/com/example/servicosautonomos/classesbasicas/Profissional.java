package com.example.servicosautonomos.classesbasicas;

import android.os.Parcel;
import android.os.Parcelable;

public class Profissional implements Parcelable {
    public String nome;
    public String telefone ;
    public String cpf;
    public String dataNasc;
    public String email;
    public String senha;
    public String descricao;
    public String categoria;
    public Double latitude;
    public Double longitude;
    public boolean dinheiro;
    public boolean cartaoDebito;
    public boolean cartaoCredito;


    private Profissional(Parcel p){
         nome = p.readString();
         telefone = p.readString() ;
         cpf = p.readString();
         dataNasc = p.readString();
         email = p.readString();
         senha = p.readString();
         descricao = p.readString();
         categoria = p.readString();
         latitude = p.readDouble();
         longitude = p.readDouble();
         dinheiro = (p.readInt() == 0) ? false : true;
         cartaoDebito = (p.readInt() == 0) ? false : true;
         cartaoCredito = (p.readInt() == 0) ? false : true;

    }

    public static final Parcelable.Creator<Profissional>
            CREATOR = new Parcelable.Creator<Profissional>(){

        public Profissional createFromParcel(Parcel in){
            return  new Profissional(in);
        }

        public Profissional[] newArray(int size){
            return new Profissional[size];
        }
    };

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

    public boolean isDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(boolean dinheiro) {
        this.dinheiro = dinheiro;
    }

    public boolean isCartaoDebito() {
        return cartaoDebito;
    }

    public void setCartaoDebito(boolean cartaoDebito) {
        this.cartaoDebito = cartaoDebito;
    }

    public boolean isCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(boolean cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeString(telefone);
        parcel.writeString(cpf);
        parcel.writeString(dataNasc);
        parcel.writeString(email);
        parcel.writeString(senha);
        parcel.writeString(descricao);
        parcel.writeString(categoria);
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
        parcel.writeInt(dinheiro ? 1 : 0);
        parcel.writeInt(cartaoDebito ? 1 : 0);
        parcel.writeInt(cartaoCredito ? 1 : 0);
    }
}
