package com.example.servicosautonomos.classesbasicas;

import android.os.Parcel;
import android.os.Parcelable;

public class Contratante implements Parcelable {
    public String nome;
    public String telefone;
    public String cpf;
    public String nascimento;
    public String email;
    public String senha;

    public Contratante() {

    }

    private Contratante(Parcel p){
        nome = p.readString();
        telefone = p.readString();
        cpf = p.readString();
        nascimento = p.readString();
        email = p.readString();
        senha = p.readString();

    }

    public static final Parcelable.Creator<Contratante>
            CREATOR = new Parcelable.Creator<Contratante>(){

        public Contratante createFromParcel(Parcel in){
            return  new Contratante(in);
        }

        public Contratante[] newArray(int size){
            return new Contratante[size];
        }
    };

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

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(telefone);
        dest.writeString(cpf);
        dest.writeString(nascimento);
        dest.writeString(email);
        dest.writeString(senha);
    }
}