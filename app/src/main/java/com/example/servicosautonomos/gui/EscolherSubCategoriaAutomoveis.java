package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;

public class EscolherSubCategoriaAutomoveis extends AppCompatActivity {

    Button button, button2, button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_sub_categoria_automoveis);

        button = (Button) findViewById(R.id.buttonEscolherSubCategoriaFunilariaePintura);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EscolherSubCategoriaAutomoveis.this, FormCadastroProfissional.class);
                startActivity(intent);
            }
        });

        button2 = (Button) findViewById(R.id.buttonEscolherSubCategoriaVidracariaAutomotiva);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EscolherSubCategoriaAutomoveis.this, FormCadastroProfissional.class);
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.buttonEscolherSubCategoriaMecanica);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EscolherSubCategoriaAutomoveis.this, FormCadastroProfissional.class);
                startActivity(intent);
            }
        });

    }
}
