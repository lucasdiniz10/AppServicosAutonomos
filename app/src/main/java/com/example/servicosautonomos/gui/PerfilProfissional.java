package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.Profissional;

public class PerfilProfissional extends AppCompatActivity {

    TextView nome, telefone, endereco, dataNasc, email, servicoOferecido, descricao, dinheiro, cartaoCredito, cartaoDebito;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_profissional);

        final Profissional profissional = getIntent().getExtras().getParcelable("dados");

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

        button = findViewById(R.id.buttonFinalizarCadastro);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);


                String mEmailAddress = profissional.email;
                String mPhoneNumber = profissional.telefone;

                intent.putExtra(ContactsContract.Intents.Insert.EMAIL, mEmailAddress)
                        .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                        .putExtra(ContactsContract.Intents.Insert.PHONE, mPhoneNumber)
                        .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK);
                startActivity(intent);
            }
        });

    }
}
