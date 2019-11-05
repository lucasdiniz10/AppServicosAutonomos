package com.example.servicosautonomos.gui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.servicosautonomos.R;

public class Escolha extends AppCompatActivity {
    Button button;
    Button button2;
    Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha);

        button = (Button)findViewById(R.id.buttonContratarProfissional);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Escolha.this, FormCadastroContratante.class);
                startActivity(intent);
            }
        });

        button2 = (Button)findViewById(R.id.buttonCadastrarServico);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Escolha.this, EscolherCategoria.class);
                startActivity(intent);
            }
        });

        button3 = (Button)findViewById(R.id.buttonJaCadastrado);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Escolha.this, FormJaCadastrado.class);
                startActivity(intent);
            }
        });
    }
}
