package com.example.servicosautonomos.gui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.ReferenciaBotao;

public class ListaDeServicos extends AppCompatActivity {

    Button button, buttonEletrodomestico, botaoTelefonia, botaoFunilaria, botaoVidracaria, botaoMecanica, botaoConstrucao, botaoServicosGerais, botaoTecnologia, botaoGrafica, botaoAudioVisual;
    private boolean mLocationPermissionsGranted = false;
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final String TAG = "MapsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_servicos);

        geoLocationPermission();

        button = findViewById(R.id.aparelhosEletronic);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReferenciaBotao referenciaBotao = new ReferenciaBotao();

                referenciaBotao.aparelhosEletronicos = true;
                referenciaBotao.eletrodomensticos = false;
                referenciaBotao.informaticaTelefonia = false;
                referenciaBotao.funilariaPintura = false;
                referenciaBotao.construcao = false;
                referenciaBotao.servicosGerais = false;
                referenciaBotao.tecnologia = false;
                referenciaBotao.grafica = false;
                referenciaBotao.audioVisual = false;

                Intent intent = new Intent(ListaDeServicos.this, MapsActivity.class);
                intent.putExtra("Referencia", referenciaBotao);
                startActivity(intent);
            }
        });

        buttonEletrodomestico = findViewById(R.id.buttonEletroDomesticos);

        buttonEletrodomestico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReferenciaBotao referenciaBotao = new ReferenciaBotao();

                referenciaBotao.aparelhosEletronicos = false;
                referenciaBotao.eletrodomensticos = true;
                referenciaBotao.informaticaTelefonia = false;
                referenciaBotao.funilariaPintura = false;
                referenciaBotao.construcao = false;
                referenciaBotao.servicosGerais = false;
                referenciaBotao.tecnologia = false;
                referenciaBotao.grafica = false;
                referenciaBotao.audioVisual = false;

                Intent intent = new Intent(ListaDeServicos.this, MapsActivity.class);
                intent.putExtra("Referencia", referenciaBotao);
                startActivity(intent);
            }
        });

        botaoTelefonia = findViewById(R.id.buttonInformaticaeTecnologia);

        botaoTelefonia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReferenciaBotao referenciaBotao = new ReferenciaBotao();

                referenciaBotao.aparelhosEletronicos = false;
                referenciaBotao.eletrodomensticos = false;
                referenciaBotao.informaticaTelefonia = true;
                referenciaBotao.funilariaPintura = false;
                referenciaBotao.construcao = false;
                referenciaBotao.servicosGerais = false;
                referenciaBotao.tecnologia = false;
                referenciaBotao.grafica = false;
                referenciaBotao.audioVisual = false;

                Intent intent = new Intent(ListaDeServicos.this, MapsActivity.class);
                intent.putExtra("Referencia", referenciaBotao);
                startActivity(intent);
            }
        });

        botaoFunilaria = findViewById(R.id.buttonFunilariaePintura);

        botaoFunilaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReferenciaBotao referenciaBotao = new ReferenciaBotao();

                referenciaBotao.aparelhosEletronicos = false;
                referenciaBotao.eletrodomensticos = false;
                referenciaBotao.informaticaTelefonia = false;
                referenciaBotao.funilariaPintura = true;
                referenciaBotao.construcao = false;
                referenciaBotao.servicosGerais = false;
                referenciaBotao.tecnologia = false;
                referenciaBotao.grafica = false;
                referenciaBotao.audioVisual = false;

                Intent intent = new Intent(ListaDeServicos.this, MapsActivity.class);
                intent.putExtra("Referencia", referenciaBotao);
                startActivity(intent);
            }
        });

        botaoConstrucao = findViewById(R.id.buttonFunilariaePintura);

        botaoConstrucao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReferenciaBotao referenciaBotao = new ReferenciaBotao();

                referenciaBotao.aparelhosEletronicos = false;
                referenciaBotao.eletrodomensticos = false;
                referenciaBotao.informaticaTelefonia = false;
                referenciaBotao.funilariaPintura = false;
                referenciaBotao.construcao = true;
                referenciaBotao.servicosGerais = false;
                referenciaBotao.tecnologia = false;
                referenciaBotao.grafica = false;
                referenciaBotao.audioVisual = false;

                Intent intent = new Intent(ListaDeServicos.this, MapsActivity.class);
                intent.putExtra("Referencia", referenciaBotao);
                startActivity(intent);
            }
        });

        botaoServicosGerais = findViewById(R.id.buttonFunilariaePintura);

        botaoServicosGerais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReferenciaBotao referenciaBotao = new ReferenciaBotao();

                referenciaBotao.aparelhosEletronicos = false;
                referenciaBotao.eletrodomensticos = false;
                referenciaBotao.informaticaTelefonia = false;
                referenciaBotao.funilariaPintura = false;
                referenciaBotao.construcao = false;
                referenciaBotao.servicosGerais = true;
                referenciaBotao.tecnologia = false;
                referenciaBotao.grafica = false;
                referenciaBotao.audioVisual = false;

                Intent intent = new Intent(ListaDeServicos.this, MapsActivity.class);
                intent.putExtra("Referencia", referenciaBotao);
                startActivity(intent);
            }
        });

        botaoTecnologia = findViewById(R.id.buttonFunilariaePintura);

        botaoTecnologia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReferenciaBotao referenciaBotao = new ReferenciaBotao();

                referenciaBotao.aparelhosEletronicos = false;
                referenciaBotao.eletrodomensticos = false;
                referenciaBotao.informaticaTelefonia = false;
                referenciaBotao.funilariaPintura = false;
                referenciaBotao.construcao = false;
                referenciaBotao.servicosGerais = false;
                referenciaBotao.tecnologia = true;
                referenciaBotao.grafica = false;
                referenciaBotao.audioVisual = false;

                Intent intent = new Intent(ListaDeServicos.this, MapsActivity.class);
                intent.putExtra("Referencia", referenciaBotao);
                startActivity(intent);
            }
        });

        botaoGrafica = findViewById(R.id.buttonFunilariaePintura);

        botaoGrafica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReferenciaBotao referenciaBotao = new ReferenciaBotao();

                referenciaBotao.aparelhosEletronicos = false;
                referenciaBotao.eletrodomensticos = false;
                referenciaBotao.informaticaTelefonia = false;
                referenciaBotao.funilariaPintura = false;
                referenciaBotao.construcao = false;
                referenciaBotao.servicosGerais = false;
                referenciaBotao.tecnologia = false;
                referenciaBotao.grafica = true;
                referenciaBotao.audioVisual = false;

                Intent intent = new Intent(ListaDeServicos.this, MapsActivity.class);
                intent.putExtra("Referencia", referenciaBotao);
                startActivity(intent);
            }
        });

        botaoAudioVisual = findViewById(R.id.buttonFunilariaePintura);

        botaoAudioVisual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReferenciaBotao referenciaBotao = new ReferenciaBotao();

                referenciaBotao.aparelhosEletronicos = false;
                referenciaBotao.eletrodomensticos = false;
                referenciaBotao.informaticaTelefonia = false;
                referenciaBotao.funilariaPintura = false;
                referenciaBotao.construcao = false;
                referenciaBotao.servicosGerais = false;
                referenciaBotao.tecnologia = false;
                referenciaBotao.grafica = false;
                referenciaBotao.audioVisual = true;

                Intent intent = new Intent(ListaDeServicos.this, MapsActivity.class);
                intent.putExtra("Referencia", referenciaBotao);
                startActivity(intent);
            }
        });

    }



    private void geoLocationPermission(){
        Log.d(TAG, "getLocationPermission: getting location permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mLocationPermissionsGranted = true;
            }else{
                ActivityCompat.requestPermissions(this,
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        }else{
            ActivityCompat.requestPermissions(this,
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: called.");
        mLocationPermissionsGranted = false;

        switch(requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                if(grantResults.length > 0){
                    for(int i = 0; i < grantResults.length; i++){
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                            mLocationPermissionsGranted = false;
                            Log.d(TAG, "onRequestPermissionsResult: permission failed");
                            return;
                        }
                    }
                    Log.d(TAG, "onRequestPermissionsResult: permission granted");
                    mLocationPermissionsGranted = true;
                }
            }
        }
    }


}
