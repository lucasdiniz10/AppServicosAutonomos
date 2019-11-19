package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;

public class EscolherSubCategoriaDesignTecnologia extends AppCompatActivity {

    Button button, button2, button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_sub_categoria_design_tecnologia);

        button = (Button)findViewById(R.id.buttonEscolherSubCategoriaTecnologia);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscolherSubCategoriaDesignTecnologia.this, FormCadastroProfissional.class);
                startActivity(intent);
            }
        });

        button2 = (Button)findViewById(R.id.buttonEscolherSubCategoriaGrafica);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscolherSubCategoriaDesignTecnologia.this, FormCadastroProfissional.class);
                startActivity(intent);
            }
        });

        button3 = (Button)findViewById(R.id.buttonEscolherSubCategoriaAudioVisual);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscolherSubCategoriaDesignTecnologia.this, FormCadastroProfissional.class);
                startActivity(intent);
            }
        });
    }
}
