package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.Profissional;

public class EscolherSubCategoriaAssistenciaTecnica extends AppCompatActivity {

    Button button,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_sub_categoria_assistencia_tecnica);

        button = findViewById(R.id.buttonEscolherSubCategoriaDescricaoAparelhosEletronicos);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Referenciando a categoria escolhida, e enviando pelo Parcelable
                Profissional profissional = new Profissional();
                profissional.nome = "0";
                profissional.telefone = "0";
                profissional.cpf = "0";
                profissional.dataNasc = "0";
                profissional.email = "0";
                profissional.senha = "0";
                profissional.descricao = "0";
                profissional.endereco = "0";
                profissional.categoria = "aparelhosEletronicos";
                profissional.latitude = (double) 0;
                profissional.longitude = (double) 0;
                profissional.dinheiro = true;
                profissional.cartaoDebito = true;
                profissional.cartaoCredito = true;

                Intent intent = new Intent(EscolherSubCategoriaAssistenciaTecnica.this, FormCadastroProfissional.class);
                intent.putExtra("Categoria", profissional);
                startActivity(intent);
            }
        });

        button2 = findViewById(R.id.buttonEscolherSubCategoriaEletrodomesticos);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Referenciando a categoria escolhida, e enviando pelo Parcelable
                Profissional profissional = new Profissional();
                profissional.nome = "0";
                profissional.telefone = "0";
                profissional.cpf = "0";
                profissional.dataNasc = "0";
                profissional.email = "0";
                profissional.senha = "0";
                profissional.endereco = "0";
                profissional.descricao = "0";
                profissional.categoria = "eletrodomesticos";
                profissional.latitude = (double) 0;
                profissional.longitude = (double) 0;
                profissional.dinheiro = true;
                profissional.cartaoDebito = true;
                profissional.cartaoCredito = true;

                Intent intent = new Intent(EscolherSubCategoriaAssistenciaTecnica.this, FormCadastroProfissional.class);
                intent.putExtra("Categoria", profissional);
                startActivity(intent);
            }
        });

        button3 = findViewById(R.id.buttonEscolherSubCategoriaInformaticaeTelefonia);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Referenciando a categoria escolhida, e enviando pelo Parcelable
                Profissional profissional = new Profissional();
                profissional.nome = "0";
                profissional.telefone = "0";
                profissional.cpf = "0";
                profissional.dataNasc = "0";
                profissional.email = "0";
                profissional.senha = "0";
                profissional.endereco = "0";
                profissional.descricao = "0";
                profissional.categoria = "Informática e Telefonia";
                profissional.latitude = (double) 0;
                profissional.longitude = (double) 0;
                profissional.dinheiro = true;
                profissional.cartaoDebito = true;
                profissional.cartaoCredito = true;

                Intent intent = new Intent(EscolherSubCategoriaAssistenciaTecnica.this, FormCadastroProfissional.class);
                intent.putExtra("Categoria", profissional);
                startActivity(intent);
            }
        });

    }
}
