package com.example.servicosautonomos.gui;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.Profissional;

public class EditarPerfilProfissional extends AppCompatActivity {

    TextView nome, telefone, cpf, endereco, dataNasc, email, servicoOferecido, descricao, dinheiro, cartaoCredito, cartaoDebito;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil_profissional);

        final Profissional profissional = getIntent().getExtras().getParcelable("dados");

        nome = findViewById(R.id.textViewNome);
        telefone = findViewById(R.id.textViewTelefone);
        cpf = findViewById(R.id.textViewCpf);
        dataNasc = findViewById(R.id.textViewDataNascimento);
        email = findViewById(R.id.textViewEmail);
        endereco = findViewById(R.id.textViewEndereco);
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

        button = findViewById(R.id.buttonFinalizarCadastro);

    }
}
