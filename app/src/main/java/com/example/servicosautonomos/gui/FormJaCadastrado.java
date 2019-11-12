package com.example.servicosautonomos.gui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormJaCadastrado extends AppCompatActivity {

    EditText editTextLogin, editTextSenha;
    Button buttonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ja_cadastrado);


        this.buttonLogin = findViewById(R.id.buttonLogin);

        //acessando o firebase para listar
        FirebaseApp.initializeApp(FormJaCadastrado.this);
        FirebaseDatabase bd = FirebaseDatabase.getInstance();
        final DatabaseReference bdRef = bd.getReference();
        FirebaseDatabase.getInstance().getReference("contratante");

        /*{
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    contratante = new ArrayList<>();
                    //listView.setAdapter(null);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Usuario usu = snapshot.getValue(Usuario.class);
                        usu.ID = snapshot.getKey();
                        usuarios.add(usu);
                    }
                    UsuarioAdapter adapter = new UsuarioAdapter(MainActivity.this, usuarios);
                    listView.setAdapter(adapter);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
        */

        buttonLogin.setOnClickListener(new View.OnClickListener() {

            EditText editTextLogin, editTextSenha;

            @Override
            public void onClick(View v) {

                this.editTextLogin = findViewById(R.id.editTextLogin);
                this.editTextSenha = findViewById(R.id.editTextSenha);

                adicionaValidacao(editTextLogin);
                adicionaValidacao(editTextSenha);
            }

            //método para validar, levando tbm o foco para o campo
            private void adicionaValidacao(final EditText campo) {
                campo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        final String texto = campo.getText().toString().trim();
                        if (texto.isEmpty()){
                            campo.setError("Campo obrigatório");
                        }
                    }
                });
            }
        });

    }
}