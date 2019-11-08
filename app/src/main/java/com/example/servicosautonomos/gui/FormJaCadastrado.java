package com.example.servicosautonomos.gui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.Usuario;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormJaCadastrado extends AppCompatActivity {

    EditText editTextLogin, editTextSenha;
    Button buttonLogin;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ja_cadastrado);


        this.buttonLogin = findViewById(R.id.buttonEscolherCategoriaAssistenciaTecnica);

        //acessando o firebase para listar
        FirebaseApp.initializeApp(FormJaCadastrado.this);
        FirebaseDatabase bd = FirebaseDatabase.getInstance();
        final DatabaseReference bdRef = bd.getReference();
        FirebaseDatabase.getInstance().getReference("usuarios"); /*{
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    usuarios = new ArrayList<>();
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

                final String email = editTextLogin.getText().toString();
                final String senha = editTextSenha.getText().toString();


                Usuario usuario = new Usuario();

                usuario.email = editTextLogin.getText().toString();
                usuario.senha = editTextSenha.getText().toString();

                bdRef.child("usuarios").push().setValue(usuario);

                Toast.makeText(FormJaCadastrado.this,"Usuário cadastrado com sucesso",Toast.LENGTH_LONG).show();
                editTextLogin.setText("");
                editTextSenha.setText("");


            }
        });
    }


}