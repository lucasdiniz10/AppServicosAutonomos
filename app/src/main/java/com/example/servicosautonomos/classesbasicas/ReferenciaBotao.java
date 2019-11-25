package com.example.servicosautonomos.classesbasicas;

import android.os.Parcel;
import android.os.Parcelable;

public class ReferenciaBotao implements Parcelable {
    public boolean aparelhosEletronicos;
    public boolean eletrodomensticos;

    private ReferenciaBotao(Parcel p){

        aparelhosEletronicos = (p.readInt() == 0) ? false : true;
        eletrodomensticos = (p.readInt() == 0) ? false : true;

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
    }
}
