package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;

public class EscolherSubCategoriaReformasReparos extends AppCompatActivity {

    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_sub_categoria_reformas_reparos);

        button = (Button)findViewById(R.id.buttonEscolherSubCategoriaConstrucao);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscolherSubCategoriaReformasReparos.this, FormCadastroProfissional.class);
                startActivity(intent);
            }
        });

        button2 = (Button)findViewById(R.id.buttonEscolherSubCategoriaServicosGerais);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscolherSubCategoriaReformasReparos.this, FormCadastroProfissional.class);
                startActivity(intent);
            }
        });

    }
}
