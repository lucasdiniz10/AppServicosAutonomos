package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;

public class EscolherCategoria extends AppCompatActivity {

    Button button, button2, button3, button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_categoria);

        //Botões para acessar as subcategorias

        button = findViewById(R.id.buttonEscolherCategoriaAssistenciaTecnica);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscolherCategoria.this, EscolherSubCategoriaAssistenciaTecnica.class);
                startActivity(intent);
            }
        });

        button2 = findViewById(R.id.buttonEscolherCategoriaAutomoveis);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EscolherCategoria.this, EscolherSubCategoriaAutomoveis.class);
                startActivity(intent);
            }
        });

        button3 = findViewById(R.id.buttonEscolherCategoriaReformaseReparos);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EscolherCategoria.this, EscolherSubCategoriaReformasReparos.class);
                startActivity(intent);
            }
        });

        button4 = findViewById(R.id.buttonEscolherCategoriaDesigneTecnologia);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EscolherCategoria.this, EscolherSubCategoriaDesignTecnologia.class);
                startActivity(intent);
            }
        });
    }
}
