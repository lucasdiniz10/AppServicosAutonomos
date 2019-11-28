package com.example.servicosautonomos.classesbasicas;

import android.os.Parcel;
import android.os.Parcelable;

public class ReferenciaBotao implements Parcelable {
    public boolean aparelhosEletronicos;
    public boolean eletrodomensticos;
    public boolean informaticaTelefonia;
    public boolean funilariaPintura;
    public boolean vidracariaAutomotiva;
    public boolean mecanica;
    public boolean construcao;
    public boolean servicosGerais;
    public boolean tecnologia;
    public boolean grafica;
    public boolean audioVisual;

    private ReferenciaBotao(Parcel p){

        aparelhosEletronicos = (p.readInt() == 0) ? false : true;
        eletrodomensticos = (p.readInt() == 0) ? false : true;
        informaticaTelefonia = (p.readInt() == 0) ? false : true;
        funilariaPintura = (p.readInt() == 0) ? false : true;
        vidracariaAutomotiva = (p.readInt() == 0) ? false : true;
        mecanica = (p.readInt() == 0) ? false : true;
        construcao = (p.readInt() == 0) ? false : true;
        servicosGerais = (p.readInt() == 0) ? false : true;
        tecnologia = (p.readInt() == 0) ? false : true;
        grafica = (p.readInt() == 0) ? false : true;
        audioVisual = (p.readInt() == 0) ? false : true;

    }

    public ReferenciaBotao() {
    }

    public boolean isAparelhosEletronicos() {
        return aparelhosEletronicos;
    }

    public void setAparelhosEletronicos(boolean aparelhosEletronicos) {
        this.aparelhosEletronicos = aparelhosEletronicos;
    }

    public boolean isEletrodomensticos() {
        return eletrodomensticos;
    }

    public void setEletrodomensticos(boolean eletrodomensticos) {
        this.eletrodomensticos = eletrodomensticos;
    }

    public static final Parcelable.Creator<ReferenciaBotao>
            CREATOR = new Parcelable.Creator<ReferenciaBotao>(){

        public ReferenciaBotao createFromParcel(Parcel in){
            return  new ReferenciaBotao(in);
        }

        public ReferenciaBotao[] newArray(int size){
            return new ReferenciaBotao[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(aparelhosEletronicos ? 1 : 0);
        parcel.writeInt(eletrodomensticos ? 1 : 0);
        parcel.writeInt(informaticaTelefonia ? 1 : 0);
        parcel.writeInt(funilariaPintura ? 1 : 0);
        parcel.writeInt(vidracariaAutomotiva ? 1 : 0);
        parcel.writeInt(mecanica ? 1 : 0);
        parcel.writeInt(construcao ? 1 : 0);
        parcel.writeInt(servicosGerais ? 1 : 0);
        parcel.writeInt(tecnologia ? 1 : 0);
        parcel.writeInt(grafica ? 1 : 0);
        parcel.writeInt(audioVisual ? 1 : 0);
    }
}
