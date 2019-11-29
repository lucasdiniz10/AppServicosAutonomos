package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.Profissional;

public class EditarPerfilProfissional extends AppCompatActivity {

    TextView nome, telefone, cpf, endereco, dataNasc, email, servicoOferecido, descricao, dinheiro, cartaoCredito, cartaoDebito;
    Button buttonEditar, buttonDeletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil_profissional);

        final Profissional profissional = getIntent().getExtras().getParcelable("dados");

        nome = findViewById(R.id.textViewNome);
        telefone = findViewById(R.id.textViewTelefone);
        cpf = findViewById(R.id.textViewCpf);
        dataNasc = findViewById(R.id.textViewDataNascimento);
        endereco = findViewById(R.id.textViewEndereco);
        email = findViewById(R.id.textViewEmail);
        servicoOferecido = findViewById(R.id.textViewServicosOferecidos);
        dinheiro = findViewById(R.id.textViewPagamentoDinheiro);
        cartaoCredito = findViewById(R.id.textViewPagamentoCredito);
        cartaoDebito = findViewById(R.id.textViewPagamentoDebito);
        descricao = findViewById(R.id.textViewDescricao);

        nome.setText(profissional.nome);
        telefone.setText(profissional.telefone);
        cpf.setText(profissional.cpf);
        dataNasc.setText(profissional.dataNasc);
        endereco.setText(profissional.endereco);
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


        buttonEditar = findViewById(R.id.buttonEditarPerfil);

        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditarPerfilProfissional.this, AlterarDadosProfissional.class);
                startActivity(intent);
            }
        });


        buttonDeletar = findViewById(R.id.buttonDeletarPerfil);

        // FALTA AQUI
        buttonDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
