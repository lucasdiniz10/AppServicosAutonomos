package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;

public class EscolherCategoria extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_categoria);

        button = (Button)findViewById(R.id.buttonEscolherCategoriaAssistenciaTecnica);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscolherCategoria.this, EscolherSubCategoriaAssistenciaTecnica.class);
                startActivity(intent);
            }
        });

    }
}
