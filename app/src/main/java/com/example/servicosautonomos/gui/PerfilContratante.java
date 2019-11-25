package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.Contratante;

public class PerfilContratante extends AppCompatActivity {

    TextView textViewNomeContratante, textViewNomeCompleto, textViewTelefone, textViewEndereco,
            textViewDatanascimento, textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_contratante);


        textViewNomeContratante = findViewById(R.id.textViewNomeContratante);
        textViewNomeCompleto = findViewById(R.id.textViewNome);
        textViewTelefone = findViewById(R.id.textViewTelefone);
        textViewEndereco = findViewById(R.id.textViewEndereco);
        textViewDatanascimento = findViewById(R.id.textViewDataNascimento);
        textViewEmail = findViewById(R.id.textViewDataNascimento);

        Intent intent = getIntent();
        Contratante contratante = intent.getParcelableExtra("perfil");

        String nome = contratante.getNome();
        String nomeCompleto = contratante.getNome();
        String telefone = contratante.getTelefone();
        String endereco = contratante.getEndereco();
        String data = contratante.getNascimento();
        String email = contratante.getEmail();

        textViewNomeContratante.setText(nome);
        textViewNomeCompleto.setText(nomeCompleto);
        textViewTelefone.setText(telefone);
        textViewEndereco.setText(endereco);
        textViewDatanascimento.setText(data);
        textViewEmail.setText(email);

    }
}
