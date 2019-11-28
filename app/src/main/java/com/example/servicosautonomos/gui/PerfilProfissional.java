package com.example.servicosautonomos.gui;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.Profissional;

public class PerfilProfissional extends AppCompatActivity {

    TextView nome, telefone, endereco, dataNasc, email, servicoOferecido, descricao, dinheiro, cartaoCredito, cartaoDebito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_profissional);

        Profissional profissional = getIntent().getExtras().getParcelable("dados");

        nome = findViewById(R.id.textViewNome);
        telefone = findViewById(R.id.textViewTelefone);
        endereco = findViewById(R.id.textViewEndereco);
        dataNasc = findViewById(R.id.textViewDataNascimento);
        email = findViewById(R.id.textViewEmail);
        servicoOferecido = findViewById(R.id.textViewServicosOferecidos);
        dinheiro = findViewById(R.id.textViewPagamentoDinheiro);
        cartaoCredito = findViewById(R.id.textViewPagamentoCredito);
        cartaoDebito = findViewById(R.id.textViewPagamentoDebito);
        descricao = findViewById(R.id.textViewDescricao);

        nome.setText(profissional.nome);
        telefone.setText(profissional.telefone);
        endereco.setText(profissional.endereco);
        dataNasc.setText(profissional.dataNasc);
        email.setText(profissional.email);
        servicoOferecido.setText(profissional.categoria);
        descricao.setText(profissional.descricao);

        if (profissional.dinheiro == false){
            dinheiro.setTextColor(Color.parseColor("#cecece"));
        }

        if (profissional.cartaoDebito == false){
            cartaoDebito.setTextColor(Color.parseColor("#cecece"));
        }

        if (profissional.cartaoCredito == false){
            cartaoCredito.setTextColor(Color.parseColor("#cecece"));
        }




    }
}
