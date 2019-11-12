package com.example.servicosautonomos.gui;

import android.os.Bundle;
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


    }


}