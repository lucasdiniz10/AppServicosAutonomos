package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;

public class ListaDeServicos extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_servicos);

        button = findViewById(R.id.aparelhosEletronic);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaDeServicos.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }

}
