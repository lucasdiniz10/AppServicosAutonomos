package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.Profissional;

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
                Profissional profissional = new Profissional();
                profissional.nome = "0";
                profissional.telefone = "0";
                profissional.cpf = "0";
                profissional.dataNasc = "0";
                profissional.email = "0";
                profissional.senha = "0";
                profissional.endereco = "0";
                profissional.descricao = "0";
                profissional.categoria = "Tecnologia";
                profissional.latitude = Double.valueOf(0);
                profissional.longitude = Double.valueOf(0);
                profissional.dinheiro = true;
                profissional.cartaoDebito = true;
                profissional.cartaoCredito = true;

                Intent intent = new Intent(EscolherSubCategoriaDesignTecnologia.this, FormCadastroProfissional.class);
                intent.putExtra("Categoria", profissional);
                startActivity(intent);
            }
        });

        button2 = (Button)findViewById(R.id.buttonEscolherSubCategoriaGrafica);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profissional profissional = new Profissional();
                profissional.nome = "0";
                profissional.telefone = "0";
                profissional.cpf = "0";
                profissional.dataNasc = "0";
                profissional.email = "0";
                profissional.senha = "0";
                profissional.endereco = "0";
                profissional.descricao = "0";
                profissional.categoria = "Gráfica";
                profissional.latitude = Double.valueOf(0);
                profissional.longitude = Double.valueOf(0);
                profissional.dinheiro = true;
                profissional.cartaoDebito = true;
                profissional.cartaoCredito = true;

                Intent intent = new Intent(EscolherSubCategoriaDesignTecnologia.this, FormCadastroProfissional.class);
                intent.putExtra("Categoria", profissional);
                startActivity(intent);
            }
        });

        button3 = (Button)findViewById(R.id.buttonEscolherSubCategoriaAudioVisual);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profissional profissional = new Profissional();
                profissional.nome = "0";
                profissional.telefone = "0";
                profissional.cpf = "0";
                profissional.dataNasc = "0";
                profissional.email = "0";
                profissional.senha = "0";
                profissional.endereco = "0";
                profissional.descricao = "0";
                profissional.categoria = "Áudio/Visual";
                profissional.latitude = Double.valueOf(0);
                profissional.longitude = Double.valueOf(0);
                profissional.dinheiro = true;
                profissional.cartaoDebito = true;
                profissional.cartaoCredito = true;

                Intent intent = new Intent(EscolherSubCategoriaDesignTecnologia.this, FormCadastroProfissional.class);
                intent.putExtra("Categoria", profissional);
                startActivity(intent);
            }
        });
    }
}
