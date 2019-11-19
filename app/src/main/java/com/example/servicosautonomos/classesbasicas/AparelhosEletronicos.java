package com.example.servicosautonomos.classesbasicas;

import android.os.Parcel;
import android.os.Parcelable;

public class AparelhosEletronicos implements Parcelable {
    public int condicao;
    public Double latitude;
    public Double longitude;

    private AparelhosEletronicos(Parcel p){
        condicao = p.readInt();
        latitude = p.readDouble();
        longitude = p.readDouble();
    }

    public static final Parcelable.Creator<AparelhosEletronicos>
            CREATOR = new Parcelable.Creator<AparelhosEletronicos>(){

        public AparelhosEletronicos createFromParcel(Parcel in){
            return  new AparelhosEletronicos(in);
        }

        public AparelhosEletronicos[] newArray(int size){
            return new AparelhosEletronicos[size];
        }
    };

    public AparelhosEletronicos() {
    }

    public int getCondicao() {
        return condicao;
    }

    public void setCondicao(int condicao) {
        this.condicao = condicao;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(condicao);
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
    }
}
