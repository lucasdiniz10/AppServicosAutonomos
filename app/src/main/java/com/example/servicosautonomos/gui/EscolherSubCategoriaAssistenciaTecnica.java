package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.AparelhosEletronicos;

public class EscolherSubCategoriaAssistenciaTecnica extends AppCompatActivity {

    Button button,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_sub_categoria_assistencia_tecnica);

        button = (Button)findViewById(R.id.buttonEscolherSubCategoriaDescricaoAparelhosEletronicos);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AparelhosEletronicos aparelhosEletronicos = new AparelhosEletronicos();
                aparelhosEletronicos.condicao = 1;
                aparelhosEletronicos.latitude = Double.valueOf(0);
                aparelhosEletronicos.longitude = Double.valueOf(0);

                Intent intent = new Intent(EscolherSubCategoriaAssistenciaTecnica.this, FormCadastroProfissional.class);
                intent.putExtra("condiçao da classe", aparelhosEletronicos);
                startActivity(intent);
            }
        });

        button2 = (Button)findViewById(R.id.buttonEscolherSubCategoriaEletrodomesticos);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscolherSubCategoriaAssistenciaTecnica.this, FormCadastroProfissional.class);
                startActivity(intent);
            }
        });

        button3 = (Button)findViewById(R.id.buttonEscolherSubCategoriaInformaticaeTelefonia);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscolherSubCategoriaAssistenciaTecnica.this, FormCadastroProfissional.class);
                startActivity(intent);
            }
        });

    }
}
