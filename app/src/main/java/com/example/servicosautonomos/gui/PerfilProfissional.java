package com.example.servicosautonomos.gui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.Profissional;

public class PerfilProfissional extends AppCompatActivity {

    TextView nome, telefone, endereco, dataNasc, email, servicoOferecido, formaDePagamento;

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
        formaDePagamento = findViewById(R.id.textViewFormasDePagamento);

        nome.setText(profissional.nome);




    }
}
